package model;

import java.sql.Date;

public class Contato {
	
	private int id;
	private String nome;
	private String sobrenome;
	private String telefone;
	private Date nascimento;
	private int idade;
	private String endereco;
	private String email;

	public Contato() {
		
	}
	
	public Contato(int id, String nome, String sobrenome,String telefone, 
				   Date nascimento, String endereco,String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.email = email;
	}
	
	public Contato(int id, String nome, String sobrenome, String telefone, 
				   Date nascimento, int idade, String endereco,String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.idade = idade;
		this.endereco = endereco;
		this.email = email;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimneto) {
		this.nascimento = nascimneto;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}