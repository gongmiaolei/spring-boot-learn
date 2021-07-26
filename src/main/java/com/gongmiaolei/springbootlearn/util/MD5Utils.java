package com.gongmiaolei.springbootlearn.util;

import com.gongmiaolei.springbootlearn.common.Constant;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author gml
 * @date 2021/6/18
 **/
public class MD5Utils {
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.encodeBase64String(md5.digest((strValue+ Constant.SALT).getBytes()));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String asdfghjkl521 = getMD5Str("Asdfghjkl*#06#");
        System.out.println(asdfghjkl521);
    }
}