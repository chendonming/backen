package com.xl.backen.util.util;

import org.springframework.util.StringUtils;

public class StringUtil {
    public static Boolean isEmpty(Object obj) {
        if(obj == null){
            return true;
        }else if(obj instanceof String && StringUtils.isEmpty(obj)) {
            return true;
        }else{
            return false;
        }
    }
}
