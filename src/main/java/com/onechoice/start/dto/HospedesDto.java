package com.onechoice.start.dto;

import java.io.Serializable;

import com.onechoice.start.entites.Hospedes;

public class HospedesDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String documento;
	private String telefone;
	
	public HospedesDto() {
		
	}

	public HospedesDto(Hospedes hospede) {
		super();
		this.id = hospede.getId();
		this.nome = hospede.getNome();
		this.documento = hospede.getDocumento();
		this.telefone = hospede.getTelefone();
	}

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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

}
