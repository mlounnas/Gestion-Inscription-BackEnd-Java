package fr.afpa.gestion.inscription.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.afpa.gestion.inscription.dto.CentreDTO;
import fr.afpa.gestion.inscription.exception.BadRequestException;
import fr.afpa.gestion.inscription.exception.ResourceNotFoundException;
import fr.afpa.gestion.inscription.model.Centre;
import fr.afpa.gestion.inscription.repository.CentreRepository;
import fr.afpa.gestion.inscription.service.ServiceCentre;
import fr.afpa.gestion.inscription.service.util.CentreLinkCreator;
import fr.afpa.gestion.inscription.service.util.Mapper;
import fr.afpa.gestion.inscription.service.util.MapperWithLink;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceCentreImpl.
 */
@Component
@Transactional
public class ServiceCentreImpl extends AGeneriqueService<Centre, CentreDTO, CentreRepository> implements ServiceCentre {

	/** The centre rep. */
	private CentreRepository centreRep;

	/** The lcr. */
	private CentreLinkCreator lCr;



	/**
	 * Instantiates a new service centre impl.
	 *
	 * @param centreRep the centre rep
	 * @param lCr the lcr
	 * injection du LinkCreator, du repository centre et des classes generique dans la couche service
	 */
	@Autowired
	public ServiceCentreImpl(CentreRepository centreRep, CentreLinkCreator lCr) {// UtilisateurLinkCreator
		super();
		this.centreRep = centreRep;
		this.lCr = lCr;
		setClassDto(CentreDTO.class);
		setClassT(Centre.class);
		setlCr(lCr);
		setTdao(centreRep);
	}

	/**
	 * Creation de centre
	 *
	 * @param t the t
	 * @return the centre DTO
	 */
	@Override
	@Transactional
	public CentreDTO create(CentreDTO t) {

		/*sécurité champs nom est vide */
		if (t.getNom().isEmpty()) {		
			throw new BadRequestException("le nom ne peut pas être nul");
			
		}
		Optional<Centre> optcentre = centreRep.findByNom(t.getNom());
		System.out.println(optcentre);
		/*sécurité le nom est bien unique*/
		if (optcentre.isPresent()) {
			throw new BadRequestException("le nom de ce centre : " + optcentre.get().getNom()
					+ " existe déja dans la BDD ou est nul, create impossible");

		} else {
			System.out.println("le nom existe pas");
			/*mapper de centreDto a centre permet d'utiliser la fonction de jparepository*/
			Centre centre = centreRep.save(Mapper.map(t, Centre.class));
			/*mapper avec lien de centre a centreDTO*/
			CentreDTO centredto = MapperWithLink.map(centre, CentreDTO.class, lCr);
	
			return centredto;

		}
	}

	/**
	 * Update un centre
	 *
	 * @param id the id
	 * @param t the t
	 * @return the centre DTO
	 */
	@Transactional
	@Override
	public CentreDTO update(Integer id, CentreDTO t) {
		/*set de l'id sur l objet t*/
		t.setIdcentre(id);
		/*sécurité l'id renseigné existe bien*/
		Optional<Centre> optcentre = centreRep.findById(t.getId());
		if (!optcentre.isPresent()) {
			throw new ResourceNotFoundException("l'id " + id + " est introuvable");
		} else {
			/*sécurité en cas d'update le champs nom n' est pas vide*/
			if (t.getNom().isEmpty()) {
				throw new BadRequestException("le nom ne peut pas être nul");
			}
			/*sécurite en cas d'update le champs nom est unique pour tous les id differents de l'objet que l'on veut updater*/
			Optional<Centre> optcentre1 = centreRep.findByNom(t.getNom());
			if (optcentre1.isPresent() && id!=optcentre1.get().getIdcentre()) {

				throw new BadRequestException("le nom de ce centre : " + optcentre1.get().getNom()
						+ " existe déja dans la BDD ou est nul, create impossible");

			}
			/*Mapper de centreDTO a centre*/
			Centre centre = Mapper.map(t, Centre.class);
			centre = centreRep.save(centre);
			/*Mapper avec liens hateoas de centre a centreDTO*/
			return (MapperWithLink.map(centre, CentreDTO.class, lCr));

		}

	}

}
