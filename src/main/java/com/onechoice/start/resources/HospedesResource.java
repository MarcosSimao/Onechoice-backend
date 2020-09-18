package com.onechoice.start.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.onechoice.start.dto.HospedesDto;
import com.onechoice.start.entites.Hospedes;
import com.onechoice.start.services.HospedesService;


@RestController
@RequestMapping(value="/hospedes")
public class HospedesResource {
	@Autowired
	private HospedesService service;
	
    @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<HospedesDto>> findAll(){
    	List<Hospedes> list = service.findAll();
    	List<HospedesDto> listDto = list.stream().map(x -> new HospedesDto(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
		
	}
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
  	public ResponseEntity<HospedesDto> findById(@PathVariable Integer id){
      	Hospedes hospede = service.findById(id);
      	
  		return ResponseEntity.ok().body( new HospedesDto(hospede));
  		
  	}
    @RequestMapping(value="/nome/{nome}", method = RequestMethod.GET)
  	public ResponseEntity<HospedesDto> findByNome(@PathVariable String nome){
      	Hospedes hospede = service.findByNome(nome);
      	
  		return ResponseEntity.ok().body( new HospedesDto(hospede));
  		
  	}
    @RequestMapping(value="/documento/{documento}", method = RequestMethod.GET)
  	public ResponseEntity<HospedesDto> findByDocumento(@PathVariable String documento){
      	Hospedes hospede = service.findByDocumento(documento);
      	
  		return ResponseEntity.ok().body( new HospedesDto(hospede));
  		
  	}
    @RequestMapping(value="/telefone/{telefone}", method = RequestMethod.GET)
  	public ResponseEntity<HospedesDto> findByTelefone(@PathVariable String telefone){
      	Hospedes hospede = service.findByTelefone(telefone);
      	
  		return ResponseEntity.ok().body( new HospedesDto(hospede));
  		
  	}
    @RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody HospedesDto dto){
		Hospedes hospede = service.fromDto(dto);
	hospede= service.insert(hospede);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hospede.getId()).toUri();
		return ResponseEntity.created(uri).build();
		}
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		  service.delete(id);
		
		return ResponseEntity.noContent().build();
		}
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody HospedesDto dto,@PathVariable Integer id){
		Hospedes hospede = service.fromDto(dto);
		hospede.setId(id);
		hospede= service.update(hospede);
		return ResponseEntity.noContent().build();
		}
	
	
}
