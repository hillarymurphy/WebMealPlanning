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
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper dao = new	ListDetailsHelper();
		ListMealHelper lmh = new ListMealHelper();
		PlannerHelper ph = new PlannerHelper();
		
		Integer tempId 	= Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = dao.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String plannerName = request.getParameter("plannerName");
		//find our add the new shopper
		Planner newPlanner = ph.findPlanner(plannerName);
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year),
					Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			//items are selected in list to add
			String[] selectedMeals = request.getParameterValues("allMealsToAdd");
			List<ListMeal> selectedMealsInList = new ArrayList<ListMeal>();

			for	(int i = 0; i < selectedMeals.length; i++) {
				System.out.println(selectedMeals[i]);
				ListMeal c = lmh.searchForMealById(Integer.parseInt(selectedMeals[i]));
				selectedMealsInList.add(c);

			}
			listToUpdate.setListOfMeals(selectedMealsInList);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list

			List<ListMeal> selectedMealsInList = new ArrayList<ListMeal>();
			listToUpdate.setListOfMeals(selectedMealsInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setMealPlanDate(ld);
		listToUpdate.setPlanner(newPlanner);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}
}