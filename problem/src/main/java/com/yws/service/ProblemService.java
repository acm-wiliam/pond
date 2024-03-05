package com.yws.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yws.pojo.Problems;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProblemService {

//    public boolean queryById(long id);
    Problems getById(long id);
    boolean save(Problems phs);
    List<Problems> getAll();
    IPage<Problems> getPage(int currentpage,int pagesize);
}
