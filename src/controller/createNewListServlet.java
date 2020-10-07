package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.ListMeal;
import model.Planner;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListMealHelper lmh = new ListMealHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
				
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String plannerName = request.getParameter("plannerName");
		LocalDate ld;

		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			}catch(NumberFormatException ex) {
				ld = LocalDate.now();
				}

		String[] selectedItems = request.getParameterValues("allMealsToAdd");

		List<ListMeal> selectedMealsInList = new ArrayList<ListMeal>(); 
		//make sure something was selected –otherwise we get a null pointer exception
			if (selectedItems != null && selectedItems.length > 0)
			{
				for(int i = 0; i<selectedItems.length; i++) {
					System.out.println(selectedItems[i]);
					ListMeal c = lmh.searchForMealById(Integer.parseInt(selectedItems[i]));
					selectedMealsInList.add(c);
				}
			}
			
			Planner planner = new Planner(plannerName);
			ListDetails sld = new ListDetails(listName, ld, planner);
			sld.setListOfMeals(selectedMealsInList);
			ListDetailsHelper slh = new ListDetailsHelper();
			slh.insertNewListDetails(sld);
			
			System.out.println("Success!");
			System.out.println(sld.toString());
			
			getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
