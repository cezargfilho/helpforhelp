package br.ucsal.h4h.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.h4h.model.Usuario;
import br.ucsal.h4h.util.Conexao;


public class UsuarioDAO {

private Conexao conexao;

public UsuarioDAO() {
	this.conexao = Conexao.getConexao();
}
	
public List<Usuario> listar() {
	Statement stmt;
	List<Usuario> usuarios = new ArrayList<>();
	try {
		stmt = conexao.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery("select id_usuario, nome_usuario, cpf_usuario, telefone_usuario, email_usuario, endereco_usuario, login_usuario, senha_usuario from usuarios;");
		while(rs.next()) {
			Usuario u = new Usuario();
			u.setId(rs.getInt("id_usuario"));
			u.setNome(rs.getString("nome_usuario"));
			u.setCpf(rs.getString("cpf"));
			u.setTelefone(rs.getString("telefone"));
			u.setEmail(rs.getString("email"));
			u.setEndereco(rs.getString("endereco"));
			u.setLogin(rs.getString("login"));
			u.setSenha(rs.getString("senha"));
			usuarios.add(u);
		}
		stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return usuarios;
}

public void inserir(Usuario usuario) {
	try {
		
		PreparedStatement ps = conexao.getConnection()
				.prepareStatement("insert into usuarios (nome_usuario, cpf_usuario, telefone_usuario, email_usuario, endereco_usuario, login_usuario, senha_usuario) values (?,?,?,?,?,?,?);");
		ps.setString(1, usuario.getNome());
		ps.setString(2, usuario.getCpf());
		ps.setString(3, usuario.getTelefone());
		ps.setString(4, usuario.getEmail());
		ps.setString(5, usuario.getEndereco());
		ps.setString(6, usuario.getLogin());
		ps.setString(7, usuario.getSenha());
		ps.execute();
		ps.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

}

public Usuario getByID(int cod) {

	Usuario u = null;

	try {
		PreparedStatement ps = conexao.getConnection()
				.prepareStatement("select id_usuario, login_usuario, senha_usuario, email_usuario, cpf_usuario, endereco_usuario, telefone_usuario from usuarios where id=?");
		ps.setInt(1, cod);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			u = new Usuario();
			u.setId(rs.getInt("id_usuario"));
			u.setLogin(rs.getString("login_usuario"));
			u.setSenha(rs.getString("senha_usuario"));
			u.setEmail(rs.getString("email_usuario"));
			u.setCpf(rs.getString("cpf_usuario"));
			u.setEndereco(rs.getString("endereco_usuario"));
			u.setTelefone(rs.getString("telefone_usuario"));
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return u;

}

public void close() {
	conexao.closeConnection();
}

public void delete(int id) {
	PreparedStatement ps;
	try {
		ps = conexao.getConnection().prepareStatement("delete from usuarios where id=?");
		ps.setInt(1, id);
		ps.execute();
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}

public void update(Usuario usuario) {
	try {
		
		PreparedStatement ps = conexao.getConnection()
				.prepareStatement("update usuarios set nome_usuario=?, senha_usuario = ?, email_usuario = ? where id =?;");
		ps.setString(1, usuario.getNome());
		ps.setString(2, usuario.getSenha());
		ps.setString(2, usuario.getEmail());
		ps.setInt(3, usuario.getId());
		ps.execute();
		ps.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

}


}
