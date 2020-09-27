package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListMeal;

/**
 * Servlet implementation class AddMealServlet
 */
@WebServlet("/addMealServlet")
public class AddMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String main = request.getParameter("main");
		String vegetable = request.getParameter("vegetable");
		String fruit = request.getParameter("fruit");
		
		ListMeal lm = new ListMeal(main, vegetable, fruit);
		ListMealHelper dao = new ListMealHelper();
		dao.insertMeal(lm);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
