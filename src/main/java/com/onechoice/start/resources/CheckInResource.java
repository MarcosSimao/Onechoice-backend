package com.onechoice.start.resources;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onechoice.start.dto.CheckInDto;
import com.onechoice.start.dto.HospedesDto;
import com.onechoice.start.entites.CheckIn;
import com.onechoice.start.entites.Hospedes;
import com.onechoice.start.services.CheckInService;

@RestController
@RequestMapping(value="/checkin")
public class CheckInResource {

	@Autowired
	private CheckInService serviCheck;
	
	 @RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<CheckInDto>> findAll(){
	    	List<CheckIn> list = serviCheck.findAll();
	    	List<CheckInDto> listDto = list.stream().map(x -> new CheckInDto(x)).collect(Collectors.toList());
			
			return ResponseEntity.ok().body(listDto);
			
		}
	 @RequestMapping(value="/{id}", method = RequestMethod.GET)
	  	public ResponseEntity<CheckInDto> findById(@PathVariable Integer id){
	      	CheckIn check = serviCheck.findById(id);
	      	
	  		return ResponseEntity.ok().body( new CheckInDto(check));
	  		
	  	}
	 @RequestMapping(value="/hospede/{id}", method = RequestMethod.GET)
	  	public ResponseEntity<CheckInDto> findByHospede(@PathVariable Integer id){
		 
	      CheckIn check = serviCheck.findByHospede(id);
	     return ResponseEntity.ok().body( new CheckInDto(check));
	  		
	  	}
	 @RequestMapping(value="/hospede/nome/{nome}", method = RequestMethod.GET)
	  	public ResponseEntity<CheckInDto> findByHospede(@PathVariable String nome){
		 
	      CheckIn check = serviCheck.findByHospedeNome(nome);
	      
	    return ResponseEntity.ok().body( new CheckInDto(check));
	  		
	  	}
	 @RequestMapping(value="/hospede/documento/{documento}", method = RequestMethod.GET)
	  	public ResponseEntity<CheckInDto> findByHospedeDocumento(@PathVariable String documento){
		 
	      CheckIn check = serviCheck.findByHospedeDocumento(documento);
	return ResponseEntity.ok().body( new CheckInDto(check));
	  		
	  	}
	 @RequestMapping(value="/hospede/telefone/{telefone}", method = RequestMethod.GET)
	  	public ResponseEntity<CheckInDto> findByHospedeTelefone(@PathVariable String telefone){
		 
	      CheckIn check = serviCheck.findByHospedeTelefone(telefone);
	      return ResponseEntity.ok().body( new CheckInDto(check));
	  		
	  	}
}
