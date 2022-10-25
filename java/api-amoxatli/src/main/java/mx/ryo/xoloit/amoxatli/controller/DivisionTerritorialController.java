package mx.ryo.xoloit.amoxatli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.ryo.xoloit.amoxatli.beans.entity.DivisionTerritorial;
import mx.ryo.xoloit.amoxatli.beans.entity.embedable.DivisionTerritorialIdentity;
import mx.ryo.xoloit.amoxatli.service.DivisionTerritorialService;
import mx.ryo.xoloit.utils.exception.devel.DataNotFoundException;

@RestController
@RequestMapping("country-division")
public class DivisionTerritorialController {
	@Autowired
	private DivisionTerritorialService divisionTerritorialSrv;
	
	@RequestMapping("/all")
	public List<DivisionTerritorial> obtenerPaises() {
		return this.divisionTerritorialSrv.obtenerTodo();
	}

	@RequestMapping("/search/{idPais}/{idDivision}")
	public DivisionTerritorial obtenerPais(@PathVariable Long idPais, @PathVariable Long idDivision) throws DataNotFoundException {
		return this.divisionTerritorialSrv.buscarBy(new DivisionTerritorialIdentity(idPais, idDivision));
	}
}
