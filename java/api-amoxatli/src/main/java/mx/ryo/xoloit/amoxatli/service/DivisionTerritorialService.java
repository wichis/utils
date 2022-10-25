package mx.ryo.xoloit.amoxatli.service;

import java.util.List;

import mx.ryo.xoloit.amoxatli.beans.entity.DivisionTerritorial;
import mx.ryo.xoloit.amoxatli.beans.entity.embedable.DivisionTerritorialIdentity;
import mx.ryo.xoloit.utils.exception.devel.DataNotFoundException;

public interface DivisionTerritorialService {
	public List<DivisionTerritorial> obtenerTodo();
	
	public DivisionTerritorial buscarBy(DivisionTerritorialIdentity id) throws DataNotFoundException;
}
