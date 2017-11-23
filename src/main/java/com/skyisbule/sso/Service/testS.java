package com.skyisbule.sso.Service;


import com.skyisbule.sso.Dao.helloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testS {
    @Autowired
    helloDao dao;

    public String test(){
        return dao.test();
    }
}
