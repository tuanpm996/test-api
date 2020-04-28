package viettel.vtcc.reputa.orm.api;

import com.example.testapi.TestApiApplication;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Response;
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
import viettel.vtcc.reputa.orm.api.model.LimitRequest;
import viettel.vtcc.reputa.orm.api.repository.LimitRequestRepository;
import viettel.vtcc.reputa.orm.api.repository.UserRequestRepository;
import viettel.vtcc.reputa.orm.api.security.JWTAuthorizationFilter;
import viettel.vtcc.reputa.orm.api.util.HttpAction;
import viettel.vtcc.reputa.orm.api.util.Request;

import java.io.IOException;
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

    @Autowired
    private LimitRequestRepository limitRequestRepository;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(SpringbootAuthUpdatedApplication.class);
        Thread.sleep(1000);
        sendRequest();
    }

    private static void sendRequest() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", "tuanpm34");
        jsonObject.addProperty("password", "test");
        Map<String, Map<String, List<String>>> response = HttpAction.sendRequest(Request.builder().method("POST").url("http://localhost:8080/users/sign-up").parameters(jsonObject.toString()).build());
        Map<String, Map<String, List<String>>> response2 = HttpAction.sendRequest(Request.builder().method("POST").url("http://localhost:8080/login").parameters(jsonObject.toString()).build());

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                OkHttpClient client = new OkHttpClient();
                response2.entrySet().forEach(v -> {
                    okhttp3.Request request = new okhttp3.Request.Builder()
                            .url("http://localhost:8080/contacts")
                            .addHeader("Authorization", v.getValue().get("Authorization").get(0))
                            .build();
                    try (Response responseTest = client.newCall(request).execute()) {
                        log.info("message: {}, status: {}", responseTest.body().string().trim(), responseTest.code());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });


            }).start();
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
        limitRequestRepository.save(new LimitRequest("/contacts", 500));
    }
}
