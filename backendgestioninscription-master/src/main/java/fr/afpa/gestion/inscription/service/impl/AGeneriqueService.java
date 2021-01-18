package fr.afpa.gestion.inscription.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.afpa.gestion.inscription.dto.Dto;
import fr.afpa.gestion.inscription.exception.BadRequestException;
import fr.afpa.gestion.inscription.exception.ResourceNotFoundException;
import fr.afpa.gestion.inscription.service.IGeneriqueService;
import fr.afpa.gestion.inscription.service.util.LinkCreator;
import fr.afpa.gestion.inscription.service.util.Mapper;
import fr.afpa.gestion.inscription.service.util.MapperWithLink;

public abstract class AGeneriqueService<T, TDto extends Dto, TDao extends JpaRepository<T, Integer>>
		implements IGeneriqueService<TDto> {

	private LinkCreator<TDto> lCr;
	private TDao tdao;

	private Class<T> classT;
	private Class<TDto> classDto;

	public void setlCr(LinkCreator<TDto> lCr) {
		this.lCr = lCr;
	}

	public void setTdao(TDao tdao) {
		this.tdao = tdao;
	}

	public final void setClassT(final Class<T> classT) {
		this.classT = classT;
	}

	public final void setClassDto(final Class<TDto> classDto) {
		this.classDto = classDto;
	}

	@Override
	public TDto findByID(Integer id) {

		Optional<T> opt = tdao.findById(id);

		if (!opt.isPresent()) {
			throw new ResourceNotFoundException("l' " + id + " non trouvé");
		} else {
			T t = opt.get();

			return MapperWithLink.map(t, classDto, lCr);
		}

	}

	@Override
	public List<TDto> findAll() {
		List<T> liste = tdao.findAll();
		if (liste.isEmpty()) {
			throw new ResourceNotFoundException("liste vide");

		} else {

			return MapperWithLink.map(liste, classDto, lCr);
		}

	}

	@Transactional
	@Override
	public void delete(Integer id) {

		Optional<T> opt = tdao.findById(id);
		if (!opt.isPresent()) {
			throw new ResourceNotFoundException("l'entite dont l'id est " + id + " n'existe pas");
		} else {

			tdao.deleteById(id);
			System.out.println("effacement ok");
		}
		// TODO Auto-generated method stub

	}

	@Override
	public Page<TDto> getAll(Pageable paging) {

		// (Integer pageNo, Integer pageSize, String sortBy) {

		// Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<T> pagedResult = tdao.findAll(paging);
		if (pagedResult.hasContent()) {
			List<TDto> list = MapperWithLink.map(pagedResult.getContent(), classDto, lCr);
			Page<TDto> pagedto = new PageImpl<>(list, paging, pagedResult.getTotalElements());

			return pagedto;
		} else {
			throw new ResourceNotFoundException("liste vide");
		}

	}
	
	
	
}
