package com.onechoice.start.entites;

import java.io.Serializable;
import java.util.Date;


public class CheckIn implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date dataEntrada;
	private Date dataSaida;
	private boolean adicionarVeiculos;
	private Hospedes hospede;
	
	public CheckIn() {
		
	}

	public CheckIn(Integer id, Date dataEntrada, Date dataSaida, boolean adicionarVeiculos, Hospedes hospede) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.adicionarVeiculos = adicionarVeiculos;
		this.hospede = hospede;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Hospedes getHospede() {
		return hospede;
	}

	public void setHospede(Hospedes hospede) {
		this.hospede = hospede;
	}

	@Override
	public String toString() {
		return "CheckIn [id=" + id + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida
				+ ", adicionarVeiculos=" + adicionarVeiculos + ", hospede=" + hospede + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckIn other = (CheckIn) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
