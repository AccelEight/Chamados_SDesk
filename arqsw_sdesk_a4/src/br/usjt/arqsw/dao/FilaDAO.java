package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;
@Repository
public class FilaDAO {
	/**
	 * 
	 * @author  Accel Gustavo Araújo Rocha - RA:81616654 - SIN3AN-MCA
	 *
	 */
	@PersistenceContext
	EntityManager manager;
	
	public List<Fila> listarFilas() throws IOException {
		return manager.createQuery("select f from Fila f").getResultList();
	}

	public Fila carregar(int id) throws IOException {
		return manager.find(Fila.class, id);
	}
	
	public void criarFila(Fila fila){
		manager.persist(fila);
	}
	
	public void fecharFila(Fila fila){
		manager.remove(fila);
	}
	
	
}
