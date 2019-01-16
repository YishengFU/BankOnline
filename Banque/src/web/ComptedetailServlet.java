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
import dao.PersonneDAO;
import pojo.Compte;
import pojo.Operation;
import pojo.Personne;

/**
 * Servlet implementation class ComptedetailServlet
 */
@WebServlet("/ComptedetailServlet")
public class ComptedetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComptedetailServlet() {
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
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(false);
		int id_compte = Integer.parseInt(request.getParameter("id"));
		System.out.println(id_compte);
		if(session!=null) {
				Compte currantCompte=CompteDAO.getInstance().getById(id_compte);
				System.out.println(currantCompte);
				Personne currantPersonne = currantCompte.getSon_hote();
				System.out.println(currantPersonne);
				ArrayList<Compte> al_cpte=CompteDAO.getInstance().findById_pers(currantPersonne.getId_pers());
				ArrayList<Operation> al_op=OperationDAO.getInstance().findById_cpte(currantCompte.getId_cpte());
				System.out.println(al_cpte);
				System.out.println(al_op+"ying");
				PrintWriter out = response.getWriter();
				session.setAttribute("nom", currantPersonne.getNom());
				session.setAttribute("prenom", currantPersonne.getPrenom());
				session.setAttribute("solde",al_cpte.get(0).getSolde());
				session.setAttribute("comptes", al_cpte);
				session.setAttribute("operations", al_op);
				out.flush();
				out.println("<script>");
				out.println("alert('acceder votre compte successful')");
				out.println("window.location.href='accueil_client.jsp'");
				out.println("</script>");
		}
		
		else {
			
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('Il faut se connecter')");
			out.println("window.location.href='accueil.jsp'");
			out.println("</script>");
		}
	}

}
