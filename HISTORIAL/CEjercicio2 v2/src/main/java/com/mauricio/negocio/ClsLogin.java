package com.mauricio.negocio;

import com.mauricio.dao.ClsLoginDao;
import com.mauricio.entidades.*;

public class ClsLogin {
	public int Acceso(usuario log) {
		int acceso=0;
		
		/*if(log.getUser().equals("Mauri") && log.getPass().equals("123")) {
			acceso=1;
		}*/
		
		ClsLoginDao loginDao= new ClsLoginDao();
		usuario usu= new usuario();
		
		usu=loginDao.Login(log);
		if(usu!=null) {
			if(usu.getTipoUsuario()==1) {
				acceso=1;
			}else if(usu.getTipoUsuario()==2) {
				acceso=2;
			}
			System.out.println("Usuario encontrado Bienvenido: "+usu.getTipoUsuario());
		}else {
			System.out.println("Usuario vacio");
		}
		return acceso;
	}
}
