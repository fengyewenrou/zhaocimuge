package com.zhaoci.share.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.SignatureException;

import org.apache.commons.codec.digest.DigestUtils;

import com.zhaoci.framework.base.Constants;

public class MD5Util {
	private static final String key = "zhaoci2017";

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String input_charset) {
    	text = text + ((key==null)?MD5Util.key:key);
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }
    
    /**
     * 比较签名字符串
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key, String input_charset) {
    	text = text + ((key==null)?MD5Util.key:key);
    	String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));
    	if(mysign.equals(sign)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }     
    public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}
    public static void main(String[] args) {
    	System.out.println(MD5Util.md5("2f5fe77b3cbc46148ea3a23fe19c587f"));
		System.out.println("123456::"+MD5Util.sign("131205693061111112015", null, Constants.CHARACTER_ENCODING_UTF8));
		System.out.println("123::"+MD5Util.sign("123", null, Constants.CHARACTER_ENCODING_UTF8));
		System.out.println("456::"+MD5Util.sign("456", null, Constants.CHARACTER_ENCODING_UTF8));
		System.out.println("3::"+MD5Util.sign("2f5fe77b3cbc46148ea3a23fe19c587f沪JC1795", null, Constants.CHARACTER_ENCODING_UTF8));
	}
}