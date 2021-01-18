package fr.afpa.gestion.inscription.service.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import fr.afpa.gestion.inscription.controller.RoleController;
import fr.afpa.gestion.inscription.dto.RoleDto;



@Component
public class RoleLinkCreator extends DtoLinkCreator<RoleDto, RoleController> {

	
	
	@Override
	public String getStringLink() {
		
		return "roles";
	}

	public RoleLinkCreator() {

		setController(RoleController.class);

	}

}
