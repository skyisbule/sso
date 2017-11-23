package com.skyisbule.sso.Controller;

import com.skyisbule.sso.Model.User;
import com.skyisbule.sso.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 此类用于控制用户登录行为，处理用户登录
 */
@Controller
public class LoginController {

    @Autowired
    LoginService service;

    //返回登录界面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    //处理登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String logining(User user, @CookieValue("session")String session){
        String telnum = user.getTelnum();
        String passwd = user.getPasswd();
        //处理登录
        if (service.isTrueForTel(telnum,passwd)){
            //激活session、存map

            //生成ticket

            //构造重定向URL
            return "redirect:/";
        }
        //处理失败
        return "error";

    }

}
