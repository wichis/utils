package mx.ryo.xoloit.amoxatli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.ryo.xoloit.amoxatli.beans.entity.Pais;
import mx.ryo.xoloit.amoxatli.service.PaisService;
import mx.ryo.xoloit.utils.exception.devel.DataNotFoundException;

@RestController
@RequestMapping("countries")
public class PaisController {
	@Autowired
	private PaisService paisSrv;
	
	@RequestMapping("/all")
	public List<Pais> obtenerPaises() {
		return this.paisSrv.obtenerTodo();
	}

	@RequestMapping("/search/{idPais}")
	public Pais obtenerPais(@PathVariable Integer idPais) {
		try {
			return this.paisSrv.buscarBy(idPais);
		} catch (DataNotFoundException e) {
			return null;
		}
	}
}
