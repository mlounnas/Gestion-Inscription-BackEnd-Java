package fr.afpa.gestion.inscription.service.util;

import org.springframework.stereotype.Component;

import fr.afpa.gestion.inscription.controller.CentreController;
import fr.afpa.gestion.inscription.dto.CentreDTO;


// TODO: Auto-generated Javadoc
/**
 * The Class CentreLinkCreator.
 */
@Component
public class CentreLinkCreator extends DtoLinkCreator<CentreDTO,CentreController >{

	/**
	 * Instantiates a new centre link creator.
	 */
	public CentreLinkCreator() {

				setController(CentreController.class);
		
		}
	
	
	/**
	 * Gets the string link.
	 *
	 * @return the string link
	 */
	@Override
	public String getStringLink() {
		// TODO Auto-generated method stub
		return "centres";
	}

}
