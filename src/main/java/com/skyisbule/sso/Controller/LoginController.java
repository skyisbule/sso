package com.skyisbule.sso.Controller;

import com.skyisbule.sso.DataCenter.SessionCenter;
import com.skyisbule.sso.DataCenter.TicketCenter;
import com.skyisbule.sso.Model.ReqInfo;
import com.skyisbule.sso.Model.User;
import com.skyisbule.sso.Security.SkyTicketImp;
import com.skyisbule.sso.Security.TicketHelper;
import com.skyisbule.sso.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 此类用于控制用户登录行为，处理用户登录
 */
@Controller
public class LoginController {

    @Autowired
    LoginService service;

    //口令生成类
    TicketHelper Ticket = null;
    //ticke缓存中心
    TicketCenter ticketCenter = new TicketCenter();
    //session缓存中心
    SessionCenter sessionCenter = new SessionCenter();

    LoginController() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.Ticket = new SkyTicketImp();
    }

    //返回登录界面
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    //处理登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String logining(User user,
                           ReqInfo reqInfo,
                           @CookieValue("session")String session){
        String telnum = user.getTelnum();
        String passwd = user.getPasswd();
        //处理登录
        if (service.isTrueForTel(telnum,passwd)){
            User userSession = sessionCenter.getUser(session);
            //生成ticket
            String ticket = Ticket.buildTicket();
            //更新最后生成时间
            userSession.setLastLoginTime(System.currentTimeMillis());
            //存入缓存
            ticketCenter.put(ticket,userSession);
            String Redirect = "redirect:/"+reqInfo.getUrl()+"/api/login?ticket="+ticket;
            //构造重定向URL
            return Redirect;
        }
        //处理失败
        return "error";

    }

}
