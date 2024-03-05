package com.yws.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yws.mapper.DiscussionMapper;
import com.yws.pojo.Discussion;
import com.yws.service.DiscussService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public class DiscussionServiceImpl extends ServiceImpl<DiscussionMapper, Discussion> implements DiscussService {

}
