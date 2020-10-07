package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Planner;

public class PlannerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserMealPlanning");

	public void insertPlanner(Planner s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Planner> showAllPlanners() {
		EntityManager em = emfactory.createEntityManager();
		List<Planner> allPlanners = em.createQuery("SELECT p FROM Planner p").getResultList();
		return allPlanners;
	}

	public Planner findPlanner(String nameToLookUp) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Planner> typedQuery = em.createQuery("select ph from Planner ph where ph.plannerName = :selectedName",Planner.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Planner foundPlanner;
		try	{
			foundPlanner = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundPlanner = new Planner(nameToLookUp);
		}
		em.close();
		
		return foundPlanner;			
	}

}
