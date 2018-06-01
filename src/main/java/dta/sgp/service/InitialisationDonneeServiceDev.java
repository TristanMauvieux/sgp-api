package dta.sgp.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dta.sgp.entite.Banque;
import dta.sgp.entite.Collaborateur;
import dta.sgp.entite.Departement;

@Service
public class InitialisationDonneeServiceDev implements InitialisationDonneeService {

	private EntityManager em;

	@Autowired
	public InitialisationDonneeServiceDev(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	@Transactional
	public void initialiser() {
		Departement dep = new Departement();
		dep.setLibelle("INFO");
		Departement dep2 = new Departement();
		dep2.setLibelle("DIRECTION");

		em.persist(dep);
		em.persist(dep2);

		Banque ban1 = new Banque();
		ban1.setNomDeBanque("CreditPatate");
		ban1.setBic("2158sfzf");
		ban1.setIban("FR154982949");

		Banque ban2 = new Banque();
		ban2.setNomDeBanque("CreditFraise");
		ban2.setIban("BE25194956");
		ban2.setBic("eede8468");

		Collaborateur col = new Collaborateur();
		col.setActif(true);
		col.setAdresse("24 rue des chenils");
		col.setDateDeNaissance(LocalDate.of(1995, 12, 5));
		col.setDateHeurereation(ZonedDateTime.now());
		col.setMatricule("M3212");
		col.setNom("Zark");
		col.setNumeroDeSecuriteSociale("19512057894562120");
		col.setPrenom("Holt");
		col.setEmailPro("holtZark@entreprise.org");
		col.setDepartement(dep2);
		col.setBanque(ban1);

		Collaborateur col1 = new Collaborateur();
		col1.setActif(false);
		col1.setAdresse("19 allée des chances");
		col1.setDateDeNaissance(LocalDate.of(1986, 11, 15));
		col1.setDateHeurereation(ZonedDateTime.now());
		col1.setMatricule("R011TH3D1C3");
		col1.setNom("La chance");
		col1.setNumeroDeSecuriteSociale("1598846547692");
		col1.setPrenom("Lucien");
		col1.setEmailPro("lucienLaChance@entreprise.org");
		col1.setDepartement(dep);
		col1.setBanque(ban2);

		em.persist(col);
		em.persist(col1);
	}

}
