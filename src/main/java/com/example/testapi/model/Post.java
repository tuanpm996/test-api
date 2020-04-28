package com.example.testapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String wallProfileId;
    private String actorId;
    private String actorName;
    private String content;
    private long postTime;
    private String url;
    private String type;
    private String outsideUrl;
    private long likeCount;
    private long commentCount;
    private long shareCount;
    private long createTime;
    private long updateTime;
    private String imageSources;
    private String videoSources;
    private boolean isHasVideo = false;
    private boolean isHasImage = false;
    private String videoIds;

}
