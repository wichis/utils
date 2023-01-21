package mx.ryo.xoloitek.commons.utils.bundle;

import java.util.ResourceBundle;

public class MsgBundleUtils {
	final private static String PROP_RESPONSE = "response";
	final private static String PROP_TXT_UTILS = "text_utils";
	
	public final static String useResponse(String str) {
		return ResourceBundle.getBundle(PROP_RESPONSE).getString(str);
	}
	
	public final static String useResponse(MsgBundleType mbType) {
		return ResourceBundle.getBundle(PROP_RESPONSE).getString(mbType.getKey());
	}

	public final static String useTextUtils(TxtUtilsBundleType tctUtilBdleType) {
		return ResourceBundle.getBundle(PROP_TXT_UTILS).getString(tctUtilBdleType.getKey());
	}
}
