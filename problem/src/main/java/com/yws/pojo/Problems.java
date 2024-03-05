package com.yws.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Problems {
    String pbname;
    long id;
    String description;
    String output;
    String input;
    String tag;
    String source;
}
