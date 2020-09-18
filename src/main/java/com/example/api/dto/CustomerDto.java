package com.example.api.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CustomerDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Length(min=5, max=80, message="O tamanho deve ser entre 3 e 120 caracteres")
	@Column(nullable = false)
	@NotEmpty(message="Preenchimento do campo nome é obrigatório.")
	private String name;
	
	@Column(nullable = false)
	@NotEmpty(message="Preenchimento do campo email é obrigatório.")
	@Email
	private String email;
	
	@NotEmpty(message="campo obrigatório")
	private String logradouro;
	
	private String numero;

	private String complemento;
	
	@NotEmpty(message="campo obrigatório")
	private String bairro;
	
	@NotEmpty(message="campo obrigatório")
	private String cep;
	
	public CustomerDto () {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
