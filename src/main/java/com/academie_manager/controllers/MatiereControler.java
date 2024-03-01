
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

import com.academie_manager.entities.Matiere;

import com.academie_manager.services.MatiereService;
import com.academie_manager.services.SalleService;

import jakarta.websocket.server.PathParam;


@Controller
@RequestMapping(value = "/matiere")
public class MatiereControler {

	@Autowired 
	MatiereService matiereService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Matiere> savematiere(@RequestBody Matiere m){
		return new ResponseEntity<Matiere>(matiereService.createOrUpdateMatiere(m),HttpStatus.OK);
	}
	
	@GetMapping(value="/getAll" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(matiereService.getAllMatiere(),HttpStatus.OK); 
	}
	
	
	@DeleteMapping(value="/delete/{codeMat}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("codeMat") String codeMat){
		matiereService.deleteMatiere(codeMat);
		return new ResponseEntity<String>("Matiere supprimé",HttpStatus.OK); 
	}
	

	
	
}

