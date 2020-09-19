package com.onechoice.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.onechoice.start.entites.CheckIn;

public interface CheckInRepository  extends JpaRepository<CheckIn, Integer>{

}
