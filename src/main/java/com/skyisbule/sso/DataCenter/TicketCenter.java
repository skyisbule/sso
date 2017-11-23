package com.skyisbule.sso.DataCenter;

import com.skyisbule.sso.Model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by skyisbule on 2017/11/23.
 * 此类用于用户Ticket缓存、同步
 */
public class TicketCenter {
    public static Map<String,User> TicketMap= new HashMap<String, User>(16);

    public void put(String Ticket,User user){
        TicketMap.put(Ticket,user);
    }

    public User getUser(String ticket){
        if (TicketMap.containsKey(ticket)){
            return TicketMap.get(ticket);
        }
        return new User();
    }

}
