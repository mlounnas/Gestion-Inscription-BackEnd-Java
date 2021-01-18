package fr.afpa.gestion.inscription.controller;

import java.util.List;

import javax.validation.Valid;

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

import fr.afpa.gestion.inscription.dto.RoleDto;
import fr.afpa.gestion.inscription.service.RoleService;

@CrossOrigin(origins = "*.*")
@RestController
@RequestMapping("/gestionRole")
public class RoleController extends AController<RoleDto> {
	
	private RoleService roleservice;

	public RoleController(RoleService roleservice) {
		super();
		this.roleservice = roleservice;
	}
	
	@GetMapping("/rolespage")
	public ResponseEntity<Page<RoleDto>> findAllPagination(
			@RequestParam(name = "page", defaultValue = "0") Integer pageNo,
			@RequestParam(name = "size", defaultValue = "2") Integer pageSize,
			@RequestParam(name = "sort", defaultValue = "code") String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<RoleDto> list = roleservice.getAll(paging);
		return new ResponseEntity<Page<RoleDto>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/roles")
	public ResponseEntity<List<RoleDto>> findAll() {
		List<RoleDto> list = roleservice.findAll();
		return new ResponseEntity<List<RoleDto>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@GetMapping("/role/{id}")
	public ResponseEntity<RoleDto> findById(@PathVariable(value = "id") Integer id) {
		return ResponseEntity.ok().body(roleservice.findByID(id));
	}
	
	@GetMapping("/roleCode/{code}")
	public ResponseEntity<RoleDto> findByCode(@PathVariable(value = "code") String code) {
		return ResponseEntity.ok().body(roleservice.findByCode(code));
	}

	@PostMapping("/role")
	public ResponseEntity<RoleDto> create(@Valid @RequestBody RoleDto roleDto) {
		return ResponseEntity.ok().body(roleservice.create(roleDto));
	}
	
	@DeleteMapping("/role/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id") Integer id) {
		roleservice.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/role/{id}")
	public ResponseEntity<RoleDto> update(@PathVariable(value = "id") Integer id, @Valid @RequestBody RoleDto roleDto) {
		return ResponseEntity.ok().body(roleservice.update(id, roleDto));
	}
	
	
	
	
	

}
