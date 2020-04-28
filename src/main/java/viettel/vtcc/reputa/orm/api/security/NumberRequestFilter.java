package viettel.vtcc.reputa.orm.api.security;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import net.arnx.jsonic.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import viettel.vtcc.reputa.orm.api.model.LimitRequest;
import viettel.vtcc.reputa.orm.api.model.UserRequest;
import viettel.vtcc.reputa.orm.api.repository.LimitRequestRepository;
import viettel.vtcc.reputa.orm.api.repository.UserRequestRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class NumberRequestFilter extends OncePerRequestFilter {

    private UserRequestRepository userRequestRepository;

    private LimitRequestRepository limitRequestRepository;

    public NumberRequestFilter(UserRequestRepository userRequestRepository, LimitRequestRepository limitRequestRepository) {
        this.userRequestRepository = userRequestRepository;
        this.limitRequestRepository = limitRequestRepository;
    }


    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        Authentication authenticationObject = SecurityContextHolder.getContext().getAuthentication();
        if (authenticationObject == null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        String user = authenticationObject.getPrincipal().toString();
        String uri = httpServletRequest.getRequestURI();
        String id = user + "|" + uri;


        synchronized (userRequestRepository) {
            UserRequest userRequest = userRequestRepository.findById(id).orElse(null);
            if (userRequest == null) {
                userRequest = new UserRequest();
                userRequest.setId(id);
                userRequest.setUsername(user);
                userRequest.setEndpoint(uri);
                userRequest.setCount(0);
            }
            userRequest.setCount(userRequest.getCount() + 1);
            userRequest = userRequestRepository.save(userRequest);
            log.info("user request: {}", JSON.encode(userRequest));
            LimitRequest limitRequest = limitRequestRepository.findById(uri).orElse(null);
            if (limitRequest != null) {
                if (userRequest.getCount() > limitRequest.getTime()) {
                    JsonObject responseContent = new JsonObject();
                    responseContent.addProperty("message", "Limit request reached");
                    httpServletResponse.getWriter().println(responseContent.toString());
                    httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    return;
                }
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
