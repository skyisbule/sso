package com.skyisbule.sso.Security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by skyisbule on 2017/11/23.
 * 一个加密算法的简单实现，以后再换
 */
public class SkyTicketImp implements TicketHelper{

    public SkyTicketImp()throws NoSuchAlgorithmException, UnsupportedEncodingException {
        md5=MessageDigest.getInstance("MD5");
    }

    private static MessageDigest md5  ;

    @Override
    public String buildSession(){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        //长度为几就循环几次
        for(int i=0; i<32; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串,添加当前时间戳
        sb.append(System.currentTimeMillis());
        //返回散列值
        return getMd5(sb.toString());
    }

    @Override
    public String buildTicket(){
        return buildSession();
    }

    public static String getMd5(String str) {
        byte[] bs = md5.digest(str.getBytes());
        StringBuilder sb = new StringBuilder(40);
        for(byte x:bs) {
            if((x & 0xff)>>4 == 0) {
                sb.append("0").append(Integer.toHexString(x & 0xff));
            } else {
                sb.append(Integer.toHexString(x & 0xff));
            }
        }
        return sb.toString();
    }
}
