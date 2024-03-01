

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

import com.academie_manager.entities.Departement;
import com.academie_manager.entities.Etudiant;
import com.academie_manager.services.DepartementService;
import com.academie_manager.services.EtudiantService;

import jakarta.websocket.server.PathParam;


@Controller
@RequestMapping(value = "/departement")
public class DepartementControler {

	@Autowired 
	DepartementService departementService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Departement> saveEtudiant(@RequestBody Departement d){
		return new ResponseEntity<Departement>(departementService.createOrUpdateDepartement(d),HttpStatus.OK);
	}
	
	@GetMapping(value="/getAll" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(departementService.getAllDepartement(),HttpStatus.OK); 
	}
	
	@DeleteMapping(value="/delete/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("id") Short codeDepart){
		
		return new ResponseEntity<>(departementService.deleteDepartement(codeDepart),HttpStatus.OK); 
	}
	
	@GetMapping(value="/search" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchDepartemet(@PathParam("token") String token){
		
		List<Departement> liste= departementService.findByDepartementLabelDepart(token);
	
		return new ResponseEntity<>(liste,HttpStatus.OK); 
	}
	
	
}
