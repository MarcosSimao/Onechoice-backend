package com.onechoice.start.dto;

import java.io.Serializable;
import java.util.Date;

import com.onechoice.start.entites.CheckIn;
import com.onechoice.start.entites.Hospedes;

public class CheckInDto implements Serializable {

	private Integer codigo;
	private Date dataEntrada;
	private Date dataSaida;
	private boolean adicionarVeiculos;
	private double conta;
	private Hospedes hospede;
	
	public CheckInDto() {
		
	}
public CheckInDto(CheckIn check) {
	this.codigo=check.getCodigo();
	this.dataEntrada=check.getDataEntrada();
	this.dataSaida=check.getDataSaida();
	this.adicionarVeiculos=check.isAdicionarVeiculos();
	this.hospede=check.getHospede();
	this.setConta(valorApagar(dataEntrada,dataSaida));
		
	}
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public boolean isAdicionarVeiculos() {
		return adicionarVeiculos;
	}
	public void setAdicionarVeiculos(boolean adicionarVeiculos) {
		this.adicionarVeiculos = adicionarVeiculos;
	}
	public double getConta() {
		return conta;
	}
	public void setConta(double conta) {
		this.conta = conta;
	}
	public Hospedes getHospede() {
		return hospede;
	}
	public void setHospede(Hospedes hospede) {
		this.hospede = hospede;
	}
	@Override
	public String toString() {
		return "CheckInDto [codigo=" + codigo + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida
				+ ", adicionarVeiculos=" + adicionarVeiculos + ", conta=" + conta + ", hospede=" + hospede + "]";
	}
	
	public double valorApagar(Date entrada,Date saida) {
		return 00;
	}
	
	
	
	
	
	

}
