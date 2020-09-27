package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListMeal;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		
		// after all changes, we should redirect to the viewAllMeals servlet
		// The only time we don't is if they select to add a new item or edit
		
		String path = "/viewAllMealsServlet";
		
		ListMealHelper dao = new ListMealHelper();
		String act = request.getParameter("doThisToMeal");
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListMeal mealToDelete = dao.searchForMealById(tempId);
				dao.deleteMeal(mealToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a meal");
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListMeal mealToEdit = dao.searchForMealById(tempId);
				request.setAttribute("mealToEdit", mealToEdit);
				path = "/edit-meal.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a meal");
			}
		} else if (act.equals("add")) {
			path = "/index.html";
		}
	
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
