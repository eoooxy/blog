package com.doliao.controller.back;

import com.doliao.constant.Constant;
import com.doliao.po.TagPo;
import com.doliao.po.TypePo;
import com.doliao.service.TagService;
import com.doliao.service.TypeService;
import com.doliao.vo.MessageVo;
import com.doliao.vo.TagVo;
import com.doliao.vo.TypeVo;
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
import java.util.Date;
import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-07-20 下午10:44
 */
@Controller
@RequestMapping(value = "/back")
public class TypeController {

    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/type")
    public String type(ModelMap modelMap, String type, HttpServletRequest request) {
        if ("type".equals(type)) {
            List<TypeVo> typeVos = ConvertUtil.convertDtoAndVo(typeService.getTypeList(), TypeVo.class);
            modelMap.put("type", "分类");
            modelMap.put("vos", typeVos);
        }

        if ("tag".equals(type)) {
            List<TagVo> tagVos = ConvertUtil.convertDtoAndVo(tagService.getTagList(), TagVo.class);
            modelMap.put("type", "标签");
            modelMap.put("vos", tagVos);
        }
        modelMap.put("loginInfo", request.getSession().getAttribute(Constant.LOGIN_INFO));
        return "/back/type";
    }

    @RequestMapping(value = "/type/update")
    @ResponseBody
    public MessageVo update(String type, Integer recid, String name) throws JsonProcessingException {
        MessageVo messageVo = new MessageVo();
        // 更新或新建 分类
        if ("分类".equals(type)) {
            if (recid != null) {
                TypePo typePo = typeService.getType(recid);
                typePo.setName(name);
                typePo.setUpdatetime(DateUtil.formatDate(new Date()));
                typeService.updateType(typePo);
            } else {
                TypePo typePo = new TypePo();
                typePo.setName(name);
                typePo.setCreatetime(DateUtil.formatDate(new Date()));
                typeService.insertType(typePo);
            }
            List<TypeVo> typeVos = ConvertUtil.convertDtoAndVo(typeService.getTypeList(), TypeVo.class);
            stringRedisTemplate.opsForValue().set(Constant.TYPEVOS, JacksonUtil.toJson(typeVos));

            messageVo.setData("type");
            messageVo.setCode(Constant.SUCCESS_CODE);
            return messageVo;
        }
        // 更新或新建 标签
        if ("标签".equals(type)) {
            if (recid != null) {
                TagPo tagPo = tagService.getTag(recid);
                tagPo.setName(name);
                tagPo.setUpdatetime(DateUtil.formatDate(new Date()));
                tagService.updateTag(tagPo);
            } else {
                TagPo tagPo = new TagPo();
                tagPo.setName(name);
                tagPo.setCreatetime(DateUtil.formatDate(new Date()));
                tagService.insertTag(tagPo);
            }
            List<TagVo> tagVos = ConvertUtil.convertDtoAndVo(tagService.getTagList(), TagVo.class);
            stringRedisTemplate.opsForValue().set(Constant.TAGVOS, JacksonUtil.toJson(tagVos));

            messageVo.setData("tag");
            messageVo.setCode(Constant.SUCCESS_CODE);
            return messageVo;
        }
        messageVo.setCode(Constant.ERROR_CODE);
        return messageVo;
    }
}
