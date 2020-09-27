package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListMeal;

public class ListMealHelper {

	static EntityManagerFactory emfactory =	
			Persistence.createEntityManagerFactory("WebMealPlanning");
	
	public void	insertMeal(ListMeal	lm){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lm);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListMeal> showAllMeals(){
		EntityManager em = emfactory.createEntityManager();
		List<ListMeal> allItems	= em.createQuery("SELECT i FROM ListMeal i").getResultList();
		return allItems;
		}
	
	public void deleteMeal(ListMeal toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListMeal> typedQuery	= em.createQuery("select lm from "
				+ "ListMeal lm where lm.main = :selectedMain and lm.vegetable = :selectedVegetable and lm.fruit = :selectedFruit", ListMeal.class);
		
		//Substitute parameter with	actual data from the toDelete item
		typedQuery.setParameter("selectedMain", toDelete.getMain());
		typedQuery.setParameter("selectedVegetable", toDelete.getVegetable());
		typedQuery.setParameter("selectedFruit", toDelete.getFruit());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a	new	list item
		ListMeal result	= typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public ListMeal	searchForMealById(int idToEdit)	{
	//	TODO Auto-generated	method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListMeal found = em.find(ListMeal.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateMeal(ListMeal toEdit)	{
		//	TODO Auto-generated	method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListMeal> searchForMealByMain(String mainDesc){
		// TODO	Auto-generated	method	stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListMeal> typedQuery	= em.createQuery("select lm	from "
				+ "ListMeal lm where lm.main = :selectedMain", ListMeal.class);
		typedQuery.setParameter("selectedMain", mainDesc);
		List<ListMeal> foundMeals =	typedQuery.getResultList();
		em.close();
		return foundMeals;
	}
	
	public List<ListMeal> searchForMealByVegetable(String vegDesc)	{
		//	TODO	Auto-generated	method	stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListMeal> typedQuery	= em.createQuery("select lm	from "
				+ "ListMeal lm where lm.vegetable = :selectedVegetable", ListMeal.class);
		typedQuery.setParameter("selectedVegetable", vegDesc);
		List<ListMeal> foundMeals =	typedQuery.getResultList();
		em.close();
		return foundMeals;
	}
	
	public List<ListMeal> searchForMealByFruit(String fruitDesc)	{
		//	TODO	Auto-generated	method	stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListMeal> typedQuery	= em.createQuery("select lm	from "
				+ "ListMeal lm where lm.fruit = :selectedFruit", ListMeal.class);
		typedQuery.setParameter("selectedFruit", fruitDesc);
		List<ListMeal> foundMeals =	typedQuery.getResultList();
		em.close();
		return foundMeals;
	}
	
	
	public void	cleanUp(){
		emfactory.close();
		}
}
