package fr.afpa.gestion.inscription.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import fr.afpa.gestion.inscription.dto.Dto;
import fr.afpa.gestion.inscription.exception.ResourceNotFoundException;

public interface IController<TDto extends Dto> {

	

	ResponseEntity<List<TDto>> findAll();

	
	ResponseEntity<Page<TDto>> findAllPagination(Integer page, Integer size, String sortBy);

	
	ResponseEntity<TDto> findById(Integer id) throws ResourceNotFoundException;

	ResponseEntity<TDto> create(TDto elementParam);

	ResponseEntity<Boolean> delete(Integer id) throws ResourceNotFoundException;

	ResponseEntity<TDto> update(Integer id, TDto elementParam);

}
