package com.doliao.service.impl;

import com.doliao.mapper.CommentPoMapper;
import com.doliao.service.CommentService;
import com.doliao.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-26 下午4:32
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentPoMapper commentPoMapper;

    @Override
    public List<CommentVo> getCommentList(Integer articleid) {
        return commentPoMapper.getCommentsByArtId(articleid);
    }
}
