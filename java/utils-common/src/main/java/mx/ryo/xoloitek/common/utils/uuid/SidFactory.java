package mx.ryo.xoloitek.common.utils.uuid;

import java.util.UUID;

public class SidFactory {
	private final String patternValid = "^[a-zA-Z]{4}(:)[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
	
	public SidFactory() {
		super();
	}
	
	public String generateSid(SidType sidType) {
		UUID uuid = UUID.randomUUID();
		return String.format("%s%s%s", sidType.getPrefix(),":",uuid.toString());
	}
	
}
