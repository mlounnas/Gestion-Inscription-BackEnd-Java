package fr.afpa.gestion.inscription.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public abstract class Dto extends RepresentationModel <Dto> implements Serializable {
	
	

	public abstract Integer getId(); 
	
 

}
