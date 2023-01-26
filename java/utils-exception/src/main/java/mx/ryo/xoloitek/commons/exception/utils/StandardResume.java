package mx.ryo.xoloitek.commons.exception.utils;

import mx.ryo.xoloitek.commons.exception.DevelLogicException;
import mx.ryo.xoloitek.commons.exception.type.LevelError;

public class StandardResume {

	public static final String getResume(LevelError lvlError) throws DevelLogicException {
		switch(lvlError) {
		case CLIENT:
			return MsgBundleUtils.useResponse("level_error.standard.client_error");
		case EXTERNAL_DEPENDENCY:
			return MsgBundleUtils.useResponse("level_error.standard.dependency_external_error");
		case INTERNAL_KNOWN:
			return MsgBundleUtils.useResponse("level_error.standard.internal_server_error_conocida");
		case INTERNAL_UNKNOWN:
			return MsgBundleUtils.useResponse("level_error.standard.internal_server_error_desconocida");
		case LOCAL_DEPENDENCY:
			return MsgBundleUtils.useResponse("level_error.standard.dependency_internal_error");
		default:
			throw new DevelLogicException(LevelError.INTERNAL_KNOWN, "This levelError message does not exist. Verify your cases.");
		}
	}
}
