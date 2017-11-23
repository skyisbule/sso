package com.skyisbule.sso.Controller;

import com.skyisbule.sso.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 此类用于控制用户登录行为，处理用户登录
 */
@Controller
public class LoginController {

    //返回登录界面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    //处理登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String logining(User user){

    }

}
