package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Type_compteDAO;
import pojo.Type_compte;

/**
 * Servlet implementation class CompteServlet
 */
@WebServlet("/CompteServlet")
public class CompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteServlet() {
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
		
		try {
				HttpSession session = request.getSession(false);
			if(session!=null) {
				 Type_compte TypeCompte = Type_compteDAO.getInstance().getById(Integer.parseInt((String) session.getAttribute("id_pers")));
				 //session.setAttribute("libelle", TypeCompte.getLib_type_cpte());
				 
				 if(TypeCompte.getId_type_cpte()==1) {
					
					String libelle = TypeCompte.getLib_type_cpte();
					session.setAttribute("libelle", libelle);
				}
			}
			
			}catch(Exception e){
					e.printStackTrace();
				}
	
		}
}
