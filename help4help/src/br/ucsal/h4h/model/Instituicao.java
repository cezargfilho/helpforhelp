package br.ucsal.h4h.model;

public class Instituicao {

	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	private String login;
	private String senha;
	private TipoDoacao tipo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public TipoDoacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoDoacao tipo) {
		this.tipo = tipo;
	}
	
	
	
}
