package fr.afpa.gestion.inscription.service.impl;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fr.afpa.gestion.inscription.BackEndGestionInscriptionApplication;
import fr.afpa.gestion.inscription.dto.SessionDto;
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

@SpringBootTest
class SessionServiceImplTest {

	@MockBean
	private SessionRepository sessionRepository;

	@MockBean
	private CentreRepository centreRepository;

	@MockBean
	private FormationRepository formationRepository;
	
	@MockBean
	private Session session;

	@Autowired
	private SessionLinkCreator lCr;

	@MockBean
	List<SessionDto> list;
	
	@MockBean
	private Formation formation;
	
	@MockBean
	private Centre centre;

	@Autowired
	private SessionService sessionService = new SessionServiceImpl(sessionRepository, centreRepository,
			formationRepository, lCr);

	@Test
	void testCreate() {
		
		formation.setIdformation(1);
		centre.setIdcentre(1);
		
		session.setCentre(centre);
		session.setFormation(formation);
		
		SessionDto sessionDto = new SessionDto(1, "session1", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 12, 31),
				LocalDate.of(2020, 10, 01), LocalDate.of(2020, 12, 15), LocalDate.of(2020, 12, 20), "session11",
				1, 1);

//		Session firstSession = new Session(1, "session1", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 12, 31),
//				LocalDate.of(2020, 10, 01), LocalDate.of(2020, 12, 15), LocalDate.of(2020, 12, 20), "session11",
//				formation, centre);
		
		when(sessionRepository.save(Mapper.map(sessionDto, Session.class))).thenReturn(session);
		
		SessionDto retrievedSession = sessionService.create(sessionDto);
		
		assertThat(retrievedSession).isEqualTo(sessionDto);
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByIDInteger() {

		Integer id = 1;
		Session firstSession = new Session(1, "session1", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 12, 31),
				LocalDate.of(2020, 10, 01), LocalDate.of(2020, 12, 15), LocalDate.of(2020, 12, 20), "session11",
				formation, centre);
		
		when(sessionRepository.findById(id)).thenReturn(Optional.of(firstSession));
		
		SessionDto retrievedSession = sessionService.findByID(id);
		
		assertThat(retrievedSession).isEqualTo(MapperWithLink.map(firstSession, SessionDto.class, lCr));
		
	}

	@Test
	void testFindAll() {
		
		List<Session> sessions = new ArrayList<Session>();

		Session firstSession = new Session(1, "session1", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 12, 31),
				LocalDate.of(2020, 10, 01), LocalDate.of(2020, 12, 15), LocalDate.of(2020, 12, 20), "session11",
				formation, centre);
		Session secondSession = new Session(2, "session2", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 12, 31),
				LocalDate.of(2020, 10, 01), LocalDate.of(2020, 12, 15), LocalDate.of(2020, 12, 20), "session21",
				formation, centre);
		
		sessions.add(firstSession);
		sessions.add(secondSession);

		when(sessionRepository.findAll()).thenReturn(sessions);

		List<SessionDto> retrievedSessions = sessionService.findAll();

		assertThat(retrievedSessions).isEqualTo(MapperWithLink.map(sessions, SessionDto.class, lCr));
		
	}

}
