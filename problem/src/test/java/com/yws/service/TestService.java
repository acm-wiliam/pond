package com.yws.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yws.pojo.Problems;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestService {
    @Autowired
    private IProblemService problemService;
    @Test
    void testGetById(){
        System.out.println(problemService.getById(2));
    }
    @Test
    void testSave(){
        Problems p=new Problems();
        p.setId(4);
        p.setPbname("三数之和");
        p.setSource("LeetCode");
        p.setTag("数组");
        p.setDescription("测试123");
        p.setInput("测试123");
        p.setOutput("测试123");
        System.out.println(problemService.save(p));
    }
    @Test
    void testGetAll(){
        System.out.println(problemService.list());
    }
    @Test
    void testGetPaeg(){
        IPage<Problems> page = problemService.getPage(2, 3);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
    }
}
