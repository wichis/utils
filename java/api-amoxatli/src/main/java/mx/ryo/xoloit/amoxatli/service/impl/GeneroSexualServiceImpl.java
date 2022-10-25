package mx.ryo.xoloit.amoxatli.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ryo.xoloit.amoxatli.beans.entity.GeneroSexual;
import mx.ryo.xoloit.amoxatli.repository.GeneroSexualRepository;
import mx.ryo.xoloit.amoxatli.service.GeneroSexualService;
import mx.ryo.xoloit.utils.exception.devel.DataNotFoundException;

@Service
public class GeneroSexualServiceImpl implements GeneroSexualService {
	@Autowired
	private GeneroSexualRepository generoSexualRepo;
	
	@Override
	public List<GeneroSexual> obtenerTodo() {
		return (List<GeneroSexual>) this.generoSexualRepo.findAll();
		
	}
	@Override
	public GeneroSexual buscarBy(Integer id) throws DataNotFoundException  {
		return this.generoSexualRepo.findById(id).orElseThrow(() -> new DataNotFoundException("GeneroSexual no encontrado"));
	}

}
