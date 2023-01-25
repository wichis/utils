package mx.ryo.xoloitek.commons.exception.utils;


import java.util.ResourceBundle;

public class MsgBundleUtils {
	final private static String PROP_RESPONSE = "error-msg";
	
	public final static String useResponse(String str) {
		return ResourceBundle.getBundle(PROP_RESPONSE).getString(str);
	}
	
}
