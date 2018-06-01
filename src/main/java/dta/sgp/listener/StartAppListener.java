package dta.sgp.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import dta.sgp.service.InitialisationDonneeService;

public class StartAppListener {
	@Autowired
	private InitialisationDonneeService initService;

	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// capture du démarrage de l'application
		// à un moment où le contexte Spring est complètement créé
		initService.initialiser();
	}

}
