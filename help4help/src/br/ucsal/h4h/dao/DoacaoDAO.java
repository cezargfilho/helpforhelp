package br.ucsal.h4h.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.h4h.model.Doacao;
import br.ucsal.h4h.model.Instituicao;
import br.ucsal.h4h.model.Usuario;
import br.ucsal.h4h.util.Conexao;

public class DoacaoDAO {

	private Conexao conexao;

	public DoacaoDAO() {
		this.conexao = Conexao.getConexao();
	}

	public List<Doacao> listar() {

		Statement stmt;
		List<Doacao> doacao = new ArrayList<>();

		try {
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select from doacoes where ");
			while (rs.next()) {
				Doacao d = new Doacao();
				d.setId(rs.getInt("cod_doacao"));

				Usuario u = new Usuario();
				u.setId(rs.getInt("id_usuario"));
				u.setLogin(rs.getString("login_usuario"));
				u.setSenha(rs.getString("senha_usuario"));
				u.setEmail(rs.getString("email_usuario"));
				d.setUsuario(u);
				Instituicao i = new Instituicao();
				i.setId(rs.getInt("id_instituicao"));
				i.setLogin(rs.getString("login_instituicao"));
				i.setSenha(rs.getString("senha_instituicao,"));
				i.setEmail(rs.getString("email.instituicoes"));
				d.setInstituicao(i);
				doacao.add(d);

			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doacao;

	}

	public void inserir(Doacao doacao) {

		try {
			PreparedStatement ps = conexao.getConnection().prepareStatement("insert into doacoes () values ();");

			ps.setInt(2, doacao.getUsuario().getId());
			ps.setString(3, doacao.getUsuario().getLogin());
			ps.setInt(4, doacao.getInstituicao().getId());
			ps.setString(5, doacao.getInstituicao().getLogin());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		PreparedStatement ps;
		try {
			ps = conexao.getConnection().prepareStatement("delete from doacoes where id=?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Doacao doacao) {
		try {

			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("update doacoes set EDITAR=?,EDITAR = ? where id =?;");
			ps.setString(1, doacao.getQuantidade());
			ps.setString(2, doacao.getDataDoacao());
			ps.setInt(3, doacao.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}