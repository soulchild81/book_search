package com.soulchild.work.common.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;

public class Aes256Util {
    public static String encrypt(String str, String key) throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException {
        if(StringUtils.isEmpty(key) || key.length() < 16) return null;

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] b = key.substring(0, 16).getBytes("UTF-8");
        c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(b, "AES"), new IvParameterSpec(b));
        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));

        return new String(Base64.encodeBase64(encrypted));
    }

    public static String decrypt(String str, String key) throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException {
        if(StringUtils.isEmpty(key) || key.length() < 16) return null;

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.substring(0, 16).getBytes("UTF-8"), "AES"), new IvParameterSpec(key.substring(0, 16).getBytes()));
        byte[] byteStr = Base64.decodeBase64(str.getBytes("UTF-8"));

        return new String(c.doFinal(byteStr), "UTF-8");
    }

//    private String iv;
//    private Key keySpec;
//
//    public Aes256Util(String key) throws UnsupportedEncodingException {
//        this.iv = key.substring(0, 16);
//
//        byte[] keyBytes = new byte[16];
//        byte[] b = key.getBytes("UTF-8");
//        int len = b.length;
//        if(len > keyBytes.length)
//            len = keyBytes.length;
//        System.arraycopy(b, 0, keyBytes, 0, len);
//        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
//
//        this.keySpec = keySpec;
//    }
//
//    // 암호화
//    public String aesEncode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException,
//            NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,
//            IllegalBlockSizeException, BadPaddingException {
//        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
//
//        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
//        String enStr = new String(Base64.encodeBase64(encrypted));
//
//        return enStr;
//    }
//
//    //복호화
//    public String aesDecode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException,
//            NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,
//            IllegalBlockSizeException, BadPaddingException {
//        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));
//
//        byte[] byteStr = Base64.decodeBase64(str.getBytes());
//
//        return new String(c.doFinal(byteStr),"UTF-8");
//    }
}
