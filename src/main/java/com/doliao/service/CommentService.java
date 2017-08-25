package com.doliao.service;

import com.doliao.po.ArticleMsgPo;
import com.doliao.po.CommentPo;
import com.doliao.vo.CommentVo;

import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-26 下午4:32
 */
public interface CommentService {

    List<CommentVo> getCommentList(Integer articleid);

    int insertCommentRecId(CommentPo commentPo);

    int insertArticleMsg(ArticleMsgPo articleMsgPo);
}
