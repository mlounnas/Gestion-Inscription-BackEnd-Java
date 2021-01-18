package fr.afpa.gestion.inscription.service.util;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.Link;

import fr.afpa.gestion.inscription.controller.AController;
import fr.afpa.gestion.inscription.dto.Dto;
import fr.afpa.gestion.inscription.exception.ResourceNotFoundException;

public abstract class DtoLinkCreator<TDto extends Dto, TController extends AController<TDto>>
		implements LinkCreator<TDto> {

	private Class<TController> classTControlleur;

	public final void setController(final Class<TController> classTController) {
		this.classTControlleur = classTController;
	}

	@Override
	public Link getLinks() {
		return linkTo(methodOn(this.classTControlleur).findAll()).withRel(getStringLink());
	}

	@Override
	public Link getSelfLink(TDto dto) throws ResourceNotFoundException {

		return linkTo(methodOn(this.classTControlleur).findById((dto).getId())).withSelfRel();
	}

	public abstract String getStringLink();

}
