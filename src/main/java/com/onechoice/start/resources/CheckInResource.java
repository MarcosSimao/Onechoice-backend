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
}
