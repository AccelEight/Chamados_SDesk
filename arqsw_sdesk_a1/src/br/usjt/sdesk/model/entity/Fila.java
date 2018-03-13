package br.usjt.sdesk.model.entity;

/**
 * 
 * @author Accel Gustavo Araújo Rocha  RA: 81616654	 SI3AN-MCA
 *
 */
public class Fila {
	private int id;
	private String nome;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Fila [id=" + id + ", nome=" + nome + "]";
	}
	
	
}
