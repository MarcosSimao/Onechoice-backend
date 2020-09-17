package com.onechoice.start.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onechoice.start.entites.Hospedes;


@RestController
@RequestMapping(value="/hospedes")
public class HospedesResource {
    @GetMapping
	public ResponseEntity<Hospedes> findAll(){
		Hospedes hospede = new Hospedes(null,"Marcos","34564","99983773");
		return ResponseEntity.ok().body(hospede);
		
	}
	
}
