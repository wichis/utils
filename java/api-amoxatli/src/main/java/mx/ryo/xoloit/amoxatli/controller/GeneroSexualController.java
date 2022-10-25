package mx.ryo.xoloit.amoxatli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.ryo.xoloit.amoxatli.beans.entity.GeneroSexual;
import mx.ryo.xoloit.amoxatli.service.GeneroSexualService;
import mx.ryo.xoloit.utils.exception.devel.DataNotFoundException;

@RestController
@RequestMapping("genders")
public class GeneroSexualController {
	@Autowired
	private GeneroSexualService generoSexualSrv;
	
	@RequestMapping("/all")
	public List<GeneroSexual> obtenerPaises() {
		return this.generoSexualSrv.obtenerTodo();
	}

	@RequestMapping("/search/{idGenero}")
	public GeneroSexual obtenerPais(@PathVariable Integer idGenero) throws DataNotFoundException {
		return this.generoSexualSrv.buscarBy(idGenero);
	}
}
