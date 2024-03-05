package com.yws.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yws.pojo.Discussion;
import com.yws.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.zip.DeflaterInputStream;


@RestController
@RequestMapping("/discuss")
public class DiscussionController {

    @Autowired
    private DiscussService discussService;

    @GetMapping
    public List<Discussion> getAll(){
        return discussService.list();
    }

//    @GetMapping("{id}")
//    public Discussion getById(@PathVariable int id){
//        return discussService.getById(id);
//    }

    //通过题目ID查询评论或讨论
    @GetMapping("{pid}")
    public List<Discussion> getByPid(@PathVariable int pid){
        LambdaQueryWrapper<Discussion> lqw = new LambdaQueryWrapper<>();
        lqw.like(pid>0,Discussion::getPid,pid);
        return discussService.list(lqw);
    }

    //增加评论
    @PostMapping("insert")
    public boolean insert(@RequestBody Discussion disc){
        disc.setTime(new Date());
        System.out.println(disc);
        return discussService.save(disc);
    }

    //通过id修改评论
    @PutMapping("{id}")
    public boolean modify(Discussion discussion){
        return discussService.updateById(discussion);
    }
}


