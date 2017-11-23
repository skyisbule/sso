package com.skyisbule.sso.Controller;


import com.skyisbule.sso.Service.testS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @Autowired
    testS service;


    @RequestMapping("/dsf")
    public String hello(){

        return service.test();
    }


}
