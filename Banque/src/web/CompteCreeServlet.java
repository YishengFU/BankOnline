package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CompteDAO;
import dao.OperationDAO;
import pojo.Compte;
import pojo.Operation;
import pojo.Personne;

/**
 * Servlet implementation class CompteCreeServle
 */
@WebServlet("/CompteCreeServle")
public class CompteCreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteCreeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int id_type_compte = Integer.parseInt(request.getParameter("typecompte"));
		int id_type_statut= Integer.parseInt(request.getParameter("statut"));
		try {
				HttpSession session = request.getSession(false);
				int id_pers = (int) session.getAttribute("id_pers");
				if (session != null) {
				int currantCompte = CompteDAO.getInstance().createSimple(id_pers,id_type_compte,id_type_statut);
				if(currantCompte >0 ) {
					
					session.setAttribute("comptes", CompteDAO.getInstance().findById_pers(id_pers));
					PrintWriter out = response.getWriter();
					out.flush();
					out.println("<script>");
					out.println("window.location.href='accueil_client.jsp'");
					out.println("</script>");
				}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
