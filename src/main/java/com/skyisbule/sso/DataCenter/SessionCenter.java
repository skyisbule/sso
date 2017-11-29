package com.skyisbule.sso.DataCenter;

import com.skyisbule.sso.Model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by skyisbule on 2017/11/23.
 * 此类用于用户Session缓存、同步
 */
public class SessionCenter {
    private static Map<String,User> SessionMap= new HashMap<String,User>(16);

    public void put(String session,User user){
        //如果已存在就清掉更新
        if (SessionMap.containsKey(session)){
            SessionMap.remove(session);
        }
        //把映射关系丢进map
        SessionMap.put(session,user);
    }

    public boolean isSessionRight(String session){
        if (SessionMap.containsKey(session)){
            //这里做一些额外的处理，例如判读段时间有没有过期之类的，mark最后再写

            return true;
        }

        return false;
    }

    public User getUser(String session){
        return SessionMap.get(session);
    }

}
