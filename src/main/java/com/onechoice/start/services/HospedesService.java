package com.onechoice.start.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.onechoice.start.entites.Hospedes;
import com.onechoice.start.repository.HospedesRespository;
import com.onechoice.start.services.exceptions.ObjectNotfoundException;

@Service
public class HospedesService {
	
@Autowired
private HospedesRespository hos;

public List<Hospedes> findAll(){
	return hos.findAll();
	}
	
public Hospedes findById(Integer id) {
	Optional<Hospedes> hospede = hos.findById(id);
	
 return hospede.orElseThrow(() -> new ObjectNotfoundException("hospede nao encontrado "));
	
}
public Hospedes findByNome(String nome) {

	
	Optional<Hospedes> hospede = hos.findByNome(nome);
	
	 return hospede.orElseThrow(() -> new ObjectNotfoundException("hospede nao encontrado "));
}

public Hospedes findByDocumento(String documento) {

	
	Optional<Hospedes> hospede = hos.findByDocumento(documento);
	
	 return hospede.orElseThrow(() -> new ObjectNotfoundException("hospede nao encontrado "));
}
public Hospedes findByTelefone(String telefone) {

	
	Optional<Hospedes> hospede = hos.findByTelefone(telefone);
	
	 return hospede.orElseThrow(() -> new ObjectNotfoundException("hospede nao encontrado "));
}
}
