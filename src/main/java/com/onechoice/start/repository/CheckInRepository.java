package com.onechoice.start.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;



import com.onechoice.start.entites.CheckIn;

public interface CheckInRepository  extends JpaRepository<CheckIn, Integer>{
	
	
	

}
