package fr.afpa.gestion.inscription.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.afpa.gestion.inscription.dto.Dto;

public interface IGeneriqueService<Tdto extends Dto> {

	Tdto findByID(Integer id);

	Tdto create(Tdto t);

	Tdto update(Integer id, Tdto t);

	void delete(Integer id);

	Page<Tdto> getAll(Pageable paging); 

	List<Tdto> findAll();

}