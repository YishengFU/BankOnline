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
 * Servlet implementation class ComfirmerVirementServlet
 */
@WebServlet("/ComfirmerVirementServlet")
public class ComfirmerVirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComfirmerVirementServlet() {
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
		String nom= request.getParameter("nom");
		int id_cpte_but  = Integer.parseInt(request.getParameter("id_compte_but"));
		double montant = Integer.parseInt(request.getParameter("montant"));
		
		try {
			HttpSession session = request.getSession(false);
			int id_compte = (int) session.getAttribute("idcompte");
			session.setAttribute("idcompte", id_compte);
			if (session != null) {
				Compte compte_but = CompteDAO.getInstance().getById(id_cpte_but);
				String nom_hote=compte_but.getSon_hote().getNom()+" "+compte_but.getSon_hote().getPrenom();
				if(nom_hote.equalsIgnoreCase(nom)) {
						boolean virement = OperationDAO.getInstance().virement(id_compte, id_cpte_but, montant);
						if(virement ==true) {
							PrintWriter out = response.getWriter();
							out.flush();
							out.println("<script>");
							out.println("alert('Virement reussi')");
							out.println("window.location.href='virement_client.jsp'");
							out.println("</script>");
						}
				}else {
					
				}
		
				PrintWriter out = response.getWriter();
				out.flush();
				out.println("<script>");
				out.println("alert('Virement')");
				out.println("window.location.href='virement_client.jsp'");
				out.println("</script>");
			}
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	

}
