package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import com.sun.istack.internal.NotNull;

/**
 * 
 * @author Accel Gustavo Araujo Rocha RA 81616654 SI3AN-MCA
 *
 */
@Entity
@Table
public class Chamado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @NotNull(message="O Chamado não pode ser vazio")
	// @Min(value=1, message="O Chamado não pode ser vazio")
	@Column(name = "id_chamado")
	@Id
	@GeneratedValue
	private int id;

	@NotNull(message = "A descri��o n�o pode ser vazia")
	@Size(min = 5, max = 100, message = "A descri��o deve estar entre 5 e 100 caracteres.")
	@Column
	private String descricao;
	@NotNull
	@Column
	private String status;
	@NotNull
	@Column
	private Date dt_abertura;
	@Column
	private Date dt_fechamento;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_fila")
	private Fila fila;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDt_abertura() {
		return dt_abertura;
	}

	public void setDt_abertura(Date dt_abertura) {
		this.dt_abertura = dt_abertura;
	}

	public Date getDt_fechamento() {
		return dt_fechamento;
	}

	public void setDt_fechamento(Date dt_fechamento) {
		this.dt_fechamento = dt_fechamento;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}

}