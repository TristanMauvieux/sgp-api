package dta.sgp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dta.sgp.entite.Banque;
import dta.sgp.entite.Collaborateur;
import dta.sgp.repository.CollaborateurRepository;
import dta.sgp.repository.DepartementRepository;
import dta.sgp.service.InitialisationDonneeService;

@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	private DepartementRepository depRepo;
	private CollaborateurRepository colRepo;
	private InitialisationDonneeService init;

	@Autowired
	public CollaborateurController(DepartementRepository depRepo, CollaborateurRepository colRepo,
			InitialisationDonneeService init) {
		super();
		this.depRepo = depRepo;
		this.colRepo = colRepo;
		this.init = init;
		init.initialiser();
	}

	@GetMapping
	public List<Collaborateur> allCollaborateur() {
		return colRepo.findAll();

	}

	@GetMapping(params = { "departementId" })
	public List<Collaborateur> colByDep(@RequestParam("departementId") int id) {

		return colRepo.findByDepartementId(id).get();
	}

	@GetMapping(path = "/{matricule}")
	public Collaborateur oneCollaborateur(@PathVariable String matricule) {
		return colRepo.findByMatricule(matricule).get();
	}

	@PutMapping(path = "/{matricule}")
	public ResponseEntity<String> modifierMatricule(@PathVariable String matricule, @RequestBody Collaborateur collab) {
		Optional<Collaborateur> col = colRepo.findByMatricule(matricule);
		ResponseEntity<String> rep;
		if (col.isPresent()) {
			rep = new ResponseEntity<>(HttpStatus.OK);
			collab.setMatricule(matricule);
			collab.setId(col.get().getId());
			colRepo.save(collab);
		} else {
			rep = new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}

		return rep;
	}

	@GetMapping(path = "/{matricule}/banque")
	public Banque oneBanque(@PathVariable String matricule) {
		Optional<Collaborateur> col = colRepo.findByMatricule(matricule);
		return col.get().getBanque();
	}

	@PutMapping(path = "/{matricule}/banque")
	public ResponseEntity<String> modifierBanque(@PathVariable String matricule, @RequestBody Collaborateur collab) {
		Optional<Collaborateur> col = colRepo.findByMatricule(matricule);
		ResponseEntity<String> rep;
		if (col.isPresent()) {
			rep = new ResponseEntity<>(HttpStatus.OK);
			Banque nouvelle = col.get().getBanque();
			collab.setId(col.get().getId());
			collab.setMatricule(col.get().getMatricule());
			collab.setBanque(nouvelle);
			colRepo.save(collab);
		} else {
			rep = new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}

		return rep;
	}

}
