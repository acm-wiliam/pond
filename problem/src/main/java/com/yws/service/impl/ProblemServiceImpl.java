package com.yws.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yws.mapper.ProblemMapper;
import com.yws.pojo.Problems;
import com.yws.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;

//    @Override
//    public boolean queryById(long id) {
//        return problemMapper.selectById(id)!=null;
//    }

    @Override   //获取单个题目
    public Problems getById(long id) {
        return problemMapper.selectById(id);
    }

    @Override   //插入题目
    public boolean save(Problems phs) {
        return problemMapper.insert(phs)>0;
    }

    @Override   //获取全部题目
    public List<Problems> getAll() {
        return problemMapper.selectList(null);
    }

    @Override
    public IPage<Problems> getPage(int currentpage, int pagesize) {
        IPage page = new Page(currentpage,pagesize);
        return problemMapper.selectPage(page,null);
    }
}
