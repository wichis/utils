package mx.ryo.xoloit.amoxatli.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ryo.xoloit.amoxatli.beans.entity.DivisionTerritorial;
import mx.ryo.xoloit.amoxatli.beans.entity.embedable.DivisionTerritorialIdentity;
import mx.ryo.xoloit.amoxatli.repository.DivisionTerritorialRepository;
import mx.ryo.xoloit.amoxatli.service.DivisionTerritorialService;
import mx.ryo.xoloit.utils.exception.devel.DataNotFoundException;

@Service
public class DivisionTerritorialServiceImpl implements DivisionTerritorialService {
	@Autowired
	private DivisionTerritorialRepository divisionTerritorialRepo;
	
	@Override
	public List<DivisionTerritorial> obtenerTodo() {
		return (List<DivisionTerritorial>) divisionTerritorialRepo.findAll();
	}

	@Override
	public DivisionTerritorial buscarBy(DivisionTerritorialIdentity id) throws DataNotFoundException {
		return this.divisionTerritorialRepo.findById(id).orElseThrow(() -> new DataNotFoundException("Division no encontrada"));
	}

}
