package com.onechoice.start.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

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
	this.setConta(valorApagar(dataEntrada,dataSaida,adicionarVeiculos));
		
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
	
	public double valorApagar(Date entrada,Date saida,boolean garagem) {
		Double valor=00.00;
		DateTime inicio = new DateTime(entrada);
		DateTime fim = new DateTime(saida);
		int resultado = Days.daysBetween(inicio, fim).getDays();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataEntrada);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		
		for(int i=1;i<=resultado;i++) {
			switch (day) {
			
			case 1:
	           valor+=150.00;
	           if(garagem) {
	        	   valor+=20.00;  
	        	   
	           }
	           day++;
				break;
			case 2:
				valor+=120.00;
				 if(garagem) {
		        	   valor+=15.00;  
		           }
				 day++;
				break;
			case 3:
				valor+=120.00;
				 if(garagem) {
		        	   valor+=15.00;  
		           }
				 day++;
				break;
			case 4:
				valor+=120.00;
				 if(garagem) {
		        	   valor+=15.00;  
		           }
				 day++;
				break;
			case 5:
				valor+=120.00;
				 if(garagem) {
		        	   valor+=15.00;  
		           }
				 day++;
				break;
			case 6:
				valor+=120.00;
				 if(garagem) {
		        	   valor+=15.00;  
		           }
				 day++;
				break;
			case 7:
				 if(garagem) {
		        	   valor+=20.00;  
		           }
				valor+=150.00;
				day=1;
				break;
				
			}
			
			}
		ultimoDia(day,valor,garagem);

		return valor;
	}
	
	
	public void ultimoDia(int day,double valor,boolean garagem) {
		if(day==1) {
			valor+=150.00;
			if(garagem) {
	        	   valor+=20.00;  
	           }
		}else if(day==2) {
			valor+=120.00;
			 if(garagem) {
	        	   valor+=15.00;  
	           }
		}else if(day==3) {
			valor+=120.00;
			 if(garagem) {
	        	   valor+=15.00;  
	           }
		}else if(day==4) {
			valor+=120.00;
			 if(garagem) {
	        	   valor+=15.00;  
	           }
		}else if(day==5) {
			valor+=120.00;
			 if(garagem) {
	        	   valor+=15.00;  
	           }
		}else if(day==6) {
			valor+=120.00;
			 if(garagem) {
	        	   valor+=15.00;  
	           }
		}else if(day==7) {
			valor+=150.00;
			
			if(garagem) {
	        	   valor+=20.00;  
	           }
		}
	}
	
	
	

}
