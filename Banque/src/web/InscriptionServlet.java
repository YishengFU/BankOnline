package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonneDAO;
import pojo.Personne;
import pojo.Sexe;
import pojo.Statut;
import pojo.Ville;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Personne p = new Personne();
		Sexe s =new Sexe();
		Ville v =  new Ville();
		Statut statuts = new Statut(); 
		String  nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String datenais = request.getParameter("datenais");
		String adresse = request.getParameter("adresse");
		int ville = Integer.parseInt(request.getParameter("ville"));
		int sexe = Integer.parseInt(request.getParameter("sexe"));
		String  tel = request.getParameter("tel");
		String mail = request.getParameter("mail");
		String  pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		int statut = Integer.parseInt(request.getParameter("statut"));
		s.setId_sexe(sexe);
		v.setId_ville(ville);
		statuts.setId_statut(statut);
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(datenais, formatage);
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setDate_naissance(date);
		p.setAdresse(adresse);
		p.setSa_ville(v);
		p.setSon_sexe(s);
		p.setSon_statut(statuts);
		p.setTelephone(tel);
		p.setEmail(mail);
		p.setPseudo(pseudo);
		p.setMdp(mdp);
	try {			
			
			boolean isexist = PersonneDAO.getInstance().exists(nom,prenom,date);
			if(!isexist) {
				//response.sendRedirect("login.jsp");
				//request.getRequestDispatcher("login.jsp").forward(request, response);
				
				int createPersonne = PersonneDAO.getInstance().create(p);
				if(createPersonne>0) {
					PrintWriter out = response.getWriter();
					out.flush();
					out.println("<script>");
					out.println("alert('Inscription successful')");
					out.println("confirm('Voulez-vous vous connecter ?')");
					out.println("window.location.href='login.jsp'");
					out.println("</script>");
					//response.sendRedirect("login.jsp");
				}
				else {
					PrintWriter out = response.getWriter();
					out.flush();
					out.println("<script>");
					out.println("alert('Inscription fail')");
					out.println("window.location.href='inscription.jsp'");
					out.println("</script>");
					//response.sendRedirect("inscription.jsp");
				}
			}
			else {
				PrintWriter out = response.getWriter();
				out.flush();
				out.println("<script>");
				out.println("alert('Inscription fail,Vous avez eu le compte')");
				out.println("confirm('Voulez-vous vous connecter ?')");
				out.println("window.location.href='login.jsp'");
				out.println("</script>");
			}
		}
	catch(Exception e){
			e.printStackTrace();
		}
	}
}
