package com.ljt.shirodemo1.filter;

import com.alibaba.fastjson.JSONObject;
import com.ljt.shirodemo1.util.ResultBody;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class JWTFilter extends FormAuthenticationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        System.out.println("===========jwt 验证没有通过。");
        ResultBody error = ResultBody.error();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(JSONObject.toJSONString(error));
        response.reset();
        return true;
    }
}
