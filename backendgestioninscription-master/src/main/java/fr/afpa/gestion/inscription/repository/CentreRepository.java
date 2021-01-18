package fr.afpa.gestion.inscription.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.gestion.inscription.model.Centre;

// TODO: Auto-generated Javadoc
/**
 * The Interface CentreRepository.
 */
@Repository
public interface CentreRepository extends JpaRepository<Centre, Integer> {
 
	/**
	 * Find by nom.
	 *
	 * @param nom the nom
	 * @return the optional
	 */
	Optional<Centre> findByNom(String nom);
}
