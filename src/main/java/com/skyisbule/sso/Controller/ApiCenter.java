package com.skyisbule.sso.Controller;


import com.skyisbule.sso.DataCenter.SessionCenter;
import com.skyisbule.sso.DataCenter.TicketCenter;
import com.skyisbule.sso.Model.ReqInfo;
import com.skyisbule.sso.Model.User;
import com.skyisbule.sso.Security.SkyTicketImp;
import com.skyisbule.sso.Security.TicketHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by skyisbule on 2017/11/23.
 * Api中心，用于开放对外接口
 * 1.重定向中心，用于登录
 */
@Controller
public class ApiCenter {

    //用于生成Session和Ticket
    TicketHelper Ticket = null;
    //Session缓存
    SessionCenter sessionCenter = new SessionCenter();
    //Ticket缓存
    TicketCenter ticketCenter = new TicketCenter();

    private ApiCenter(){
        this.Ticket = new SkyTicketImp();
    }

    /**
     * 此Api用来做为核心访问层，其余系统重定向到此接口，该接口判断用户登录状态。
     * 有两种情况：
     * 1.检测到有效session，生成ticket，并重定向回去。
     * 2.没有检测到有效session，生成session，跳转到本地登录界面。
     */

    @RequestMapping("/api/login")
    public String isLogin(HttpServletRequest request,
                          HttpServletResponse response,
                          ReqInfo reqInfo){
        //获取session
        Cookie[] cookies = request.getCookies();
        //cookie不存在，生成cookie并重定向到登录界面
        if (cookies==null){
            NotLogined(response);
            return "redirect:/login?url="+reqInfo.getUrl();
        }


        //尝试获取session
        for (Cookie temp: cookies){
            if (temp.getName().equals("session")){
                //判断session合法性
                if (sessionCenter.isSessionRight(temp.getValue())){
                    //生成ticket
                    String ticket = Ticket.buildTicket();
                    //更新ticket激活时间
                    User user = sessionCenter.getUser(temp.getValue());
                    user.setLastLoginTime(System.currentTimeMillis());
                    //存进ticket缓存
                    ticketCenter.put(ticket,user);
                    //开始构造重定向URL 例如  http://a.com/api/xxx?Ticket=xxxx
                    String Redirect = reqInfo.getUrl()+"/api/login?ticket="+ticket;
                    return Redirect;
                }
            }

        }
        //到这里表示登陆失败
        NotLogined(response);
        return "重定向到登录界面";
    }

    //未登录或当前session失效，重新生成。
    private void NotLogined(HttpServletResponse response){
        String session=Ticket.buildSession();
        Cookie cookie = new Cookie("session",session);
        response.addCookie(cookie);
    }

}
