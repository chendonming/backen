package com.xl.backen.util.util;

import org.springframework.util.DigestUtils;

/**
 * @author chendm
 * @Description:MD5通用类
 * @date:   2018年7月22日 下午3:04:27
 */
public class MD5 {
    /**
     * MD5方法
     *
     * @param text 明文
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text) throws Exception {
        //加密后的字符串
        String encodeStr = DigestUtils.md5DigestAsHex(text.getBytes());
        System.out.println("MD5加密后的字符串为:encodeStr=" + encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param md5  密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text);
        if (md5Text.equalsIgnoreCase(md5)) {
            System.out.println("MD5验证通过");
            return true;
        }

        return false;
    }

    /**
     * 测试MD5
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String pwd = "123";

        System.out.println("md5: " + md5(pwd));

        System.out.println("验证: " + verify("123", md5(pwd)));
    }
}
