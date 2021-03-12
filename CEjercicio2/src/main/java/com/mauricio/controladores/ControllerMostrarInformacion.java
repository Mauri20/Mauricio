package com.mauricio.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mauricio.dao.ClsUsuario;
import com.mauricio.entidades.usuario;

/**
 * Servlet implementation class ControllerMostrarInformacion
 */
@WebServlet("/ControllerMostrarInformacion")
public class ControllerMostrarInformacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerMostrarInformacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ClsUsuario clsusu = new ClsUsuario();
		//Java Bean son las entidades puras
		usuario usu = new usuario();
		usu.setIdUsuario(Integer.parseInt(request.getParameter("usu")));
		clsusu.Eliminar(usu);
		//Para trabajar con Postman no se hace la redireccion, Postman
		//Se usa para comprobar el backend sin haber hecho una vista antes
		response.sendRedirect("Saludo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Gson json = new Gson();
		ClsUsuario clsUser= new ClsUsuario();
		
		response.getWriter().append(json.toJson(clsUser.TraerUsuarios()));
		
	}

}
