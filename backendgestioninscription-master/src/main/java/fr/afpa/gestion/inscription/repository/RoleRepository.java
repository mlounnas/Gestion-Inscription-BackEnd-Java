package fr.afpa.gestion.inscription.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.gestion.inscription.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Optional <Role> findByCode (String code);

}
