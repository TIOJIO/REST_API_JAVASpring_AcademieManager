
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
import com.academie_manager.entities.Enseignant;
import com.academie_manager.entities.Etudiant;
import com.academie_manager.services.DepartementService;
import com.academie_manager.services.EnseignantService;
import com.academie_manager.services.EtudiantService;

import jakarta.websocket.server.PathParam;


@Controller
@RequestMapping(value = "/enseigant")
public class EnseignantControler {

	@Autowired 
	EnseignantService enseigantService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Enseignant> saveEnseigant(@RequestBody Enseignant e){
		System.out.println(e);
		return new ResponseEntity<Enseignant>(enseigantService.createOrUpdateEnseignant(e),HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getAll" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(enseigantService.getAllEnseignant(),HttpStatus.OK); 
	}
	
	@DeleteMapping(value="/delete/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("id") Short codeEtud){
		
		return new ResponseEntity<>(enseigantService.deleteEnseignant(codeEtud),HttpStatus.OK); 
	}
	
	@GetMapping(value="/search" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchEnseigant(@PathParam("token") String token){
		
		List<Enseignant> liste= enseigantService.findByEnseignantNomEtud(token);
	
		return new ResponseEntity<>(liste,HttpStatus.OK); 
	}
	
	
}

