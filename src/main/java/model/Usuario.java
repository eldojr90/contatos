package model;

public class Usuario {
	
	private int id;
	private String nome;
	private String nomeDeUsuario;
	private String senha;

	public Usuario() {
		
	}
	
	public Usuario(int id, String nome, String nomeDeUsuario, String senha) {
		this.id = id;
		this.nome = nome;
		this.nomeDeUsuario = nomeDeUsuario;
		this.senha = senha;
	}

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
	
	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}

	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
