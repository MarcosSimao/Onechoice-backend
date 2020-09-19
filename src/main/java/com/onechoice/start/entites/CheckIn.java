package com.onechoice.start.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.onechoice.start.dto.CheckInDto;

@Entity
public class CheckIn implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	private Date dataEntrada;
	private Date dataSaida;
	private boolean adicionarVeiculos;
	@ManyToOne
	@JoinColumn(name="hospede_id")
	private Hospedes hospede;
	
	public CheckIn() {
		
	}

	public CheckIn(Integer codigo, Date dataEntrada, Date dataSaida, boolean adicionarVeiculos, Hospedes hospede) {
		super();
		this.codigo = codigo;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.adicionarVeiculos = adicionarVeiculos;
		this.hospede = hospede;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setId(Integer codigo) {
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

	public Hospedes getHospede() {
		return hospede;
	}

	public void setHospede(Hospedes hospede) {
		this.hospede = hospede;
	}

	@Override
	public String toString() {
		return "CheckIn [id=" + codigo + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida
				+ ", adicionarVeiculos=" + adicionarVeiculos + ", hospede=" + hospede + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	

}
