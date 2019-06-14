package com.hundsun.core.controller;

import com.hundsun.common.annotation.LicenseApi;
import com.hundsun.core.entity.User;
import com.hundsun.core.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/test")
    @ResponseBody
    @LicenseApi
    public String home(@Valid User user, BindingResult bindingResult, String license) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.getObjectName());
                System.out.println(error.getArguments());
                System.out.println(error.getCodes());
                System.out.println(error.getCode());
                System.out.println(error.getDefaultMessage());
            }
        }

        String result = demoService.test(user);
        System.out.println("license:" + license);
        System.out.println("result:" + result);
        return result;
    }
}
