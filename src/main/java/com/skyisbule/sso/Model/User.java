package com.skyisbule.sso.Model;

/**
 * Created by skyisbule on 2017/11/23.
 * 用户对应的实体类
 */
public class User {
    private int id;
    private String name;
    private String telnum;
    private String passwd;
    private String sessionid;
    private long lastLoginTime;

    public void setId(int id){this.id=id;}
    public int getId(){return id;}
    public void setName(String name){this.name=name;}
    public String getName(){return name;}
    public void setTelnum(String telnum){this.telnum=telnum;}
    public String getTelnum(){return telnum;}
    public void setPasswd(String passwd){this.passwd=passwd;}
    public String getPasswd(){return passwd;}
    public void setSessionid(String sessionid){this.sessionid=sessionid;}
    public String getSessionid(){return sessionid;}
    public void setLastLoginTime(long lastLoginTime){this.lastLoginTime=lastLoginTime;}
    public long getLastLoginTime(){return lastLoginTime;}
}
