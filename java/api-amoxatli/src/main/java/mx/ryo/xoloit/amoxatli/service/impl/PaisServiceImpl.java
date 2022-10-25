package mx.ryo.xoloit.amoxatli.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ryo.xoloit.amoxatli.beans.entity.Pais;
import mx.ryo.xoloit.amoxatli.repository.PaisRepository;
import mx.ryo.xoloit.amoxatli.service.PaisService;
import mx.ryo.xoloit.utils.exception.devel.DataNotFoundException;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired
	private PaisRepository paisRepo;
	@Override
	public List<Pais> obtenerTodo() {
		return (List<Pais>) this.paisRepo.findAll();
	}
	@Override
	public Pais buscarBy(Integer idPais) throws DataNotFoundException {
		return this.paisRepo.findById(idPais).orElseThrow(() -> new DataNotFoundException("Pais no encontrado"));
	}

}
