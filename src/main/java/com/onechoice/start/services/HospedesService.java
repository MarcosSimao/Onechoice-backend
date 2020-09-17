package com.onechoice.start.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onechoice.start.entites.Hospedes;
import com.onechoice.start.repository.HospedesRespository;

@Service
public class HospedesService {
	
@Autowired
private HospedesRespository hos;

public List<Hospedes> findAll(){
	return hos.findAll();
	}
	

}
