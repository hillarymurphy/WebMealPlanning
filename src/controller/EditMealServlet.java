package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListMeal;

/**
 * Servlet implementation class EditMealServlet
 */
@WebServlet("/editMealServlet")
public class EditMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMealServlet() {
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
		ListMealHelper dao = new ListMealHelper();
		
		String main = request.getParameter("main");
		String vegetable = request.getParameter("vegetable");
		String fruit = request.getParameter("fruit");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListMeal mealToUpdate = dao.searchForMealById(tempId);
		mealToUpdate.setFruit(fruit);
		mealToUpdate.setVegetable(vegetable);
		mealToUpdate.setMain(main);
		
		dao.updateMeal(mealToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllMealsServlet").forward(request, response);
	}

}
