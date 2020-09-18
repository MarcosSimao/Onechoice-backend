package com.onechoice.start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onechoice.start.entites.Hospedes;

public interface HospedesRespository  extends JpaRepository<Hospedes, Integer>{



	Optional<Hospedes> findByNome(String nome);

	Optional<Hospedes> findByDocumento(String documento);

	Optional<Hospedes> findByTelefone(String telefone);

	
	

	
}
