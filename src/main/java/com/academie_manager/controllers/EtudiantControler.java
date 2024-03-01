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

import com.academie_manager.entities.Etudiant;
import com.academie_manager.services.EtudiantService;

import jakarta.websocket.server.PathParam;


@Controller
@RequestMapping(value = "/etudiant")
public class EtudiantControler {

	@Autowired 
	EtudiantService etudiantService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Etudiant> saveEtudiant(@RequestBody Etudiant e){
		return new ResponseEntity<Etudiant>(etudiantService.createOrUpdateEtudiant(e),HttpStatus.OK);
	}
	
	@GetMapping(value="/getAll" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(etudiantService.getAllEtudiants(),HttpStatus.OK); 
	}
	
	@DeleteMapping(value="/delete/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("id") Short id){
		
		return new ResponseEntity<>(etudiantService.deleteEtudiant(id),HttpStatus.OK); 
	}
	

	
	@GetMapping(value="/search" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchEtudiant(@PathParam("token") String token){
		
		List<Etudiant> liste= etudiantService.findByEtudiantName(token);
		       liste.addAll(etudiantService.findByEtudiantEmail(token));
	
		return new ResponseEntity<>(liste,HttpStatus.OK); 
	}
	
	
}
