package cn.fruit.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class ServiceUtils {
	
	//∏¯√‹¬Îº”√‹
	public static String md5(String message){
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(message.getBytes());
			
			BASE64Encoder base64 = new BASE64Encoder();
			String encode = base64.encode(md5);
			
			return encode;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
