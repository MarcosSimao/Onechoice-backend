package com.onechoice.start.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.onechoice.start.dto.CheckInDto;
import com.onechoice.start.entites.CheckIn;
import com.onechoice.start.entites.Hospedes;
import com.onechoice.start.repository.CheckInRepository;
import com.onechoice.start.repository.HospedesRespository;

public class Instace implements CommandLineRunner {

	public void run(String... args) throws Exception {
		
		
		// TODO Auto-generated method stub
		String entrada ="2001-07-04T12:08:56";
		String saida = "2001-07-12T12:20:56";
		
		DateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		formato.setTimeZone(TimeZone.getTimeZone("GMT"));
		 Date dataSaida = formato.parse(saida);
		Date dataEntrada = formato.parse(entrada);
		Hospedes marcos = new Hospedes(null,"marcos andrade","999999","8364738993");
		Hospedes lucas = new Hospedes(null,"lucas simao","333333","8475649377");
		Hospedes leticia = new Hospedes(null,"leticia andrade","222222","908466378");
		
		
		CheckIn checkMarcos = new CheckIn(null,dataEntrada,dataSaida,false,marcos);
		CheckIn checkLucas = new CheckIn(null,dataEntrada,dataSaida,true,lucas);
		CheckIn checkLeticia = new CheckIn(null,dataEntrada,dataSaida,false,leticia);
		
		
		
				
				
		
	}

}
