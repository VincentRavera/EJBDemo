package fr.treeptik.ejbsample.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.treeptik.ejbsample.pojo.Personne;

@Stateless
public class PersonneDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Personne save(Personne personne){
		if (personne.getId()==null) {
			em.persist(personne);
		}
		else {
			em.merge(personne);
		}
		return personne;
	}
	
	public List<Personne> list() {
		return em
				.createQuery("select p from Personne p", Personne.class)
				.getResultList();
	}
	public void remove(Personne personne) {
		em.remove(personne);
	}
	
	public Personne findById(Integer id){
		return em.find(Personne.class, id);
	}
	
	
	
	
}
