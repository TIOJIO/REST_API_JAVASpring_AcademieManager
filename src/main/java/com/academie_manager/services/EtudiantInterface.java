package com.academie_manager.services;

import java.util.List;

import com.academie_manager.entities.Etudiant;

public interface EtudiantInterface {
   
	public Etudiant createOrUpdateEtudiant(Etudiant e);
	
	public List<Etudiant> getAllEtudiants ();
	
	public Etudiant deleteEtudiant(Short codeEtudiant);
	
	public void deleteAll();
	
	public List<Etudiant> findByEtudiantName(String etudiantName);
	
	public List<Etudiant> findByEtudiantEmail(String etudiantEmail);
	
	public Etudiant findByUserCode(Short userId);
	
	public long countEtudiant();
}
