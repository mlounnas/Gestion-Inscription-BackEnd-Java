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

import fr.afpa.gestion.inscription.dto.SessionDto;
import fr.afpa.gestion.inscription.exception.ResourceNotFoundException;
import fr.afpa.gestion.inscription.service.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@CrossOrigin(origins = "*.*")
@RestController
@RequestMapping("/gestionSession")
public class SessionController extends AController<SessionDto> {

	private SessionService sessionService;

	@Autowired
	public SessionController(SessionService sessionService) {
		super();
		this.sessionService = sessionService;
	}

	@GetMapping("/sessions")
	@ApiOperation(value = "Finds all sessions",
    response = SessionDto.class,
    responseContainer = "List")
	@Override
	public ResponseEntity<List<SessionDto>> findAll() {
		List<SessionDto> list = sessionService.findAll();
		return new ResponseEntity<List<SessionDto>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/pagedsessions")
	@ApiOperation(value = "Finds all sessions with pagination",
    response = SessionDto.class,
    responseContainer = "Page")
	@Override
	public ResponseEntity<Page<SessionDto>> findAllPagination(
			@RequestParam(name = "page", defaultValue = "0") Integer pageNo,
			@RequestParam(name = "size", defaultValue = "10") Integer pageSize,
			@RequestParam(name = "sort", defaultValue = "nom") String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<SessionDto> page = sessionService.getAll(paging);
		return new ResponseEntity<Page<SessionDto>>(page, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/session/{id}")
	@ApiOperation(value = "Finds a session with its id",
    response = SessionDto.class,
    responseContainer = "SessionDto")
	@Override
	public ResponseEntity<SessionDto> findById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		return ResponseEntity.ok().body(sessionService.findByID(id));
	}

	@PostMapping("/session")
	@ApiOperation(value = "Create a new session",
    response = SessionDto.class,
    responseContainer = "SessionDto")
	@Override
	public ResponseEntity<SessionDto> create(@Valid @RequestBody SessionDto elementParam) {
		return ResponseEntity.created(null).body(sessionService.create(elementParam));
	}

	@DeleteMapping("session/{id}")
	@ApiOperation(value = "Delete a session with its id")
	@Override
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		sessionService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("session/{id}")
	@ApiOperation(value = "Updates a session with its id",
    response = SessionDto.class,
    responseContainer = "SessionDto")
	@Override
	public ResponseEntity<SessionDto> update(@PathVariable(value = "id") Integer id, @Valid @RequestBody SessionDto elementParam) {
		return ResponseEntity.ok().body(sessionService.update(id, elementParam));
	}

}
