package mx.ryo.xoloit.utils.error;

import mx.ryo.xoloit.utils.error.types.ModeNotifyType;
import mx.ryo.xoloit.utils.error.types.NextActionType;

public class ErrorResponse {
	private String codigo;
	private String descripcion;
	private ModeNotifyType notify;
	private NextActionType nextAction;
	
	public ModeNotifyType getNotify() {
		return notify;
	}
	public void setNotify(ModeNotifyType notify) {
		this.notify = notify;
	}
	public NextActionType getNextAction() {
		return nextAction;
	}
	public void setNextAction(NextActionType nextAction) {
		this.nextAction = nextAction;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
