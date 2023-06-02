package Utilidades;

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
	
	public boolean validarCurp(String valor) {
		boolean respuesta;
		try {
			
			respuesta=true;
		} catch(Exception ex) {
			respuesta=false;
		}
		return respuesta;
	}
}
