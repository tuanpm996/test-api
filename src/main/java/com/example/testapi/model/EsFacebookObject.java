package com.example.testapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EsFacebookObject implements Serializable,Cloneable{
//    String id;
//    public static final String TIME_PATTERN_LONG = "yyyy/MM/dd HH:mm:ss";
//    private static final long serialVersionUID = 1L;
//    private String postId;
//    private String domain;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_PATTERN_LONG)
//    private Date createdTime;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_PATTERN_LONG)
//    private Date postedTime;
//    private String content;
//    private String type;
//    private String imageSource;
//    private String videoSource;
//    private String videoId;
//    private String wallProfileId;
//    private String linkShare;
//    private long viewCount;
//    private long likeCount;
//    private long commentCount;
//    private long shareCount;
//    private String actorId;
//    private String actorName;

    private static final long serialVersionUID = 1L;
    private String id;
    private String postId;
    private String commentId;
    private String replyId;

    private String domain;
    private String createTime;
    private String postTime;

    private String content;
    private String type;
    private String typeAction;

    private String sourceImage;
    private String sourceVideo;
    private String videoIds;

    private String authorId;

    private String wallProfileId;
    private String wallProfileName;

    private String linkShare;
    private long viewCount;
    private long likeCount;
    private long commentCount;
    private long replyCount;
    private long shareCount;
    private String authorName;
    private String placePost;
    private String receive_time;
}
