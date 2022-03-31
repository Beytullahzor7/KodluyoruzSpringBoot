package com.kodluyoruz.controller;

import com.kodluyoruz.bean.BeanConfig;
import com.kodluyoruz.bean.BeanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeanController {

    @Autowired
    private BeanConfig beanConfig;

    // http://localhost:8080/bean/beanDto
    @GetMapping("/bean/beanDto")
    @ResponseBody
    public BeanDto getBeanDto(){
        return beanConfig.beanDto();
    }
}
