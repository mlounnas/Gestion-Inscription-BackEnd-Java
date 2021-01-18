package fr.afpa.gestion.inscription.service.util;

import org.springframework.stereotype.Component;

import fr.afpa.gestion.inscription.controller.SessionController;
import fr.afpa.gestion.inscription.dto.SessionDto;

@Component
public class SessionLinkCreator extends DtoLinkCreator<SessionDto, SessionController> {

	@Override
	public String getStringLink() {
		return "sessions";
	}

	public SessionLinkCreator() {
		setController(SessionController.class);
	}

}
