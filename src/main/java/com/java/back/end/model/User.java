package com.java.back.end.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.java.back.end.dto.UserDTO;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private Date datacadastro;

	public User(long id, String nome, String cpf, String endereco, String email, String telefone, Date datacadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.datacadastro = datacadastro;
	}

	public User() {
		super();
	}

	/**
	 * O método convert , na classe User , é importante porque precisaremos
	 * converter instâncias da entidade User para instâncias da classe UserDTO .
	 * Isso será utilizado em diversos serviços, então é melhor ter um método que
	 * realiza essa operação do que ficar duplicando código em vários locais.
	 * 
	 * @param userDTO
	 * @return
	 */
	public static User convert(UserDTO userDTO) {
		User user = new User();
		user.setNome(userDTO.getNome());
		user.setEndereco(userDTO.getEndereco());
		user.setCpf(userDTO.getCpf());
		user.setEmail(userDTO.getEmail());
		user.setTelefone(userDTO.getTelefone());
		user.setDatacadastro(userDTO.getDataCadastro());
		return user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

}
