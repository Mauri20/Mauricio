package com.mauricio.controladores;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sound.midi.Soundbank;

import com.google.gson.Gson;
import com.mauricio.dao.ClsArchivos;



/**
 * Servlet implementation class ControllerFiles
 */
//SE AGREGA ESTA NOTACION PARA QUE ACEPTE LOS ARCHIVOS MULTIPARTES!!!!!!!!!!!!!!!!!!!
@MultipartConfig
public class ControllerFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerFiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String opcion= request.getParameter("traer");
		if(opcion.equals("si")) {
			ClsArchivos files= new ClsArchivos();
			ArrayList<String> names= new ArrayList<String>();
			for(var iterar:files.getFiles()){
				String nombre= new String();
				nombre=iterar;
				System.out.println(iterar);
				names.add(nombre);
			}			
			
			Gson json = new Gson();
			response.getWriter().append(json.toJson(names));
			response.sendRedirect("mostrarImagen.jsp");
			
			/*request.setAttribute("names", names);
			getServletContext().getRequestDispatcher("/mostrarImagen.jsp").forward(request, response);*/
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//Obtenemos los archivos
		Part file=request.getPart("file");
		//Obtenemos el Nombre del archivo
		String nombreImagen= file.getSubmittedFileName();
		//Asignamos la ruta a guardar
		String ruta = "C:\\Users\\Mauricio\\Documents\\workspace-eclipse\\CEjercicio2\\src\\main\\webapp\\Files\\"+nombreImagen;
		try {
			FileOutputStream archivoSalida = new FileOutputStream(ruta);
			//Recreamos el archivo en el back end
			InputStream stream = file.getInputStream();
			//creamos un array y verificamos siel archivo del Stream esta disponible o existe
			byte[] datos = new byte[stream.available()];
			//Leemos el archivo ya existente
			stream.read(datos);
			//Enviamos el archivo Recreado a la ruta de salida/Escribimos en la nueva ruta el nuevo archivo "datos"
			archivoSalida.write(datos);
			//Cerramos la "salida"
			archivoSalida.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		ClsArchivos files = new ClsArchivos();
		files.saveFiles(ruta);
	}

}
