package com.hundsun.core.controller;

import com.hundsun.core.entity.User;
import com.hundsun.core.service.DemoService;
import com.hundsun.licensesdk.lang.annotation.LicenseApi;
import com.hundsun.licensesdk.validation.LicenseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/test")
    @ResponseBody
    @LicenseApi(functionId = "111500")
    public String home(@Valid User user, BindingResult bindingResult, LicenseResult license) {
        if (license.hasErrors()) {
            System.out.println(license.getErrorCount());
            List<String> list = license.getAllErrors();
            System.out.println(list.toString());
        }

        String result = demoService.test(user);
        System.out.println("license:" + license);
        System.out.println("result:" + result);
        return result;
    }
}
