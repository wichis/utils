package mx.ryo.xoloit.amoxatli.service;

import java.util.List;

import mx.ryo.xoloit.amoxatli.beans.entity.GeneroSexual;
import mx.ryo.xoloit.utils.exception.devel.DataNotFoundException;

public interface GeneroSexualService {

	public List<GeneroSexual> obtenerTodo();
	
	public GeneroSexual buscarBy(Integer id) throws DataNotFoundException;

}
