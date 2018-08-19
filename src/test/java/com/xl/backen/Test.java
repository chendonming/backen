package com.xl.backen;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;


public class Test {
    public static void main(String[] args) {

//        for (int i = 0; i < 50; i++) {
//            System.out.println(UUID.randomUUID().toString().replace("-", ""));
//        }
        
//        StringBuilder sb = new StringBuilder();
//        System.out.println(sb.toString());
        Calendar now = Calendar.getInstance();
        String filePathNow = now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/" + now.get(Calendar.DATE);
        System.out.println(filePathNow);
    }
}
