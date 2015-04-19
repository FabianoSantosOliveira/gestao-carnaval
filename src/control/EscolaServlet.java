package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EscolaSamba;
import model.Usuario;
import dao.EscolaDao;
import dao.UsuarioDao;
import enumerator.TiposUsuariosEnum;

/**
 * Servlet implementation class EscolaServlet
 */
@WebServlet("/EscolaServlet")
public class EscolaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EscolaDao escolaDao; 
    private UsuarioDao usuarioDao;
    private Usuario usuario ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EscolaServlet() {
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
			String cnpj = request.getParameter("cnpj");
			String nome = request.getParameter("nome");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			Usuario user=salvarUsuario(login,senha);
			salvarEscola(cnpj,nome,user);
			
			request.setAttribute("mensagem", "Escola cadastrada com sucesso!");
			request.getRequestDispatcher("pages/cadastroEscola.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("pages/home.jsp").forward(request, response);
		}
	}

	private void salvarEscola(String cnpj,String nome,Usuario usuario){
		EscolaSamba escola =new EscolaSamba();
		escola.setCnpj(cnpj);
		escola.setNomeEscola(nome);
		escola.setIdUsuario(usuario.getIdUsuario());
		getEscolaDao().salvar(escola);
	}
	
	private Usuario salvarUsuario(String login,String senha){
		this.usuario=new Usuario();
		this.usuario.setLogin(login);
		this.usuario.setSenha(senha);
		this.usuario.setTipoUsuario(TiposUsuariosEnum.ESCOLA_SAMBA);
		getUsuarioDao().salvar(usuario);
		return getUsuarioDao().obterUsuario(login, senha);
	}
	
	public EscolaDao getEscolaDao() {
		return new EscolaDao();
	}

	public UsuarioDao getUsuarioDao() {
		return new UsuarioDao();
	}

}
