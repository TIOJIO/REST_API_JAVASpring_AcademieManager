
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

import com.academie_manager.entities.College;
import com.academie_manager.entities.Departement;
import com.academie_manager.entities.Etudiant;
import com.academie_manager.services.CollegeService;
import com.academie_manager.services.DepartementService;
import com.academie_manager.services.EtudiantService;

import jakarta.websocket.server.PathParam;


@Controller
@RequestMapping(value = "/college")
public class CollegeControler {

	@Autowired 
	CollegeService collegeService;
	
	
	
	
}
