package com.yws.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yws.pojo.Discussion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DiscussionMapper extends BaseMapper<Discussion> {

}
