package fr.afpa.gestion.inscription.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afpa.gestion.inscription.dto.SessionDto;
import fr.afpa.gestion.inscription.exception.BadRequestException;
import fr.afpa.gestion.inscription.exception.ResourceNotFoundException;
import fr.afpa.gestion.inscription.model.Centre;
import fr.afpa.gestion.inscription.model.Formation;
import fr.afpa.gestion.inscription.model.Session;
import fr.afpa.gestion.inscription.repository.CentreRepository;
import fr.afpa.gestion.inscription.repository.FormationRepository;
import fr.afpa.gestion.inscription.repository.SessionRepository;
import fr.afpa.gestion.inscription.service.SessionService;
import fr.afpa.gestion.inscription.service.util.Mapper;
import fr.afpa.gestion.inscription.service.util.MapperWithLink;
import fr.afpa.gestion.inscription.service.util.SessionLinkCreator;

// TODO: Auto-generated Javadoc
/**
 * The Class SessionServiceImpl.
 */
@Transactional(readOnly = true)
@Service
public class SessionServiceImpl extends AGeneriqueService<Session, SessionDto, JpaRepository<Session, Integer>>
		implements SessionService {

	/** The session repository. */
	private SessionRepository sessionRepository;

	/** The centre repository. */
	private CentreRepository centreRepository;

	/** The formation repository. */
	private FormationRepository formationRepository;

	/** The link creator. */
	SessionLinkCreator lCr;

	/**
	 * Instantiates a new session service impl.
	 *
	 * @param sessionRepository the session repository
	 * @param centreRepository the centre repository
	 * @param formationRepository the formation repository
	 * @param lCr the l cr
	 */
	@Autowired
	public SessionServiceImpl(SessionRepository sessionRepository, CentreRepository centreRepository,
			FormationRepository formationRepository, SessionLinkCreator lCr) {
		super();
		this.sessionRepository = sessionRepository;
		this.centreRepository = centreRepository;
		this.formationRepository = formationRepository;
		this.lCr = lCr;
		setClassDto(SessionDto.class);
		setClassT(Session.class);
		setlCr(lCr);
		setTdao(sessionRepository);
	}

	/**
	 * Creates session with centre & formation
	 *
	 * @param SessionDto
	 * @return the session dto
	 */
	@Override
	@Transactional
	public SessionDto create(SessionDto t) {

		String nomsession = t.getNom();
		Integer centre = t.getIdcentre();
		String nomsessionaveccentre = nomsession + centre;

		Optional<Session> optSession = sessionRepository.findByNomsessionaveccentre(nomsessionaveccentre);

		if (optSession.isPresent()) {
			throw new BadRequestException("session with " + nomsessionaveccentre + " already exists");
		}

		Optional<Formation> optFormation = formationRepository.findById(t.getIdformation());

		if (!optFormation.isPresent()) {
			throw new ResourceNotFoundException("Formation with " + t.getIdformation() + " doesn't exists");
		}

		Optional<Centre> optCentre = centreRepository.findById(t.getIdcentre());

		if (!optCentre.isPresent()) {
			throw new ResourceNotFoundException("Centre with " + t.getIdcentre() + " doesn't exists");
		}

		Session session = Mapper.map(t, Session.class);
		session.setNomsessionaveccentre(nomsessionaveccentre);
		session.setCentre(optCentre.get());
		session.setFormation(optFormation.get());
		session = sessionRepository.save(session);

		t = MapperWithLink.map(session, SessionDto.class, lCr);
		t.setNomsessionaveccentre(nomsessionaveccentre);
		t.setIdcentre(session.getCentre().getIdcentre());
		t.setIdformation(session.getFormation().getIdformation());

		return t;
	}

	/**
	 * Update session
	 *
	 * @param id
	 * @param SessionDto
	 * @return the session dto
	 */
	@Override
	@Transactional
	public SessionDto update(Integer id, SessionDto t) {

		t.setIdsession(id);

		String nom = t.getNom();

		if (nom == null || nom.isEmpty()) {
			throw new BadRequestException("Session name is needed");
		}

		Optional<Session> optSession = sessionRepository.findById(t.getIdsession());

		if (!optSession.isPresent()) {
			throw new ResourceNotFoundException("Session with " + t.getIdsession() + " not found");
		}

		Session session = sessionRepository.save(Mapper.map(t, Session.class));
		return MapperWithLink.map(session, SessionDto.class, lCr);

	}

	/**
	 * Find session by ID.
	 *
	 * @param id
	 * @return the session dto
	 */
	@Override
	public SessionDto findByID(Integer id) {

		Optional<Session> optSession = sessionRepository.findById(id);

		if (!optSession.isPresent()) {
			throw new ResourceNotFoundException("Session with " + id + " not found");
		} else {
			Session session = optSession.get();
			SessionDto t = MapperWithLink.map(session, SessionDto.class, lCr);
			t.setIdcentre(session.getCentre().getIdcentre());
			t.setIdformation(session.getFormation().getIdformation());

			return t;
		}

	}

	/**
	 * Find all sessions
	 *
	 * @return list of sessions
	 */
	@Override
	public List<SessionDto> findAll() {
		
		List<Session> list = sessionRepository.findAll();
		
		if (list.isEmpty()) {
			throw new ResourceNotFoundException("list is empty");
		}
		
		List<SessionDto> listT = MapperWithLink.map(list, SessionDto.class, lCr);
		
		for (SessionDto sessionDto : listT) {
			for (Session session : list) {
				sessionDto.setIdcentre(session.getCentre().getIdcentre());
				sessionDto.setIdformation(session.getFormation().getIdformation());
			}
		}
		return listT;
	}
	

	/**
	 * Find all sessions paginated
	 *
	 * @param Pageable (pages, size and sort)
	 * @return the sessions with pagination
	 */
	@Override
	public Page<SessionDto> getAll(Pageable paging) {
		
		Page<Session> page = sessionRepository.findAll(paging);
		
		if (page.hasContent()) {
			List<SessionDto> list = MapperWithLink.map(page.getContent(), SessionDto.class, lCr);
			
			for (SessionDto sessionDto : list) {
				for (Session session : page) {
					sessionDto.setIdcentre(session.getCentre().getIdcentre());
					sessionDto.setIdformation(session.getFormation().getIdformation());
				}
			}
			
			Page<SessionDto> pageDto = new PageImpl<>(list, paging, page.getTotalElements());
			
			return pageDto;
			
		} else {
			throw new ResourceNotFoundException("list is empty");
		}
	}

}
