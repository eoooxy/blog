package com.doliao.controller.back;

import com.doliao.constant.Constant;
import com.doliao.po.ArticlePo;
import com.doliao.po.ArticleTagPo;
import com.doliao.po.ArticleTypePo;
import com.doliao.service.*;
import com.doliao.vo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-13 下午8:05
 */
@Controller
@RequestMapping(value = "/back")
public class ConsoleController {

    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleTagService articleTagService;
    @Autowired
    ArticleTypeService articleTypeService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/console")
    public String console(ModelMap modelMap, Integer recid, HttpServletRequest request) {
        List<TagVo> tagVos = ConvertUtil.convertDtoAndVo(tagService.getTagList(), TagVo.class);
        List<TypeVo> typeVos = ConvertUtil.convertDtoAndVo(typeService.getTypeList(), TypeVo.class);

        ArticlePo articlePo = articleService.getArticle(recid);
        ArticleVo articleVo = new ArticleVo();
        if (articlePo != null) {
            ConvertUtil.convertDtoAndVo(articlePo, articleVo);
        }
        List<String> types = typeService.getTypeListByArtId(recid);
        List<String> tags = tagService.getTagListByArtId(recid);

        articleVo.setTypes(types);
        articleVo.setTags(tags);

        modelMap.put("tagVos", tagVos);
        modelMap.put("typeVos", typeVos);
        modelMap.put("articleVo", articleVo);
        modelMap.put("loginInfo", request.getSession().getAttribute(Constant.LOGIN_INFO));

        return "/back/console";
    }

    /**
     * 新增 或者更新博文
     *
     * @param articleVo
     * @param typeIds
     * @param tagIds
     * @return
     */
    @RequestMapping(value = "/article/save")
    @ResponseBody
    public MessageVo saveArt(ArticleVo articleVo, String typeIds, String tagIds, boolean isDraft) throws JsonProcessingException {
        int articleid;    // 博文id
        if (articleVo.getRecid() != null) {
            //更新博文
            articleid = articleVo.getRecid();
            articleVo.setStatus(1);
            articleVo.setUpdatetime(DateUtil.formatDate(new Date()));
            articleService.updateArticle((ArticlePo) ConvertUtil.convertDtoAndVo(articleVo, ArticlePo.class));
        } else {
            //创建新博文
            ArticlePo articlePo = new ArticlePo();
            articlePo.setTitle(articleVo.getTitle());
            articlePo.setContent(articleVo.getContent());
            articlePo.setCreatetime(DateUtil.formatDate(new Date()));
            articlePo.setStatus(1);
            if (isDraft == true) {
                articlePo.setStatus(0);
            }
            articleService.insertArticle(articlePo);
            articleid = articlePo.getRecid();
        }

        List<ArticleTypePo> articleTypePos = new ArrayList<>();
        List<ArticleTagPo> articleTagPos = new ArrayList<>();

        //得到标签和分类的id  构造新的标签和分类 批量插入
        if (typeIds != null && !typeIds.equals("")) {
            for (String s : typeIds.trim().split(",")) {
                ArticleTypePo articleTypePo = new ArticleTypePo();
                articleTypePo.setArticleid(articleid);
                articleTypePo.setTypeid(Integer.parseInt(s));
                articleTypePos.add(articleTypePo);
            }
        }
        if (tagIds != null && !tagIds.equals("")) {
            for (String s : tagIds.trim().split(",")) {
                ArticleTagPo articleTagPo = new ArticleTagPo();
                articleTagPo.setArticleid(articleid);
                articleTagPo.setTagid(Integer.parseInt(s));
                articleTagPos.add(articleTagPo);
            }
        }
        //先删除原来的标签和分类 在新增
        articleTagService.delArticleTagByArtId(articleid);
        articleTypeService.delArticleTypeByArtId(articleid);

        //批量插入新的
        if (articleTypePos.size() > 0) {
            articleTypeService.insertArticleTypes(articleTypePos);
        }
        if (articleTagPos.size() > 0) {
            articleTagService.insertArticleTags(articleTagPos);
        }

        List<ArticleVo> fileAtticles = ConvertUtil.convertDtoAndVo(articleService.getArticleList(), ArticleVo.class);
        List<FileVo> fileVos = new ArrayList<>();
        articleService.getFileList(fileAtticles, fileVos);
        stringRedisTemplate.opsForValue().set(Constant.FILEVOS, JacksonUtil.toJson(fileVos));

        MessageVo messageVo = new MessageVo();
        messageVo.setCode(Constant.SUCCESS_CODE);
        messageVo.setData(articleid);
        messageVo.setMsg("保存成功");
        return messageVo;
    }
}
