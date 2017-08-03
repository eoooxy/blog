package com.doliao.controller;

import com.doliao.constant.Constant;
import com.doliao.service.ArticleService;
import com.doliao.service.TagService;
import com.doliao.service.TypeService;
import com.doliao.vo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import com.utils.ConvertUtil;
import com.utils.FilterHtmlUtil;
import com.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-13 下午8:05
 */
@Controller
public class IndexController {


    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    ArticleService articleService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/")
    public String index(ModelMap modelMap, PageVo pageVo, HttpServletRequest request) throws IOException {
        List<TagVo> tagVos = new ArrayList<>();
        List<TypeVo> typeVos = new ArrayList<>();
        if (stringRedisTemplate.opsForValue().get(Constant.TAGVOS) == null) {
            tagVos = ConvertUtil.convertDtoAndVo(tagService.getTagList(), TagVo.class);
            stringRedisTemplate.opsForValue().set(Constant.TAGVOS, JacksonUtil.toJson(tagVos));
        } else {
            tagVos = JacksonUtil.toListObject(stringRedisTemplate.opsForValue().get(Constant.TAGVOS), TagVo.class);
        }
        if (stringRedisTemplate.opsForValue().get(Constant.TYPEVOS) == null) {
            typeVos = ConvertUtil.convertDtoAndVo(typeService.getTypeList(), TypeVo.class);
            stringRedisTemplate.opsForValue().set(Constant.TYPEVOS, JacksonUtil.toJson(typeVos));
        } else {
            typeVos = JacksonUtil.toListObject(stringRedisTemplate.opsForValue().get(Constant.TYPEVOS), TypeVo.class);
        }

        List<ArticleVo> fileAtticles = ConvertUtil.convertDtoAndVo(articleService.getArticleList(), ArticleVo.class);
        //判断是缓存中是否有，没有从数据库中计算，然后放到缓存中
        List<FileVo> fileVos = new ArrayList<>();
        if (stringRedisTemplate.opsForValue().get(Constant.FILEVOS) == null) {
            articleService.getFileList(fileAtticles, fileVos);
            stringRedisTemplate.opsForValue().set(Constant.FILEVOS, JacksonUtil.toJson(fileVos));
        } else {
            fileVos = JacksonUtil.toListObject(stringRedisTemplate.opsForValue().get(Constant.FILEVOS), FileVo.class);
        }


        PageInfo pageInfo = articleService.getArticleList(pageVo);
        List<ArticleVo> articleVos = ConvertUtil.convertDtoAndVo(pageInfo.getList(), ArticleVo.class);

        for (int i = 0; i < articleVos.size(); i++) {
            List<String> types = typeService.getTypeListByArtId(articleVos.get(i).getRecid());
            List<String> tags = tagService.getTagListByArtId(articleVos.get(i).getRecid());
            ArticleVo temp = articleVos.get(i);
            String convertContent = FilterHtmlUtil.delHTMLTag(temp.getContent());
            articleVos.get(i).setContent(convertContent.length() > 250 ? convertContent.substring(0, 250) : convertContent);
            articleVos.get(i).setTypes(types);
            articleVos.get(i).setTags(tags);
        }

        pageInfo.setList(articleVos);
        modelMap.put("fileVos", fileVos);
        modelMap.put("tagVos", tagVos);
        modelMap.put("typeVos", typeVos);
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("userinfo", request.getSession().getAttribute(Constant.USER_INFO));

        return "index";
    }

}
