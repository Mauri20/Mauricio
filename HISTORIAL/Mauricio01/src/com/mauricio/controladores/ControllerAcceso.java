package com.mauricio.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mauricio.dao.ClsUsuario;
import com.mauricio.entidades.Login;
import com.mauricio.entidades.usuario;
import com.mauricio.negocio.ClsLogin;

/**
 * Servlet implementation class ControllerAcceso
 */
@WebServlet("/ControllerAcceso")
public class ControllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControllerAcceso() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//Obtener datos desde el JSP
		String user= request.getParameter("user");
		String pass = request.getParameter("pass");
		//Asignar al objeto
		Login log = new Login();
		log.setUser(user);
		log.setPass(pass);
		//Enlazar con la capa de negocio
		ClsLogin clsLogin= new ClsLogin();
		int valoracceso=clsLogin.Acceso(log);
		
		//Evaluar lo que traer el metodo
		if (valoracceso==1) {
			System.out.println("Welcome "+user);
			ClsUsuario usuarioDao = new ClsUsuario();
			ArrayList<usuario> listado = new ArrayList<usuario>();
			
			for (var iterar:usuarioDao.TraerUsuarios()) {
				System.out.println(iterar.getUsuario());
				usuario usu = new usuario();
				usu.setIdUsuario(iterar.getIdUsuario());
				usu.setUsuario(iterar.getUsuario());
				usu.setPassWord(iterar.getPassWord());
				usu.setTipoUsuario(iterar.getTipoUsuario());
				listado.add(usu);
			}
			
			request.setAttribute("usuarios", listado);
			getServletContext().getRequestDispatcher("/Saludo.jsp").forward(request, response);
			//response.sendRedirect("Saludo.jsp");
		}else {
			System.out.println("Error en los Datos");
			response.sendRedirect("Error.jsp");
		}
	}

}
