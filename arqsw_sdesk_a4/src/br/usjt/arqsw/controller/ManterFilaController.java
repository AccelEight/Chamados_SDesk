package br.usjt.arqsw.controller;

import java.io.IOException;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.FilaService;
/**
 * 
 * @author  Accel Gustavo Araújo Rocha - RA:81616654 - SIN3AN-MCA
 *
 */
@Transactional
@Controller
public class ManterFilaController {
	
	private FilaService fs;
	
	@Autowired
	public ManterFilaController(FilaService fs){
		this.fs = fs;
	}
	
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}
	
	@RequestMapping("criar_fila")
	public String criarChamado(@Valid Fila f, BindingResult result, Model model ) throws IOException{

		f.setNome("nome");
		fs.criar(f);
		return "index";
		
	}
	

}
