package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author Accel Gustavo Araújo Rocha	RA 81616654	SI3AN MCA
 *
 */
@Repository
public class ChamadoDAO {
	private Connection conn;
	
	@Autowired
	public ChamadoDAO(DataSource dataSource) throws IOException{
		try{
			this.conn = dataSource.getConnection();
		}catch (SQLException e){
			throw new IOException(e);
		}
	}
	
//falhei aqui :( não entendi - PDF Aula02/pag 18
	public void excluir(Chamado chamado) throws IOException {
		String sqlDelete = "delete from chamado where idchamado=?";
		try (PreparedStatement pst = conn.prepareStatement(sqlDelete);) {
			pst.setInt(1, chamado.getId());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}
	//terminei aqui
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException{
		String sqlSelect = "select * from chamado WHERE chamado.ID_FILA = ?";		
		ArrayList<Chamado> lista = new ArrayList<>();
		
		try (   PreparedStatement pst = conn.prepareStatement(sqlSelect);) {
				pst.setInt(1, fila.getId());
			
			try(ResultSet rs = pst.executeQuery();){
				while(rs.next()){
					Chamado chamado = new Chamado();
					chamado.setNumero(rs.getInt("id_chamado"));
					chamado.setDescricao(rs.getString("descricao"));
					chamado.setDataAbertura(rs.getDate("dt_abertura"));
					fila.setNome(rs.getString("nm_fila"));
					chamado.setFila(fila);
					lista.add(chamado);
				}
			} catch(SQLException e){
				e.printStackTrace();
				throw new IOException(e);
			}
		} catch(SQLException e){
			e.printStackTrace();
			throw new IOException(e);
		}
		return lista;
	}
	
}
