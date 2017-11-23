package com.skyisbule.sso.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by skyisbule on 2017/11/23.
 * Api中心，用于开放对外接口
 * 1.重定向中心，用于登录
 */
@RestController
public class ApiCenter {


    /**
     * 此Api用来做为核心访问层，其余系统重定向到此接口，该接口判断用户登录状态。
     * 有两种情况：
     * 1.检测到有效session，生成ticket，并重定向回去。
     * 2.没有检测到有效session，生成session，跳转到本地登录界面。
     */

    @RequestMapping("/api/login")
    public String isLogin(HttpServletRequest request){
        //获取session
        Cookie[] cookies = request.getCookies();
        if (cookies==null)
            return "登录失败重定向";

        //尝试获取session
        for (Cookie temp: cookies){
            if (temp.getName().equals("session")){
                //判断session合法性
                //生成ticket，存入内存
                return "登陆成功";
            }

        }
        return "重定向到登录界面";
    }


}
