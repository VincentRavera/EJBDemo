package fr.treeptik.ejbsample.resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import fr.treeptik.ejbsample.pojo.Personne;
import fr.treeptik.ejbsample.service.PersonneService;

@Path("personnes")
@Produces(value = "application/json")
@Consumes(value = "application/json")
@ApplicationPath("rest")
@Stateless
public class PersonneRessource extends Application {

	@EJB
	private PersonneService personneService;

	@POST
	public Personne savePersonne(Personne personne) {
		return personneService.save(personne);
	}

	@GET
	public List<Personne> findAll() {
		return personneService.list();
	}

	@GET
	@Path("{id}")
	public Personne findById(@PathParam("id") Integer id) {
		return personneService.findById(id);
	}

	@DELETE
	public void delPersonne(Personne personne) {
		personneService.remove(personne);
	}

	@PUT
	public Personne updatePersonne(Personne personne) {
		return personneService.save(personne);
	}

}
