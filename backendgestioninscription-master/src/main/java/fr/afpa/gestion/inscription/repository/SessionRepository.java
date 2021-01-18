package fr.afpa.gestion.inscription.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.gestion.inscription.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
	
	public Optional<Session> findByNomsessionaveccentre(String nomsessionaveccentre);

}
