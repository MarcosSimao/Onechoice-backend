package com.onechoice.start.resources;



import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onechoice.start.entites.CheckIn;
import com.onechoice.start.entites.Hospedes;

@RestController
@RequestMapping(value="/checkin")
public class CheckInResource {

	
	 @GetMapping
		public ResponseEntity<CheckIn> findAll(){
		 Date entrada = new Date();
			CheckIn in = new CheckIn(null,entrada,null,true,new Hospedes(null,"marcos","344455","8474748449"));
			return ResponseEntity.ok().body(in);
			
		}
}
