package dta.sgp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dta.sgp.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

	Optional<List<Collaborateur>> findByDepartementId(Integer id);

	Optional<Collaborateur> findByMatricule(String matricule);
}
