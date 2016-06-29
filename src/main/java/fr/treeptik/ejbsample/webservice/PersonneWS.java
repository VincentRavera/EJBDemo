package fr.treeptik.ejbsample.webservice;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.treeptik.ejbsample.pojo.Personne;
import fr.treeptik.ejbsample.service.PersonneService;

@WebService
public class PersonneWS {
	
	@EJB
	private PersonneService personneService;
	
	@WebMethod
	public void saveFromWebService(Personne personne) {
		personneService.save(personne);
	}

}
