package com.yws.service.quick;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yws.mapper.ProblemMapper;
import com.yws.pojo.Problems;
import com.yws.service.IProblemService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IProblemServiceImple extends ServiceImpl<ProblemMapper,Problems> implements IProblemService {

    @Autowired
    private ProblemMapper problemMapper;
    @Override
    public IPage<Problems> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        problemMapper.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Problems> getPage(int currentPage, int pageSize, Problems prob) {
        IPage page = new Page(currentPage,pageSize);
        LambdaQueryWrapper<Problems> lqw = new LambdaQueryWrapper<>();
        lqw.like(prob.getId()>0,Problems::getId,prob.getId());
        lqw.like(Strings.isNotEmpty(prob.getTag()),Problems::getTag,prob.getTag());
        lqw.like(Strings.isNotEmpty(prob.getPbname()),Problems::getPbname,prob.getPbname());
        problemMapper.selectPage(page,lqw);
        return page;
    }
}
