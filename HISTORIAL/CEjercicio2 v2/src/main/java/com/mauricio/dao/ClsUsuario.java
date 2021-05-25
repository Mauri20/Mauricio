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
        /*try {
            CallableStatement statement = con.prepareCall("SELECT * FROM usuario;");
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
        }*/
        try {
            CallableStatement statement = con.prepareCall("select u.idUsuario, u.Usuario, u.password,t.TipoUser as TipoUsuario from usuario as u inner join tipousuario as t where u.tipoUsuario = t.id");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                usuario usu = new usuario();
                usu.setIdUsuario(res.getInt("idUsuario"));
                usu.setUsuario(res.getString("Usuario"));
                usu.setPassWord(res.getString("PassWord"));
                usu.setTipoUser(res.getString("tipoUsuario"));
                //usu.setTipoUsuario(res.getInt("tipoUsuario"));
                //Agregando a la lista
                listado.add(usu);
            }
        } catch (Exception e) {
        	System.out.println("No se cargaron los Usuarios "+e);
        }

        return listado;
    }
    public void Eliminar(usuario user) {
		try {
			CallableStatement statement= con.prepareCall("call sp_d_user(?)");
			statement.setInt("pIdUsuario", user.getIdUsuario());
			statement.executeQuery();
			System.out.println("Eliminado");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
    public void Actualizar(usuario user) {
		try {
			CallableStatement statement= con.prepareCall("call sp_u_usuario(?,?,?)");
			statement.setString("PUsuario", user.getUsuario());
			statement.setString("PPass", user.getPassWord());
			statement.setInt("PidUsuario", user.getIdUsuario());
			statement.executeQuery();
			System.out.println("Actualizado");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
    public void Agregar(usuario user) {
		try {
			CallableStatement statement= con.prepareCall("call sp_i_usuario(?,?,?)");
			statement.setString("PUsuario", user.getUsuario());
			statement.setString("PPass", user.getPassWord());
			statement.setInt("PTipoUsuario", user.getTipoUsuario());
			statement.executeQuery();
			System.out.println("Guardado");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
}
