package com.skyisbule.sso.DataCenter;

import com.skyisbule.sso.Model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by skyisbule on 2017/11/23.
 * 此类用于用户Session缓存、同步
 */
public class Session {
    public static Map<String,User> SessionMap= new HashMap<String,User>(16);

    public static void put(String session,User user){
        //如果已存在就清掉更新
        if (SessionMap.containsKey(session)){
            SessionMap.remove(session);
        }
        //把映射关系丢进map
        SessionMap.put(session,user);
    }

}
