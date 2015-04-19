package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EscolaSamba;
import model.Torcedor;
import model.Usuario;
import dao.EscolaDao;
import dao.TorcedorDao;
import dao.UsuarioDao;
import enumerator.TiposUsuariosEnum;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDao dao;
	private EscolaDao escolaDao;
	private TorcedorDao torcedorDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("listaEscola",getEscolaDao().findAll());
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		boolean btnCadastro = request.getParameter("btnCadastro") != null;

		if (!btnCadastro) {
			String login = request.getParameter("usuario");
			String senha = request.getParameter("senha");

			Usuario usuario = getDao().obterUsuario(login, senha);
			if (usuario != null) {
				request.getSession().setAttribute("perfil",	usuario.getTipoUsuario().name());
				response.sendRedirect("pages/home.jsp");
			} else {
				request.setAttribute("mensagem","Usuário e senha não encontrados na base");
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}
		}else{
			cadastrarTorcedor(request, response);
			request.setAttribute("mensagemCadastro","Torcedor cadastrado com sucesso.");
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	}
	
	private void cadastrarTorcedor(HttpServletRequest request,HttpServletResponse response){
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senhaTorcedor");
		String email = request.getParameter("email");
		String sexo = request.getParameter("sexo");
		String escolaId = request.getParameter("escola");
		
		EscolaSamba escola  =new EscolaSamba();
		escola.setId(Integer.valueOf(escolaId));
		
		Usuario user = cadastrarUsuario(login, senha);
		
		Torcedor torcedor = new Torcedor();
		torcedor.setNome(nome);
		torcedor.setSobrenome(sobrenome);
		torcedor.setEmail(email);
		torcedor.setSexo(sexo);
		torcedor.setEscolaPreferida(escola);
		torcedor.setIdUsuario(user.getIdUsuario());
		getTorcedorDao().salvar(torcedor);
	}

	public Usuario cadastrarUsuario(String login, String senha){
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setTipoUsuario(TiposUsuariosEnum.TORCEDOR);
		getDao().salvar(usuario);
		return getDao().obterUsuario(login, senha);
	}
	
	public UsuarioDao getDao() {
		return new UsuarioDao();
	}

	public EscolaDao getEscolaDao() {
		return new EscolaDao();
	}

	public TorcedorDao getTorcedorDao() {
		return new TorcedorDao();
	}

	
}
