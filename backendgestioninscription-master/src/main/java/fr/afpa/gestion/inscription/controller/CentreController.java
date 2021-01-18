package fr.afpa.gestion.inscription.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.gestion.inscription.dto.CentreDTO;
import fr.afpa.gestion.inscription.exception.ResourceNotFoundException;
import fr.afpa.gestion.inscription.service.ServiceCentre;

// TODO: Auto-generated Javadoc
/**
 * The Class CentreController.
 */
@CrossOrigin(origins = "*.*")
@RestController
@RequestMapping("/gestionCentre")
public class CentreController extends AController<CentreDTO> implements IController<CentreDTO> {
	
	
	/** The service centre. */
	private ServiceCentre serviceCentre;
	
	

	/**
	 * injection du service dans le controller
	 * Instantiates a new centre controller.
	 *
	 * @param serviceCentre the service centre
	 */
	@Autowired
	public CentreController(ServiceCentre serviceCentre) {
		super();
		this.serviceCentre = serviceCentre;
	}

	/**
	 * Find all. affiche liste des centres
	 *
	 * @return the response entity
	 */
	@Override
	@GetMapping("/centres")
	public ResponseEntity<List<CentreDTO>> findAll() {
		return ResponseEntity.ok().body(serviceCentre.findAll());
	}

	/**
	 * Find all pagination. affiche liste des centres avec pagination
	 *
	 * @param page the page
	 * @param size the size
	 * @param sort the sort
	 * @return the response entity
	 */
	@Override
	@GetMapping("/centresPage")
	public ResponseEntity<Page<CentreDTO>> findAllPagination(@RequestParam(name = "page", defaultValue = "0") Integer page,@RequestParam(name = "size", defaultValue = "10") Integer size,@RequestParam(name = "sort", defaultValue = "email") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<CentreDTO> list = serviceCentre.getAll(paging);
		return new ResponseEntity<Page<CentreDTO>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	

	/**
	 * Find by id. affiche le centre avec son id
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	@GetMapping("/centre/{id}")
	public ResponseEntity<CentreDTO> findById(@PathVariable(value = "id")Integer id) throws ResourceNotFoundException {
		
		return ResponseEntity.ok().body(serviceCentre.findByID(id));
	}

	/**
	 * Creates the. creation d'un centre
	 *
	 * @param centredto the centredto
	 * @return the response entity
	 */
	@Override
	@PostMapping("/centre")
	public ResponseEntity<CentreDTO> create(@Valid @RequestBody CentreDTO centredto) {
		System.out.println(centredto+" est le centredto json");
		return ResponseEntity.ok().body(serviceCentre.create(centredto));
	}

	/**
	 * Delete. effacement d'un centre avec l'id
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@Override
	@DeleteMapping("/centre/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id")Integer id) throws ResourceNotFoundException {
		serviceCentre.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	/**
	 * Update un centre avec son id
	 *
	 * @param id the id
	 * @param centredto the centredto
	 * @return the response entity
	 */
	@Override
	@PutMapping("/centre/{id}")
	public ResponseEntity<CentreDTO> update(@PathVariable(value = "id") Integer id,
			@Valid @RequestBody CentreDTO centredto) {
		
		return ResponseEntity.ok().body(serviceCentre.update(id, centredto));
	}
	
	
	

}
