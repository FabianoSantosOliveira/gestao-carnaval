package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuesitoDao;

/**
 * Servlet implementation class QuesitoServlet
 */
@WebServlet("/QuesitoServlet")
public class QuesitoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private QuesitoDao dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuesitoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean btnVoltar = request.getParameter("btnVoltar")!=null;
		
		
		if(!btnVoltar){
			String nomeQuesito = request.getParameter("nome");
			getDao().salvar(nomeQuesito);
			request.setAttribute("mensagem", "Quesito cadastrado com sucesso!");
			request.getRequestDispatcher("pages/cadastroQuesitos.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("pages/home.jsp").forward(request, response);
		}
		
	}

	public QuesitoDao getDao() {
		return new QuesitoDao();
	}

	public void setDao(QuesitoDao dao) {
		this.dao = dao;
	}

	
}
