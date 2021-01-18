package fr.afpa.gestion.inscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.gestion.inscription.model.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {

}
