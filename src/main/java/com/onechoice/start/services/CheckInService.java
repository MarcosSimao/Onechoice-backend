package com.onechoice.start.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onechoice.start.entites.CheckIn;
import com.onechoice.start.entites.Hospedes;
import com.onechoice.start.repository.CheckInRepository;
import com.onechoice.start.repository.HospedesRespository;
import com.onechoice.start.services.exceptions.ObjectNotfoundException;

@Service
public class CheckInService {

	@Autowired
	private CheckInRepository check;

	@Autowired
	private HospedesRespository hos;

	public List<CheckIn> findAll() {
		return check.findAll();
	}

	public CheckIn findById(Integer id) {
		Optional<CheckIn> hospede = check.findById(id);

		return hospede.orElseThrow(() -> new ObjectNotfoundException("esse hospede nao esta mais no Hotel "));

	}

	

	public CheckIn findByHospede(Integer id) {
       List<CheckIn> find = check.findAll();
       for (CheckIn ch : find) {
    	   if(ch.getHospede().getId()==id) {
    		   Optional<CheckIn>check1 = check.findById(ch.getCodigo());
    		   return check1.orElseThrow(() -> new ObjectNotfoundException("hospede nao encontrado "));
    	   }
       }
	return null;
		
		
		
		 
	}
	
	public CheckIn findByHospedeNome(String nome) {
		Optional<Hospedes> hospede= hos.findByNome(nome);
		Hospedes hosp = hospede.get();
		
		  List<CheckIn> find = check.findAll();
	       for (CheckIn ch : find) {
	    	   if(ch.getHospede().getId()==hosp.getId()) {
	    		   Optional<CheckIn>check1 = check.findById(ch.getCodigo());
	    		   return check1.orElseThrow(() -> new ObjectNotfoundException("hospede nao encontrado "));
	    	   }
	       }
		return null;
		
	}
	public CheckIn findByHospedeDocumento(String documento) {
		Optional<Hospedes> hospede= hos.findByDocumento(documento);
		Hospedes hosp = hospede.get();
		
		  List<CheckIn> find = check.findAll();
	       for (CheckIn ch : find) {
	    	   if(ch.getHospede().getId()==hosp.getId()) {
	    		   Optional<CheckIn>check1 = check.findById(ch.getCodigo());
	    		   return check1.orElseThrow(() -> new ObjectNotfoundException("hospede nao encontrado "));
	    	   }
	       }
		return null;
		
	}
	public CheckIn findByHospedeTelefone(String telefone) {
		Optional<Hospedes> hospede= hos.findByTelefone(telefone);
		Hospedes hosp = hospede.get();
		
		  List<CheckIn> find = check.findAll();
	       for (CheckIn ch : find) {
	    	   if(ch.getHospede().getId()==hosp.getId()) {
	    		   Optional<CheckIn>check1 = check.findById(ch.getCodigo());
	    		   return check1.orElseThrow(() -> new ObjectNotfoundException("hospede nao encontrado "));
	    	   }
	       }
		return null;
		
	}

	
	

}
