package fr.afpa.gestion.inscription.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afpa.gestion.inscription.dto.RoleDto;
import fr.afpa.gestion.inscription.exception.BadRequestException;
import fr.afpa.gestion.inscription.exception.ResourceNotFoundException;
import fr.afpa.gestion.inscription.model.Role;
import fr.afpa.gestion.inscription.repository.RoleRepository;
import fr.afpa.gestion.inscription.service.RoleService;
import fr.afpa.gestion.inscription.service.util.LinkCreator;
import fr.afpa.gestion.inscription.service.util.Mapper;
import fr.afpa.gestion.inscription.service.util.MapperWithLink;

@Transactional(readOnly = true)
@Service
public class RoleServiceImpl extends AGeneriqueService<Role, RoleDto, RoleRepository> implements RoleService {
	
	RoleRepository roleRepo;
	LinkCreator<RoleDto> lCr;
	
	
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepo, LinkCreator<RoleDto> lCr) {
		super();
		this.roleRepo = roleRepo;
		this.lCr = lCr;
		setClassDto(RoleDto.class);
		setClassT(Role.class);
		setlCr(lCr);
		setTdao(roleRepo);
	}

	@Transactional
	@Override
	public RoleDto create(RoleDto roleDTO) {
		String codeRole = roleDTO.getCode();

		if (codeRole == null || codeRole.isEmpty()) {
			throw new BadRequestException("le nom de code est obligatoire ");
		}

		Optional<Role> ro = roleRepo.findByCode(roleDTO.getCode());

		if (ro.isPresent()) {
			throw new BadRequestException("le code " + roleDTO.getCode() + " existe déja");
		} else {
			Role role = roleRepo.save(Mapper.map(roleDTO, Role.class));
			return MapperWithLink.map(role, RoleDto.class, lCr);
		}
	}

	@Transactional
	@Override
	public RoleDto update(Integer id, RoleDto roleDTO) {
		roleDTO.setIdrole(id);

		String codeRole = roleDTO.getCode();

		if (codeRole == null || codeRole.isEmpty()) {
			throw new BadRequestException("le code est obligatoire ");
		}
		Optional<Role> ro = roleRepo.findById(roleDTO.getIdrole());

		if (!ro.isPresent()) {
			throw new ResourceNotFoundException(
					"le code dont l'id est " + roleDTO.getIdrole() + " n'a pas été trouvé");
		}

		else{
			Role role = roleRepo.save(Mapper.map(roleDTO, Role.class));
			return MapperWithLink.map(role, RoleDto.class, lCr);
		}

	}

	@Override
	public RoleDto findByCode(String code) {
		Optional<Role> ro = roleRepo.findByCode(code);

		if (!ro.isPresent()) {
			throw new ResourceNotFoundException("le code " + code + " n'existe pas");
		} else {
			Role role = ro.get();

			return MapperWithLink.map(role, RoleDto.class, lCr);
		}
	}

}
