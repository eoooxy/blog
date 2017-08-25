package com.doliao.controller;

import com.doliao.constant.Constant;
import com.doliao.po.ArticleMsgPo;
import com.doliao.po.CommentPo;
import com.doliao.service.ArticleService;
import com.doliao.service.CommentService;
import com.doliao.service.TagService;
import com.doliao.service.TypeService;
import com.doliao.vo.*;
import com.utils.ConvertUtil;
import com.utils.DateUtil;
import com.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-16 下午12:30
 */
@Controller
public class ArticleController {

    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/article")
    public String article(ModelMap modelMap, Integer recid, HttpServletRequest request) throws IOException {
        List<TagVo> tagVos = JacksonUtil.toListObject(stringRedisTemplate.opsForValue().get(Constant.TAGVOS), TagVo.class);
        List<TypeVo> typeVos = JacksonUtil.toListObject(stringRedisTemplate.opsForValue().get(Constant.TYPEVOS), TypeVo.class);

        List<ArticleVo> fileAtticles = ConvertUtil.convertDtoAndVo(articleService.getArticleList(), ArticleVo.class);
        List<FileVo> fileVos = JacksonUtil.toListObject(stringRedisTemplate.opsForValue().get(Constant.FILEVOS), FileVo.class);
//        articleService.getFileList(fileAtticles, fileVos);

        ArticleVo article = (ArticleVo) ConvertUtil.convertDtoAndVo(articleService.getArticle(recid), ArticleVo.class);

        //判断是否有上一篇
        ArticleVo preArticle = null;
        //判断是否有下一篇
        ArticleVo nextArticle = null;
        if (fileAtticles.size() > 0) {
            //上一篇以及下一篇文章
            Integer curIndex = 0;
            for (int i = 0; i < fileAtticles.size(); i++) {
                if (fileAtticles.get(i).getRecid() == article.getRecid()) {
                    curIndex = i;
                    break;
                }
            }
            if (curIndex > 0) {
                preArticle = fileAtticles.get(curIndex - 1);
            } else {
                preArticle = null;
            }
            if (curIndex + 1 == fileAtticles.size()) {
                nextArticle = null;
            } else {
                nextArticle = fileAtticles.get(curIndex + 1);
            }
        }

        List<String> types = typeService.getTypeListByArtId(recid);
        List<String> tags = tagService.getTagListByArtId(recid);
        article.setTypes(types);
        article.setTags(tags);

        //编辑标签是否展示
        String mark = (String) request.getSession().getAttribute(Constant.MASTER);
        boolean isMaster = null != mark && mark.equals(Constant.MASTER_MARK) ? true : false;
        Integer uuid = (Integer) request.getSession().getAttribute(Constant.UUID);

        List<CommentVo> commentVos = commentService.getCommentList(recid);

        modelMap.put("isMaster", isMaster);
        modelMap.put("article", article);
        modelMap.put("fileVos", fileVos);
        modelMap.put("tagVos", tagVos);
        modelMap.put("typeVos", typeVos);
        modelMap.put("preArticle", preArticle);
        modelMap.put("nextArticle", nextArticle);
        modelMap.put("uuid", uuid);
        modelMap.put("commentVos", commentVos);
        modelMap.put("userinfo", request.getSession().getAttribute(Constant.USER_INFO));

        return "article";
    }


    @RequestMapping(value = "/remsg")
    @ResponseBody
    public MessageVo articleMsg(CommentVo commentVo, Integer articleid) {
        MessageVo messageVo = new MessageVo();
        CommentPo commentPo = (CommentPo) ConvertUtil.convertDtoAndVo(commentVo, CommentPo.class);
        commentPo.setCreatetime(DateUtil.formatDate(new Date()));
        int msgId = commentService.insertCommentRecId(commentPo);
        if (msgId < 0) {
            messageVo.setCode(Constant.ERROR_CODE);
            messageVo.setMsg("插入错误，请联系管理员");
            return messageVo;
        }
        ArticleMsgPo articleMsgPo = new ArticleMsgPo();
        articleMsgPo.setMsgid(msgId);
        articleMsgPo.setArticleid(articleid);
        if (commentService.insertArticleMsg(articleMsgPo) > 0) {
            messageVo.setCode(Constant.SUCCESS_CODE);
            return messageVo;
        }
        messageVo.setCode(Constant.ERROR_CODE);
        messageVo.setMsg("插入错误，请联系管理员");
        return messageVo;
    }
}
