package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PersonneDAO;
import pojo.Personne;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String  pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		
	try {			
			Personne currantPersonne = PersonneDAO.getInstance().login(pseudo, mdp);
			if(currantPersonne == null) {
				request.setAttribute("error", "personne exist pas ou mot de passe est incorrect");
				request.setAttribute("pseudo", pseudo);
				request.setAttribute("mdp", mdp);
				//response.sendRedirect("login-success.jsp");
				request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
				HttpSession session = request.getSession();
				session.setAttribute("currantPersonne", currantPersonne);
				response.sendRedirect("accueil.jsp");
		}
	}
	catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
