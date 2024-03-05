package com.yws.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yws.pojo.Problems;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProblemMapper extends BaseMapper<Problems> {
//    自己写的查询
//    @Select("select * from problems where id= #{id}")
//    public Problems getById(Integer id);
}
