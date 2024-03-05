package com.yws;

import com.yws.service.DiscussService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestApplication {

    @Autowired
    private DiscussService discussService;

    @Test
    void testGetAll(){
        System.out.println(discussService.list());
    }



}
