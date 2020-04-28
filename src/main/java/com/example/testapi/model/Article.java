package com.example.testapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {

    private String title;

    private String summary;

    private String content;

    private String location;

    private String created_time;

//    @SerializedName(value = "lastUpdatedTime", alternate = "last_updated_time")
//    private Date last_updated_time;
}
