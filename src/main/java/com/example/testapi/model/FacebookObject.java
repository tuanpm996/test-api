package com.example.testapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class FacebookObject implements Serializable {

    private String Id;
    private List<Post> listPost = new ArrayList<>();
    private String status_account;
    private boolean isActive;

}
