package com.mauricio.dao;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.mauricio.conexion.ConexionBd;
import com.mauricio.entidades.*;

public class ClsUsuario {
	ConexionBd cn = new ConexionBd();
    Connection con = cn.RetornarConexion();

    public ArrayList<usuario> TraerUsuarios() {
        var listado = new ArrayList<usuario>();
        try {
            CallableStatement statement = con.prepareCall("SELECT * FROM usuario where tipoUsuario=2;");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                usuario usu = new usuario();
                usu.setIdUsuario(res.getInt("idUsuario"));
                usu.setUsuario(res.getString("Usuario"));
                usu.setPassWord(res.getString("PassWord"));
                usu.setTipoUsuario(res.getInt("tipoUsuario"));
                //Agregando a la lista
                listado.add(usu);
            }
        } catch (Exception e) {
        	System.out.println("No se cargaron los Usuarios "+e);
        }

        return listado;
    }
}
