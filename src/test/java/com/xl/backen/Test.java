package com.xl.backen;

import java.util.UUID;


public class Test {
    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            System.out.println(UUID.randomUUID().toString().replace("-", ""));
        }
        
//        StringBuilder sb = new StringBuilder();
//        System.out.println(sb.toString());
    }
}
