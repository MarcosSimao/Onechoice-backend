package com.onechoice.start.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onechoice.start.entites.CheckIn;
import com.onechoice.start.entites.Hospedes;
import com.onechoice.start.repository.CheckInRepository;

@Service
public class CheckInService {
@Autowired
private CheckInRepository check;

public List<CheckIn> findAll(){
	return check.findAll();
	}
}
