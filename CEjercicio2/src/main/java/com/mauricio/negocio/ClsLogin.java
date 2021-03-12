package com.mauricio.negocio;

import com.mauricio.entidades.Login;

public class ClsLogin {
	public int Acceso(Login log) {
		int acceso=0;
		if(log.getUser().equals("Mauricio") && log.getPass().equals("123")) {
			acceso=1;
		}
		return acceso;
	}
}
