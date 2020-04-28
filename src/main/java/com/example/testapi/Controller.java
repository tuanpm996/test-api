package com.example.testapi;

import com.example.testapi.model.Article;
import com.example.testapi.model.EsFacebookObject;
import com.example.testapi.model.FacebookObject;
import com.example.testapi.model.Sms;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.sun.javafx.collections.MappingChange;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.arnx.jsonic.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;


@Slf4j
@RestController
public class Controller {

    @PostMapping("/monitor")
    public ResponseEntity<String> getUrlFacebook(@RequestBody String body_message, HttpServletRequest request) {
        String host_request = request.getRemoteAddr();
//        String response = Constants.RESPONSE_DEFAULT_FAILED.getResponseFailed(body_message);
        try {
            body_message = URLDecoder.decode(body_message, "UTF-8");
            log.info("Receive request from {} with body message: {}", host_request, body_message);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/test")
    public Object test(@RequestBody List<Article> articles) {
        log.info("article: {}", articles);
        return ResponseEntity.status(HttpStatus.ACCEPTED).header("message", "test").body("Error Message");
    }
    @PostMapping("/objectTest")
    public Object objectTest(@RequestBody List<Article> articles) {
        log.info("article: {}", articles);
        return ResponseEntity.status(HttpStatus.ACCEPTED).header("message", "test").body("Error Message");
    }

    @PostMapping(value = "/test2")
    public ResponseEntity<String> test2(@RequestBody Sms test) throws InterruptedException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("EsFacebookObject: {}", objectMapper.writeValueAsString(test));
        return ResponseEntity.status(HttpStatus.OK).body("Error Message");
    }

    @PostMapping(value = "/api/crawl_comment")
    public ResponseEntity<String> testComment(@RequestBody HashMap<String, String> test) {
        log.info("test: {}", test);
        return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }

    @PostMapping(value = "/api/crawl_comment2")
    public ResponseEntity<String> testComment2(@RequestBody HashMap<String, String> test) {
        log.info("222222222: {}", test);
        return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }

    @PostMapping(value = "/query")
    public String reaction() throws InterruptedException {
        Thread.sleep(3000);
        String result = "[{\"id\":\"3190`094291013409\",\"like\":{\"status\":\"Done\",\"count\":2298},\"comment\":{\"status\":\"Done\",\"count\":2291},\"share\":{\"status\":\"Done\",\"count\":602}},{\"id\":\"144834090490193\",\"like\":{\"status\":\"Done\",\"count\":2298},\"comment\":{\"status\":\"Done\",\"count\":2291},\"share\":{\"status\":\"Done\",\"count\":602}}]";
        return result;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> pushData(@RequestBody FacebookObject data) {
        log.info("pushing data id: " + data.getId());
        try {
            assert data != null;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Error Message");

    }
}
