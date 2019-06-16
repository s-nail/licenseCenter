package com.hundsun;

import com.hundsun.licensesdk.lang.annotation.EnableLicenseAuthCheck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author jiayq24996
 */
@SpringBootApplication
@EnableLicenseAuthCheck
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

