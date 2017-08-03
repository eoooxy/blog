package com.doliao.filter;

import com.doliao.constant.Constant;
import com.doliao.vo.LoginInfoVo;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * author： xueyuan
 * date  ： 2017-07-26 下午6:45
 */
@Order(1)
@WebFilter(filterName = "backFilter", urlPatterns = "/back/*")
public class BackFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        //获取session中作为判断的字段
        String mark = (String) session.getAttribute(Constant.MASTER);
        boolean isMaster = null != mark && mark.equals(Constant.MASTER_MARK) ? true : false;
        LoginInfoVo loginInfoVo = (LoginInfoVo) session.getAttribute(Constant.LOGIN_INFO);
//        Integer uid = (Integer) session.getAttribute(Constant.UUID);
//        System.out.println(loginInfoVo);

        if (!isMaster || loginInfoVo == null) {
            resp.sendRedirect("/login.html");
        } else {
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
