package com.xl.backen;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackenApplication.class, args);
    }
}
