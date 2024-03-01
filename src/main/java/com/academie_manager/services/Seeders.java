package com.academie_manager.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.academie_manager.entities.Etudiant;
import com.academie_manager.repository.EtudiantRepos;

@Service
public class Seeders implements CommandLineRunner {
	@Autowired
	EtudiantRepos etudiantRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		etudiantRepo.deleteAll();
		List<Etudiant> liste = new ArrayList<>();
		for (int i=0  ;i<=1000 ; i++) {
			liste.add(this.generateEtudiant());
			
		}
		
		etudiantRepo.saveAll(liste);
	}

	
	public Etudiant generateEtudiant() {
		Random random = new Random();
		String nom = random.ints(97, 122).limit(30)
		             .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		             .toString();
		
		String tel = (int)(Math.random()*100000000)+"";
		int annee = (int)(Math.random()*3000);
		
		short code = (short)(Math.random()*1000);			
		return new Etudiant(code,annee,nom,tel);
	}
}
