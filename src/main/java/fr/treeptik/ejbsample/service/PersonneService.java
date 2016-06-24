package fr.treeptik.ejbsample.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import fr.treeptik.ejbsample.dao.PersonneDAO;
import fr.treeptik.ejbsample.pojo.Personne;

@Stateless
public class PersonneService {
	
	@EJB//@Inject
	private PersonneDAO personneDAO;
	
	@Transactional
	public Personne save(Personne personne){
		return personneDAO.save(personne);
	}
	
	@Transactional
	public void remove(Personne personne){
		personne = personneDAO.findById(personne.getId());
		personneDAO.remove(personne);
	}
	
	public List<Personne> list(){
		return personneDAO.list();
	}
	public Personne findById(Integer id) {
		return personneDAO.findById(id);
	}
	
	
	
	

}
