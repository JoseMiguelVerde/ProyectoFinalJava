package Utilidades;

import Entidades.Empleado;

public class Validaciones {

	public boolean validarEntero(String valor) {
		boolean respuesta;
		try {
			Integer.parseInt(valor);
			respuesta = true;
		} catch (Exception ex) {
			respuesta = false;
		}
		return respuesta;
	}
	
	public boolean validarFlotante(String valor) {
		boolean respuesta;
		try {
			Float.parseFloat(valor);
			respuesta = true;
		} catch (Exception ex) {
			respuesta = false;
		}
		return respuesta;
	}

	public boolean validarCurp(String curp) {

		String formato="[A-Z]{4}\\d{6}[HM]{1}(AS|BC|BS|CC|CH|CL|CM|CS|DF|DG|GR|GT|HG|JC|MC|MN|MS|NE|NL|NT|OC|PL|QR|QT|SL|SP|SR|TC|TL|TS|VZ|YN|ZS){1}[A-Z]{3}[\\dA-ZÑ]{2}\\d{1}";

		return curp.matches(formato);
	}

	public boolean validarRfc(String rfc) {

		String formato="[A-Z]{4}\\d{6}[A-Z\\d]{3}";

		return rfc.matches(formato);
	}
	
	public boolean arregloVacío(Empleado[] arreglo) {
		boolean respuesta=true;
		
		for (int i=0;i<arreglo.length;i++) {
			
			if(arreglo[i]!=null) 
			{
				respuesta=false;
				break;
			}
				
		}
		
		return respuesta;
	}


}
