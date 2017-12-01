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
import br.ucsal.h4h.model.TipoDoacao;
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
			ResultSet rs = stmt.executeQuery("select id_doacao, data_doacao, quantidade_doacao,id_instituicao,login_instituicao,senha_instituicao,email_instituicao,id_usuario,login_usuario,senha_usuario,email_usuario,id.tipo_doacao,nome_tipo from doacoes,instituicoes,usuarios");
			while (rs.next()) {
				Doacao d = new Doacao();
				d.setId(rs.getInt("id_doacao"));
				d.setDataDoacao(rs.getDate("data_doacao"));
				d.setQuantidade(rs.getString("quantidade_doacao"));
				Usuario u = new Usuario();
				u.setId(rs.getInt("id_usuario"));
				u.setLogin(rs.getString("login_usuario"));
				u.setSenha(rs.getString("senha_usuario"));
				u.setEmail(rs.getString("email_usuario"));
				d.setUsuario(u);
				Instituicao i = new Instituicao();
				i.setId(rs.getInt("id_instituicao"));
				i.setLogin(rs.getString("login_instituicao"));
				i.setSenha(rs.getString("senha_instituicao"));
				i.setEmail(rs.getString("email.instituicoes"));
				d.setInstituicao(i);
				TipoDoacao t=new TipoDoacao();
				t.setId(rs.getInt("id.tipo_doacao "));
				t.setNomeTipo(rs.getString("nome_tipo"));
				d.setTipoDoacao(t);
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
			PreparedStatement ps = conexao.getConnection().prepareStatement("insert into doacoes (data_doacao, quantidade_doacao,id_instituicao,id_doacao,id.tipo_doacao) values (?,?,?,?,?);");
                        ps.setDate(1, doacao.getDataDoacao());
			ps.setString(2, doacao.getQuantidade());
			ps.setInt(3, doacao.getInstituicao().getId());
			ps.setInt(4, doacao.getUsuario().getId());
			ps.setInt(5, doacao.getTipoDoacao().getId());
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
					.prepareStatement("update doacoes set data_doacao=?, quantidade_doacao=?,id_instituicao=?,id_doacao=?,id.tipo_doacao=? where id =?;");
			ps.setDate(1, doacao.getDataDoacao());
			ps.setString(2, doacao.getQuantidade());
			ps.setInt(3, doacao.getInstituicao().getId());
			ps.setInt(4, doacao.getUsuario().getId());
			ps.setInt(5, doacao.getTipoDoacao().getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
