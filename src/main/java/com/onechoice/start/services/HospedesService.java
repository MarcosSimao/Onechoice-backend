package com.onechoice.start.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.onechoice.start.dto.HospedesDto;
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

public Hospedes insert(Hospedes hospede) {
	
		
	return hos.saveAndFlush(hospede);
	
}
public Hospedes fromDto(HospedesDto dto) {
	return new Hospedes(dto.getId(),dto.getNome(),dto.getDocumento(),dto.getTelefone());
	
}

public void delete(Integer id) {
	findById(id);
	hos.deleteById(id);
}
public Hospedes update(Hospedes hospede) {
	
	Hospedes hospedeUpdate= findById(hospede.getId());
	configUpdate(hospedeUpdate,hospede);
	return hos.saveAndFlush(hospedeUpdate);
	
}
public void configUpdate(Hospedes hospedeUpdate,Hospedes hospede) {
	hospedeUpdate.setNome(hospede.getNome());
	hospedeUpdate.setDocumento(hospede.getDocumento());
	hospedeUpdate.setTelefone(hospede.getTelefone());
}

}
