package viettel.vtcc.reputa.orm.api;

import com.example.testapi.TestApiApplication;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import viettel.vtcc.reputa.orm.api.controller.UserController;
import viettel.vtcc.reputa.orm.api.repository.UserRequestRepository;
import viettel.vtcc.reputa.orm.api.security.JWTAuthorizationFilter;
import viettel.vtcc.reputa.orm.api.util.HttpAction;
import viettel.vtcc.reputa.orm.api.util.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "viettel.vtcc.reputa.orm.api")
@EnableTransactionManagement
public class SpringbootAuthUpdatedApplication implements CommandLineRunner {

    @Autowired
    private UserRequestRepository userRequestRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAuthUpdatedApplication.class);
        sendRequest();

    }

    private static void sendRequest() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty ("username", "tuanpm34");
        jsonObject.addProperty ("password", "test");
//        HttpAction.sendRequest(Request.builder().method("POST").url("http://localhost:8080/users/sign-up").build());
        Map<String, Map<String, List<String>>> response = HttpAction.sendRequest(Request.builder().method("POST").url("http://localhost:8080/users/sign-up").parameters(jsonObject.toString()).build());
        Map<String, Map<String, List<String>>> response2 = HttpAction.sendRequest(Request.builder().method("POST").url("http://localhost:8080/login").parameters(jsonObject.toString()).build());
        Map<String, String> headers = new HashMap<>();

        response2.entrySet().forEach(v -> {
            log.info("{}", v.getValue().get("Authorization").get(0));
            headers.put(v.getKey(), v.getValue().get("Authorization").get(0));
        });
//        HttpAction.sendRequest(Request.builder().method("GET").url("http://localhost:8080/contacts").headers(headers).build());


        for(int i = 0; i < 1; i++) {
            log.info("i: {}", i);
            new Thread(()->{
                HttpAction.sendRequest(Request.builder().method("GET").url("http://localhost:8080/contacts").headers(headers).build());
            }).start();
            log.info("-end-");
        }
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName("localhost");
        jedisConFactory.setPort(6379);
        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("{}", userRequestRepository.findByUsername("sdfddf"));
    }
}
