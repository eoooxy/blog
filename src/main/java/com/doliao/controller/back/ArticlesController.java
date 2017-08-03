package com.doliao.controller.back;

import com.doliao.constant.Constant;
import com.doliao.po.ArticlePo;
import com.doliao.service.ArticleService;
import com.doliao.vo.MessageVo;
import com.doliao.vo.PageVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * author： xueyuan
 * date  ： 2017-07-16 下午12:30
 */
@Controller
@RequestMapping(value = "/back")
public class ArticlesController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/article")
    public String article(ModelMap modelMap, PageVo pageVo, HttpServletRequest request) {
        PageInfo pageInfo = articleService.getAllArticle(pageVo);

        modelMap.put("loginInfo", request.getSession().getAttribute(Constant.LOGIN_INFO));
        modelMap.put("pageInfo", pageInfo);

        return "/back/article";
    }

    @RequestMapping(value = "/article/del")
    @ResponseBody
    public MessageVo del(ModelMap modelMap, Integer recid, HttpServletRequest request) {
        MessageVo messageVo = new MessageVo();
        ArticlePo articlePo = new ArticlePo();
        articlePo.setRecid(recid);
        articlePo.setStatus(0);
        articleService.delAndShowArt(articlePo);
        messageVo.setCode(Constant.SUCCESS_CODE);
        messageVo.setMsg("文章状态更改成功，当前状态自己可见！");

        return messageVo;
    }

    @RequestMapping(value = "/article/show")
    @ResponseBody
    public MessageVo show(ModelMap modelMap, Integer recid, HttpServletRequest request) {
        MessageVo messageVo = new MessageVo();
        ArticlePo articlePo = new ArticlePo();
        articlePo.setRecid(recid);
        articlePo.setStatus(1);
        articleService.delAndShowArt(articlePo);
        messageVo.setCode(Constant.SUCCESS_CODE);
        messageVo.setMsg("文章状态更改成功，当前状态所有人可见！");

        return messageVo;
    }

}
