package com.skyisbule.sso.Security;

/**
 * Created by skyisbule on 2017/11/23.
 * 用于生成随机字符串，作为session和ticket
 */
public interface TicketHelper {
    public String buildTicket();
    public String buildSession();
}
