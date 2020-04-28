package com.example.testapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Sms {
    private String function;
    private String message;
    @JsonProperty("user_send")
    private String userSend;
    @JsonProperty("list_phones")
    private String listPhones;
}
