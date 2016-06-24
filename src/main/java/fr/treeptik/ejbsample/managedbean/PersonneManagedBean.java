package fr.treeptik.ejbsample.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

import fr.treeptik.ejbsample.pojo.Personne;
import fr.treeptik.ejbsample.service.PersonneService;

@ManagedBean
@RequestScoped
public class PersonneManagedBean {
	
	@EJB
	public PersonneService personneService;
	
	private Personne personne = new Personne();
	
	private ListDataModel<Personne> personnes = new ListDataModel<>();
	


	
	public String update(){
		personne = personnes.getRowData();
		return "personne";
	}
	
	public String remove(){
		personne = personnes.getRowData();
		personneService.remove(personne);
		return "personne-list";
	}
	
	
	
	
	public ListDataModel<Personne> getPersonnes() {
		personnes.setWrappedData(personneService.list());
		return personnes;
	}

	
	

	public String create(){
		personneService.save(personne);
		return "personne-list";
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	

}
