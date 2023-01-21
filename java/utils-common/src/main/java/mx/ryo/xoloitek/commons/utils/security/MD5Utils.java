package mx.ryo.xoloitek.common.utils.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	public static String encrypt(String strToHash) throws NoSuchAlgorithmException  {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(strToHash.getBytes());
			byte[] digest = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : digest) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();

	}
}
