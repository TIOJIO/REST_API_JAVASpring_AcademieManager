
package com.academie_manager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.academie_manager.entities.Salle;
import com.academie_manager.services.SalleService;

import jakarta.websocket.server.PathParam;


@Controller
@RequestMapping(value = "/salle")
public class SalleControler {

	@Autowired 
	SalleService salleService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Salle> savesalle(@RequestBody Salle s){
		return new ResponseEntity<Salle>(salleService.createOrUpdateSalle(s),HttpStatus.OK);
	}
	
	@GetMapping(value="/getAll" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(salleService.getAllSalle(),HttpStatus.OK); 
	}
	
	@DeleteMapping(value="/delete/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("id") Short numsalle){
		
		return new ResponseEntity<>(salleService.deleteSalle(numsalle),HttpStatus.OK); 
	}
	

	
	
}

