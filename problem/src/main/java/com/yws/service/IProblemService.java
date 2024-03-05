package com.yws.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yws.pojo.Problems;

public interface IProblemService extends IService<Problems> {
    IPage<Problems> getPage(int currentPage,int pageSize,Problems prob);

    IPage<Problems> getPage(int currentPage,int pageSize);
}
