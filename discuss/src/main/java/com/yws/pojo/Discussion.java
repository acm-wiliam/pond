package com.yws.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
//@Component
public class Discussion {
    long id;
    long uid;
    long pid;
    String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date time;  //评论时间
    long to_uid;
}
