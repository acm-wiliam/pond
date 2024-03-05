package com.yws.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yws.pojo.Problems;
import com.yws.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping("/problem")
public class ProblemsController2 {

    @Autowired
    private IProblemService problemService;

    /**
     * 查询为get请求
     * 插入为post请求
     * 更新为put请求
     * 删除为delete请求
     *
     */
//    @PostMapping      //其中为请求体参数      更新删除都一样
//    public Boolean save(@RequestBody Problems problems){
//        return problemService.save(problems);
//    }

    @GetMapping("{id}")
    public Problems getById(@PathVariable int id){
        return problemService.getById(id);
    }

    @GetMapping
    public List<Problems> getAll(){
        return problemService.list();
    }

    @GetMapping("{currentpage}/{pagesize}")
    public IPage<Problems> getById(@PathVariable int currentpage, @PathVariable int pagesize){
        return problemService.getPage(currentpage,pagesize);
    }
}
