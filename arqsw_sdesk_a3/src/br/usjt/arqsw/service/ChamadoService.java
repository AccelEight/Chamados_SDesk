package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.List;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Accel Gustavo Araujo Rocha RA 81616654 SI3AN-MCA
 *
 */
@Service
public class ChamadoService {
	private ChamadoDAO dao;

	@Autowired
	public ChamadoService(ChamadoDAO dao) {
		this.dao = dao;
	}

	@Transactional
	public List<Chamado> listarChamados(Fila fila) throws IOException {
		return dao.listarChamados(fila);
	}

	@Transactional
	public void cadastrarChamado(Chamado chamado) throws IOException {
		dao.cadastrarChamado(chamado);
	}

}