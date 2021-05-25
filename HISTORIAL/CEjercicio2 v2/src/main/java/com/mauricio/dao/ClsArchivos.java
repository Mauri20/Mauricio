package com.mauricio.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mauricio.conexion.ConexionBd;
import com.mauricio.entidades.usuario;
import java.sql.Connection;

public class ClsArchivos {
	ConexionBd cn = new ConexionBd();
	Connection con = cn.RetornarConexion();
	public void saveFiles(String nombre) {
		
		try {
			PreparedStatement stm;
			String consulta="insert into imagen(nameoffile) values(?)";
			stm=con.prepareStatement(consulta);
			stm.setString(1, nombre);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public ArrayList<String> getFiles() {
		
		ArrayList<String> names= new ArrayList<String>();
		
		try {
			CallableStatement statement = con.prepareCall("Select * from imagen");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                String nombre = res.getString("nameoffile");
                //Agregando a la lista
                names.add(nombre);
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return names;
	}
}
