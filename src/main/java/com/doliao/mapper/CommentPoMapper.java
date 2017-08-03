package com.doliao.mapper;

import com.doliao.po.CommentPo;
import com.doliao.vo.CommentVo;
import com.utils.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentPoMapper extends MyMapper<CommentPo> {

    List<CommentVo> getCommentsByArtId(Integer articleid);
}