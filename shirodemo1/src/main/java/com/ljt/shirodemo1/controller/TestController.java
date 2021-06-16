package com.ljt.shirodemo1.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @RequestMapping("/add")
    public String add(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c: cookies){
            System.out.println(c.getValue());
        }
        System.out.println("---------add");
        return "add";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c: cookies){
            System.out.println(c.getValue());
        }
        System.out.println("---------index");
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        System.out.println("---------login");
        String username = "liu";
        String password = "123456";
        UsernamePasswordToken upt = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(upt);
                return "登陆成功";
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                System.out.println("用户名错误!");
            } catch (IncorrectCredentialsException e) {
                e.printStackTrace();
                System.out.println("密码错误!");
            }
            return "登陆失败";
        }

}
