import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.ListMeal;
import model.Planner;

public class PlanningTester {

	public static void main(String[] args) {
		
		Planner betty = new Planner("Betty");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListMeal monday = new ListMeal("Chicken", "Corn","Mangoes");
		ListMeal tuesday = new ListMeal("Pork Chops", "Green Beans", "Grapes");
		List<ListMeal> bettysMeals = new ArrayList<ListMeal>();
				
		bettysMeals.add(monday);
		bettysMeals.add(tuesday);
				
		ListDetails bettysList = new ListDetails("Betty's Meal Plan", LocalDate.now(), betty);
				
		bettysList.setListOfMeals(bettysMeals);
		
		ldh.insertNewListDetails(bettysList);
		
		List<ListDetails> allLists = ldh.getLists();
				
		for (ListDetails a: allLists) {
				System.out.println(a.toString());
				}
	}
}
