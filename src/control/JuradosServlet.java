package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Jurados;
import model.Quesitos;
import dao.JuradosDao;
import dao.QuesitoDao;

/**
 * Servlet implementation class JuradosServlet
 */
@WebServlet("/JuradosServlet")
public class JuradosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private QuesitoDao quesitoDao;
	private JuradosDao juradosDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JuradosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("listaQuesitos", getQuesitoDao().findAll());
		response.sendRedirect("pages/cadastroJurados.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean btnVoltar = request.getParameter("btnVoltar")!=null;
		
		if(!btnVoltar){
			String nome = request.getParameter("nome");
			String idQuesito = request.getParameter("quesito");
			
			Jurados jurado = new Jurados();
			Quesitos quesito = new Quesitos();
			quesito.setId(Integer.valueOf(idQuesito));
			jurado.setNome(nome);
			jurado.setQuesitos(quesito);
			
			getJuradosDao().salvar(jurado);
			request.setAttribute("mensagem", "Jurado cadastrado com sucesso!");
			request.getRequestDispatcher("pages/cadastroJurados.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("pages/home.jsp").forward(request, response);
		}
	}

	public QuesitoDao getQuesitoDao() {
		return new QuesitoDao();
	}

	public JuradosDao getJuradosDao() {
		return new JuradosDao();
	}

}
