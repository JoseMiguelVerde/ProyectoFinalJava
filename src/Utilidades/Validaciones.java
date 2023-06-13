package Utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

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
	public boolean nombreYDireccion(String valor) {
		boolean respuesta=false;
		if(valor.length()>0) {
			respuesta=true;
		}
		return respuesta;
	}
	public boolean fechaDeNacimiento(String valor) {
		boolean respuesta=false;
		if(valor.length()>0) {
			respuesta=true;
		}
		return respuesta;
	}
//	public static LocalDate transformarFecha(String fecha) {
//     
//        LocalDate localDate = LocalDate.parse(fecha, Constantes.FORMATO_FECHA_NACIMIENTO);
//        return fechaTransformada
//	}
	public boolean puestoYGenero(String valor) {
		boolean respuesta=false;
		try {
			if(Integer.parseInt(valor)>=1 && Integer.parseInt(valor)<=2);
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
	
	public boolean codigoPostal(String valor) {
	    boolean respuesta = false;
	    
	    try {
	    if (valor.length() == 5) 
	    { 
	    	
	        int codigo = Integer.parseInt(valor);
	        if (codigo >= 1000 && codigo <= 16900) 
	        { 
	        	
	        	respuesta = true;
	        	
	        }
	        
	    }
	    }catch(Exception ex) {
	    	respuesta=false;
	    }
	    
	    return respuesta;
	}
	
	public static boolean validarFecha(String fechaString) {
        boolean respuesta=false;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        try {
            
            Date fecha = dateFormat.parse(fechaString);
            Calendar fechaActual = Calendar.getInstance();
            fechaActual.add(Calendar.YEAR, -15);

            if (fecha.before(fechaActual.getTime())) 
            {
                respuesta = true; 
            }
        } catch (Exception ex) {
            respuesta=false;
        }

        return respuesta; 
    }


}
