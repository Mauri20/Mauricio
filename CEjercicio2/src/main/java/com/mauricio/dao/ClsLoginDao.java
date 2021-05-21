package com.mauricio.dao;

import java.sql.*;

import com.mauricio.conexion.ConexionBd;
import com.mauricio.entidades.usuario;

public class ClsLoginDao {
	ConexionBd cn = new ConexionBd();
    Connection con = cn.RetornarConexion();
	public usuario Login(usuario user) {
        usuario usu = new usuario();
        try {
            CallableStatement statement = con.prepareCall("call sp_s_Login(?,?);");
            statement.setString("pUsuario", user.getUsuario());
            statement.setString("pPass", user.getPassWord());
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                usu.setIdUsuario(res.getInt("idUsuario"));
                usu.setUsuario(res.getString("Usuario"));
                usu.setPassWord(res.getString("PassWord"));
                usu.setTipoUsuario(res.getInt("tipoUsuario"));
            }
        } catch (Exception e) {
        	System.out.println("No se encontró el usuario" + e);
        }
        return usu;
    }
}
