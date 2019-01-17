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
import pojo.Compte;
import pojo.Personne;

/**
 * Servlet implementation class VirementServlet
 */
@WebServlet("/VirementServlet")
public class VirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VirementServlet() {
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
		try {
			HttpSession session = request.getSession(false);
			int id_compte = Integer.parseInt(request.getParameter("id"));
			session.setAttribute("idcompte", id_compte);
			if (session != null) {
				
				Compte currantCompte = CompteDAO.getInstance().getById(id_compte);
				Personne currantPersonne = currantCompte.getSon_hote();
				ArrayList<Compte> al_cpte = CompteDAO.getInstance().findById_pers(currantPersonne.getId_pers());
				PrintWriter out = response.getWriter();
				session.setAttribute("nom", currantPersonne.getNom());
				session.setAttribute("prenom", currantPersonne.getPrenom());
				session.setAttribute("solde", al_cpte.get(0).getSolde());
				out.flush();
				out.println("<script>");
				out.println("alert('Virement')");
				out.println("window.location.href='virement_client.jsp'");
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
	catch(Exception e){
		e.printStackTrace();
	}
	}

}
