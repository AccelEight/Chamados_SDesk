package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.List;

import br.usjt.arqsw.dao.FilaDAO;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Accel Gustavo Araujo Rocha RA 81616654 SI3AN-MCA
 *
 */
@Service
public class FilaService {
	private FilaDAO dao;

	@Autowired
	public FilaService(FilaDAO dao) {
		this.dao = dao;
	}

	public List<Fila> listarFilas() throws IOException {
		return dao.listarFilas();
	}

	public Fila carregar(int id) throws IOException {
		return dao.selecionar(id);
	}
}