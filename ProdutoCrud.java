package br.com.fiap.crud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Produtocrud
 */
@WebServlet("/produto")
public class ProdutoCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoCrud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		System.out.println("Código" + codigo);
		
		request.setAttribute("cod", codigo);
		request.setAttribute("nome", "Abacaxi");
		request.getRequestDispatcher("buscar-produto.jsp").forward(request, response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recupera os parametros do formulario HTML
		String nome = request.getParameter("nome");
		int qtd = Integer.parseInt(request.getParameter("quantidade"));
		double valor = Double.parseDouble(request.getParameter("valor"));
		
//		Adiciona atributos no request para exibir na tela
		request.setAttribute("nomeProduto", nome);
		request.setAttribute("quantidade", qtd);
		request.setAttribute("valor", valor);
		
		request.getRequestDispatcher("sucesso.jsp").forward(request, response);
	}

}
