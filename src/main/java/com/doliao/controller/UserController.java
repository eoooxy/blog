package com.doliao.controller;

import com.doliao.constant.Constant;
import com.doliao.po.UserPo;
import com.doliao.service.UserService;
import com.doliao.vo.LoginInfoVo;
import com.doliao.vo.MessageVo;
import com.doliao.vo.UserVo;
import com.utils.DateUtil;
import com.utils.OSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * author： xueyuan
 * date  ： 2017-07-13 上午9:02
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public String toLogin() {
        return "/login";
    }

    @RequestMapping(value = "/loginin")
    @ResponseBody
    public MessageVo login(UserVo userVo, HttpServletRequest request) {
        MessageVo messageVo = new MessageVo();
        if (!StringUtils.isEmpty(userVo) && !StringUtils.isEmpty(userVo.getUsername())
                && !StringUtils.isEmpty(userVo.getPassword())) {
            UserPo userPo = new UserPo();
            userPo.setUsername(userVo.getUsername());
            UserPo valUser = userService.getUser(userPo);
            LoginInfoVo loginInfo = new LoginInfoVo();
            if (valUser != null && valUser.getRecid() > 0) {
                System.out.println(valUser.getLasttime());
                loginInfo.setLasttime(valUser.getLasttime());
                loginInfo.setCurrenttime(DateUtil.formatDate(new Date()));
                loginInfo.setOs(OSUtil.getOSname().toString());
                valUser.setLasttime(DateUtil.formatDate(new Date()));
                userService.updateUser(valUser);
                //已登录标记 如果是博主的
                if (userVo.getUsername().equals("admin")) {
                    request.getSession().setAttribute(Constant.MASTER, Constant.MASTER_MARK);
                    // 如果为博主，那么返回跳转的时候给出提示
                    messageVo.setData("master");
                }
                // uid
                request.getSession().setAttribute(Constant.UUID, valUser.getRecid());
                //登录用户信息
                request.getSession().setAttribute(Constant.USER_INFO, valUser);
                //登录系统以及时间信息
                request.getSession().setAttribute(Constant.LOGIN_INFO, loginInfo);

                LoginInfoVo loginInfoVo = (LoginInfoVo) request.getSession().getAttribute(Constant.LOGIN_INFO);
                Integer uid = (Integer) request.getSession().getAttribute(Constant.UUID);

                messageVo.setCode(Constant.SUCCESS_CODE);
                messageVo.setMsg("登录成功！");
                return messageVo;

            } else {
                messageVo.setCode(Constant.ERROR_CODE);
                messageVo.setMsg("账号或密码错误");
                return messageVo;
            }
        }
        messageVo.setCode(Constant.ERROR_CODE);
        messageVo.setMsg("账号或密码不能为空");
        return messageVo;
    }
}
