package fr.afpa.gestion.inscription.service;

import fr.afpa.gestion.inscription.dto.RoleDto;

public interface RoleService extends IGeneriqueService<RoleDto> {
	
	public RoleDto create (RoleDto roleDTO);
	public RoleDto update (Integer id, RoleDto roleDTO);
	public RoleDto findByCode (String code);

}
