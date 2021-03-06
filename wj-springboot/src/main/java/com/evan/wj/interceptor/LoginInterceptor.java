package com.evan.wj.interceptor;

import com.evan.wj.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)throws Exception{
       //放行option请求,否则无法让前端带上自定义的header信息，导致sessionID改变，shiro验证失败
        if (HttpMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())){
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }

        Subject subject = SecurityUtils.getSubject();
        //使用shiro验证
        if(!subject.isAuthenticated()){
            return false;
        }
        return true;
    }

    private boolean begingWith(String page,String[] requiredAuthPages){
        boolean result=false;
        for (String requiredAuthPage:requiredAuthPages){
            if (StringUtils.startsWith(page,requiredAuthPage)){
                result = true;
                break;
            }
        }
        return  result;
    }
}
