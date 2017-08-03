package com.doliao.controller;

import com.doliao.constant.Constant;
import com.doliao.service.ArticleService;
import com.doliao.service.TagService;
import com.doliao.service.TypeService;
import com.doliao.vo.*;
import com.utils.ConvertUtil;
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
 * date  ： 2017-07-27 上午10:01
 */
@Controller
public class ArtFilterController {

    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    ArticleService articleService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/filter")
    public String artFilter(ModelMap modelMap, String keywords, String type, HttpServletRequest request) throws IOException {
        List<TagVo> tagVos = JacksonUtil.toListObject(stringRedisTemplate.opsForValue().get(Constant.TAGVOS), TagVo.class);
        List<TypeVo> typeVos = JacksonUtil.toListObject(stringRedisTemplate.opsForValue().get(Constant.TYPEVOS), TypeVo.class);

        List<ArticleVo> fileAtticles = ConvertUtil.convertDtoAndVo(articleService.getArticleList(), ArticleVo.class);
        List<FileVo> fileVos = JacksonUtil.toListObject(stringRedisTemplate.opsForValue().get(Constant.FILEVOS), FileVo.class);

        List<ArticleVo> filterArts = new ArrayList<>();
        String typeStr = "";
        switch (type) {
            case "type":
                if (articleService.filterTypeArts(keywords) != null) {
                    filterArts = ConvertUtil.convertDtoAndVo(articleService.filterTypeArts(keywords), ArticleVo.class);
                }
                typeStr = "按分类条件'" + keywords + "'筛选，结果为:";
                break;
            case "time":
                typeStr = "按归档时间'" + keywords + "'筛选，结果为:";
                if (articleService.filterTypeArts(keywords) != null) {
                    filterArts = ConvertUtil.convertDtoAndVo(articleService.filterTimeArts(keywords), ArticleVo.class);
                }
                break;
            case "tag":
                if (articleService.filterTypeArts(keywords) != null) {
                    filterArts = ConvertUtil.convertDtoAndVo(articleService.filterTagArts(keywords), ArticleVo.class);
                }
                typeStr = "按标签类型'" + keywords + "'筛选，结果为:";
                break;
        }

        ArtFilterVo artFilterVo = new ArtFilterVo();
        artFilterVo.setTitle(typeStr);
        artFilterVo.setVoList(filterArts);

        modelMap.put("fileVos", fileVos);
        modelMap.put("tagVos", tagVos);
        modelMap.put("typeVos", typeVos);
        modelMap.put("artFilterVo", artFilterVo);
        modelMap.put("userinfo", request.getSession().getAttribute(Constant.USER_INFO));

        return "filter";
    }
}
