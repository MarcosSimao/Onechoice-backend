package com.onechoice.start.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
}
