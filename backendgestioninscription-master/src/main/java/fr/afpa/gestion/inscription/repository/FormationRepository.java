package fr.afpa.gestion.inscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.gestion.inscription.model.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Integer> {

}
