package com.skyisbule.sso.Model;

/**
 * Created by skyisbule on 2017/11/23.
 * 用来获取别的系统重定向过来的请求信息
 */
public class ReqInfo {
    private String url;

    public void setUrl(String url){this.url=url;}
    public String getUrl(){return url;}
}
