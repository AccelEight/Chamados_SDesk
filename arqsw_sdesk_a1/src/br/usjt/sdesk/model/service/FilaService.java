package br.usjt.sdesk.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.sdesk.model.dao.FilaDAO;
import br.usjt.sdesk.model.entity.Fila;

/**
 * 
 * @author Accel Gustavo Araújo Rocha  RA: 81616654	 SI3AN-MCA
 *
 */
public class FilaService {
	private FilaDAO dao;
	
	public FilaService(){
		dao = new FilaDAO();
	}
	
	public ArrayList<Fila> listarFilas() throws IOException{
		return dao.listarFilas();
	}
	
	public Fila carregar(int id) throws IOException{
		return dao.carregar(id);
	}

}
