package Utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

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
	public boolean nombre(String nombre) {
		boolean respuesta=true;
		char letra;
		for(int i=0;i<nombre.length();i++) {
			
			letra = nombre.charAt(i);
            if (!Character.isLetter(letra) && letra != 'ñ' && letra != 'Ñ' && letra != ' ') {
                respuesta = false; 
            }
			
		}
		
		return respuesta;
	}
	public boolean direccion(String valor) {
		boolean respuesta=false;
		if(valor.length()>0) {
			respuesta=true;
		}
		return respuesta;
	}
	public boolean existeId(int id) {
		boolean respuesta=false;
				
		try {
			FileReader archivo=new FileReader("lista_empleados.txt");
			BufferedReader memoria=new BufferedReader(archivo);
			
			String linea="";
			while(linea!=null) {
				linea=memoria.readLine();
				if(linea!=null) {
					String[] auxiliar =linea.split("\\|");
					if(auxiliar[0].equalsIgnoreCase(String.valueOf(id))) {
						respuesta=true;
						break;
					}
				}
			}
			archivo.close();
		}catch(IOException ex) {
			throw new RuntimeException("Error al intentar leer el archivo.");
		}
		
		return respuesta;		
	}

	public boolean validaCurpUnico(String curp) {
		boolean respuesta=false;
		
		try {
			
			FileReader archivo = new FileReader("lista_empleados.txt");
			BufferedReader memoria = new BufferedReader(archivo);
			
			String linea="";
			while(linea!=null) {
				
				linea=memoria.readLine();
				if(linea!=null)
				{
					
					if(linea.contains(curp))
					{
						
						respuesta=true;
						break;
						
					}
					
				}
				
			}
			archivo.close();
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	public boolean validaRfcUnico(String rfc) {
		boolean respuesta=false;
		
		try {
			
			FileReader archivo = new FileReader("lista_empleados.txt");
			BufferedReader memoria = new BufferedReader(archivo);
			
			String linea="";
			while(linea!=null) {
				
				linea=memoria.readLine();
				if(linea!=null)
				{
					
					if(linea.contains(rfc))
					{
						
						respuesta=true;
						break;
						
					}
					
				}
				
			}
			archivo.close();
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	public boolean puestoYGenero(String valor) {
		boolean respuesta=false;
		try {
			if(Integer.parseInt(valor)>=1 && Integer.parseInt(valor)<=2) {
				respuesta = true;
			}
			
		} catch (Exception ex) {
			respuesta = false;
		}
		return respuesta;
	}
	public boolean deduccionYPercepcionOpcion(String valor) {
		boolean respuesta=false;
		try {
			if(Integer.parseInt(valor)>=1 && Integer.parseInt(valor)<=3) {
				respuesta = true;
			}
			
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
		 boolean respuesta=false;
	        String formato ="[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}" +
	                        "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" +
	                        "[HM]{1}" +
	                        "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" +
	                        "[B-DF-HJ-NP-TV-Z]{3}" +
	                        "[0-9A-Z]{1}[0-9]{1}$";

	        Pattern patron = Pattern.compile(formato);
	        if (!patron.matcher(curp).matches()) {
	        	respuesta= false;
	        } else {
	        	respuesta= true;

	        }
	        return respuesta;
	        
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
	
	public boolean validarFecha(String fechaString) {
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
	public boolean contenidoDeArchivoEmpleados() {
		boolean respuesta=false;

		try {

			FileReader archivo = new FileReader("lista_empleados.txt");
			BufferedReader memoria = new BufferedReader(archivo);

			String linea;
			while((linea=memoria.readLine())!=null) {
				respuesta=true;
			}
			archivo.close();

		}catch(IOException ex) {

			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	public boolean contenidoDeArchivoPercepciones() {
		boolean respuesta=false;

		try {

			FileReader archivo = new FileReader("lista_percepciones.txt");
			BufferedReader memoria = new BufferedReader(archivo);

			String linea;
			while((linea=memoria.readLine())!=null) {
				respuesta=true;
			}
			
			archivo.close();

		}catch(IOException ex) {

			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	
	public boolean contenidoDeArchivoDeducciones() {
		boolean respuesta=false;

		try {

			FileReader archivo = new FileReader("lista_deducciones.txt");
			BufferedReader memoria = new BufferedReader(archivo);

			String linea;
			while((linea=memoria.readLine())!=null) {
				respuesta=true;
			}
			archivo.close();

		}catch(IOException ex) {

			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}

}
