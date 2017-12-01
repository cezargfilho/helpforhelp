package br.ucsal.h4h.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.h4h.model.TipoDoacao;
import br.ucsal.h4h.util.Conexao;

public class TipoDoacaoDAO {

	private Conexao conexao;

	public TipoDoacaoDAO() {

		this.conexao = Conexao.getConexao();
	}

	public List<TipoDoacao> listar() {

		Statement stmt;
		List<TipoDoacao> tipoDoacoes = new ArrayList<>();
		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select id_tipo_doacao, nome_doacao from tipo_doacoes");
			while (rs.next()) {
				TipoDoacao td = new TipoDoacao ();
				td.setId(rs.getInt("id_tipo"));
				td.setNomeTipo(rs.getString("nome_doacao"));
                tipoDoacoes.add(td);
				
			}
			stmt.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return tipoDoacoes;

	}

	/*public void inserir(TipoDoacao tipoDoacao) {
		try {
			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("Insert into tipo_doacoes (nome_doacao) values (?);");
			ps.setString(1, tipoDoacao.getNomeTipo());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
*/
	public TipoDoacao getByID(int cod) {

		TipoDoacao td = null;

		try {
			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("select nome_doacao from tipo_doacoes where id=?");
			ps.setInt(1, cod);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				td= new TipoDoacao();
				td.setId(rs.getInt("id_tipo_doacao"));
				td.setNomeTipo(rs.getString("nome_doacao"));
	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return td;

	}

	public void close() {
		conexao.closeConnection();
	}
	
	public void delete(int id) {
		PreparedStatement ps;
		try {
			ps = conexao.getConnection().prepareStatement("delete from tipo_doacoes where id=?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void update(TipoDoacao tipoDoacao) {
		try {
			
			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("update tipo_doacoes set nome_doacao=? where id =?;");
			ps.setString(2, tipoDoacao.getNomeTipo());
			ps.setInt(3, tipoDoacao.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}