package mx.ryo.xoloit.amoxatli.service;

import java.util.List;

import mx.ryo.xoloit.amoxatli.beans.entity.Pais;
import mx.ryo.xoloit.utils.exception.devel.DataNotFoundException;

public interface PaisService {
	public List<Pais> obtenerTodo();
	
	public Pais buscarBy(Integer idPais) throws DataNotFoundException;
}
