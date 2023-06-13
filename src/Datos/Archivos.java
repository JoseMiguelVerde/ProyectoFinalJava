package Datos;
/*    

-----------MANIPULACIÓN DE ARCHIVOS----------------

		   Se puede guardar de manera permanente la información en el equipo
		   y para ello en vez de ocupar la memoria RAM, se deberá usar un medio
		   físico como un disco duro, una unidad USB  y para realizar esta operación 
		   se tienen que manejar streams o flujos.
		   
		   Se pueden abordar los streams como FLUJOS DE BYTES o FLUJOS DE CARACTERES:
		   
		   -Si se requiere almacenar información que vamos a leer como un documento 
		   de texto se ocuparía el FLUJOS DE CARACTERES
		   					Reader (Secuencia de entrada)
		   					Writer (Secuencia de salida)
		   
		  -Si se requiere enviar información a través de la red a un sitio remoto, lo
		   mejor es mandarlo como FLUJO DE CARACTERES ya que no se requiere leer 
		   la información.
		   					InputStream (Secuencia de entrada)
		   					OutputStream (Secuencia de salida)

		 
		  Todos los métodos o clases pertenecientes al paquete java.io nos van a pedir 
		  siempre que capturemos las excepciones, lo anterior es porque puede ocurrir que 
		  la información que está almacenada en dispositivos físicos no esté disponible, por
		  ello java nos exige controlar las excepciones.
-----------BUFFERS ----------- 
		  	
		  	Cuando el archivo tiene miles o millones de caracteres, las funciones anteriores no son eficientes 
		    porque cada que nosotros queremos escribir o leer  información en el archivo, lo que hacemos  es comunicarnos
		    con el archivo y leer o escribir carácter a carácter. En el caso de el archivo tuviera miles o millones 
		    de caracteres  esto sería una operación que se tendría que repetir miles o millones de veces lo que la 
		    haría ineficiente y lenta , estaría consumiendo muchos recursos.
		    
		    Para solucionar lo anterior se requiere de un Buffer,  éste es una especie de memoria interna que se 
		    coloca entre el programa de java y el archivo.
		    
		    					Programa Java ------  Buffer ------ Archivo
		    
		    El objetivo del buffer (memoria intermedia)  es que en vez de acceder al archivo se acceda al buffer.
		    	-Se gana rapidez, eficiencia 
		    	-Si existe una problema de comunicación con el archivo no se vería interrumpido el proceso 
		    	-Se usan los buffes para leer y escribir 
		    	
		    							BufferedReader  
		    							  	readLine()  lee línea a línea 
		    							BufferdWriter 
		    								writeLine()
-----------STREAMS BYTE -----------

		 	Es una poderosa herramienta para poder enviar o recibir cualquier tipo de archivo desde un programa de java.
		 	En informática cualquier tipo de archivo es susceptible de convertirse en una sucesión de bytes:
		 	 
		 							FileInputStream
		 							FileOutPutStream
		 				
		     
*/
import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDate;

import Entidades.Deducciones;
import Entidades.Empleado;
import Entidades.Percepciones;
import Utilidades.Constantes;
import Utilidades.Constantes.*;

public class Archivos {
	
	File listaEmpleados=new File("lista_empleados.txt");
	File listaPercepciones=new File("lista_percepciones.txt");
	File listaDeducciones=new File("lista_deducciones.txt");
	File listaNomina=new File("lista_nomina.txt");
	
	public Archivos(){
		
		if(!listaEmpleados.exists())
		{
			
			try {
				
				listaEmpleados.createNewFile();
				
			} catch (IOException e) {
				
				throw new RuntimeException("Error al intentar crear el archivo lista_empleados.txt");
				
			}
			
		}
		
		if(!listaPercepciones.exists())
		{
			
			try {
				
				listaPercepciones.createNewFile();
				
			} catch (IOException e) {
				
				throw new RuntimeException("Error al intentar crear el archivo lista_percepciones.txt");
				
			}
			
		}
		
		if(!listaDeducciones.exists())
		{
			
			try {
				
				listaDeducciones.createNewFile();
				
			} catch (IOException e) {
				
				throw new RuntimeException("Error al intentar crear el archivo lista_deducciones.txt");
				
			}
			
		}
		
		if(!listaNomina.exists())
		{
			
			try {
				
				listaNomina.createNewFile();
				
			} catch (IOException e) {
				
				throw new RuntimeException("Error al intentar crear el archivo lista_nomina.txt");
				
			}
			
		}
	}
	
	public boolean creaArchivoAuxiliar() {
		boolean respuesta=false;
		
		File archivoAuxiliar=new File("archivo_auxiliar.txt");
		
		if(!archivoAuxiliar.exists())
		{
			try {
				
				archivoAuxiliar.createNewFile();
				respuesta=true;
				
			} catch (IOException e) {
				
				throw new RuntimeException("Error al intentar crear el archivo archivo_auxiliar.txt");
				
			}
		}else if(archivoAuxiliar.exists()) {
			respuesta=true;
		}
		
		return respuesta;
	}
	public int dameIdEmpleados() {
		int respuesta=0, id=0;
		
		try {
			
			FileReader archivoLectura=new FileReader("lista_empleados.txt", Charset.forName("UTF8"));
			BufferedReader memoria=new BufferedReader(archivoLectura);
			
			String linea="";
			while(linea!=null) {
				
				linea=memoria.readLine();
				if(linea!=null)
				{
					
					String[] auxiliar =linea.split("\\|");
					if(Integer.parseInt(auxiliar[0])>id) {
						id=Integer.parseInt(auxiliar[0]);
					}
					
				}
				
			}
			archivoLectura.close();
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		respuesta=id+1;
		return respuesta;
	}
	public int dameIdPercepciones() {
		int respuesta=0, id=0;
		
		try {
			
			FileReader archivoLectura=new FileReader("lista_percepciones.txt", Charset.forName("UTF8"));
			BufferedReader memoria=new BufferedReader(archivoLectura);
			
			String linea="";
			while(linea!=null) {
				
				linea=memoria.readLine();
				if(linea!=null)
				{
					
					String[] auxiliar =linea.split("\\|");
					if(Integer.parseInt(auxiliar[0])>id) {
						id=Integer.parseInt(auxiliar[0]);
					}
					
				}
				
			}
			archivoLectura.close();
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		respuesta=id+1;
		return respuesta;
	}
	public int dameIdDeducciones() {
		int respuesta=0, id=0;
		
		try {
			
			FileReader archivoLectura=new FileReader("lista_deducciones.txt", Charset.forName("UTF8"));
			BufferedReader memoria=new BufferedReader(archivoLectura);
			
			String linea="";
			while(linea!=null) {
				
				linea=memoria.readLine();
				if(linea!=null)
				{
					
					String[] auxiliar =linea.split("\\|");
					if(Integer.parseInt(auxiliar[0])>id) {
						id=Integer.parseInt(auxiliar[0]);
					}
					
				}
				
			}
			archivoLectura.close();
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		respuesta=id+1;
		return respuesta;
	}
	public int dameIdNomina() {
		int respuesta=0, id=0;
		
		try {
			
			FileReader archivoLectura=new FileReader("lista_nomina.txt", Charset.forName("UTF8"));
			BufferedReader memoria=new BufferedReader(archivoLectura);
			
			String linea="";
			while(linea!=null) {
				
				linea=memoria.readLine();
				if(linea!=null)
				{
					
					String[] auxiliar =linea.split("\\|");
					if(Integer.parseInt(auxiliar[0])>id) {
						id=Integer.parseInt(auxiliar[0]);
					}
					
				}
				
			}
			archivoLectura.close();
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		respuesta=id+1;
		return respuesta;
	}
	
	
	
	public boolean guardaEmpleado(Empleado datos) {
		boolean respuesta=false;
		
		try {
			
			FileWriter archivo=new FileWriter("lista_empleados.txt",true);
			
			archivo.write(String.valueOf(datos.getId()) + "|" + datos.getNombreCompleto() + "|" + datos.getPuesto().getPuesto() + "|" + String.valueOf(datos.getPuesto().getSueldo()) + "|" + datos.getRfc() + "|" + datos.getCurp() + "|" + datos.getDireccion() + "|" + datos.getGenero().getNombreGenero() + "|" + datos.getEstatus() + "|" + datos.getFechaNacimiento().toString() + "|" + datos.getFechaContratacion().toString() + "\n");
			
			archivo.close();
			respuesta=true;
			
		}catch(IOException ex) {
			
			System.out.println("No se ha encontrado el archivo.");
			
		}
		
		return respuesta;
	}
	
	public String mostrarTodosEmpledos() {
		String respuesta=Constantes.CABECERA_EMPLEADO;

		try {

			FileReader archivoLectura=new FileReader("lista_empleados.txt", Charset.forName("UTF8"));
			BufferedReader memoria=new BufferedReader(archivoLectura);
			
			String linea="";
			while(linea!=null) {
				
				linea=memoria.readLine();
				if(linea!=null)
				{
					
					respuesta+= linea.replace('|', '\t')+"\n";
				
				}
				
			}
			archivoLectura.close();
		
		}catch(IOException ex) {
			
			System.out.println("Error al intentar leer el archivo.");
		}
		
		return respuesta;
	}
	
	public boolean modificarPorIdEmpleado(int idEmpleado, int datoAEditar, Object dato) {
		boolean respuesta=false;
		
		try {
			
			if(creaArchivoAuxiliar()==true)
			{
				FileReader archivoLectura=new FileReader("lista_empleados.txt", Charset.forName("UTF8"));
				BufferedReader memoriaLectura=new BufferedReader(archivoLectura);
				
				FileWriter archivoAuxiliar=new FileWriter("archivo_auxiliar.txt",true);
				BufferedWriter memoriaEscritura=new BufferedWriter(archivoAuxiliar);

				String linea="";
				while((linea=memoriaLectura.readLine())!=null) {


					String[] auxiliar = linea.split("\\|");
					if(auxiliar.length>0 && auxiliar[0].equalsIgnoreCase(String.valueOf(idEmpleado)))
					{

						auxiliar[datoAEditar]=String.valueOf(dato);
						String LineaModificada = String.join("|", auxiliar);
						memoriaEscritura.write(LineaModificada);
						memoriaEscritura.newLine();

					}else {
						
						memoriaEscritura.write(linea);
						memoriaEscritura.newLine();
						
					}

					
				}
				memoriaLectura.close();
				memoriaEscritura.close();
				
				File original = new File("lista_empleados.txt");
				File reemplazo = new File("archivo_auxiliar.txt");
				
				original.delete();
				reemplazo.renameTo(original);
			}
			
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	
	public boolean bajaEmpleadoPorIdFisica(int idEmpleado) {
		boolean respuesta=false;
		
		try {
			
			if(creaArchivoAuxiliar()==true)
			{
				FileReader archivoLectura=new FileReader("lista_empleados.txt", Charset.forName("UTF8"));
				BufferedReader memoriaLectura=new BufferedReader(archivoLectura);
				
				FileWriter archivoAuxiliar=new FileWriter("archivo_auxiliar.txt",true);
				BufferedWriter memoriaEscritura=new BufferedWriter(archivoAuxiliar);

				String linea="";
				while((linea=memoriaLectura.readLine())!=null) {


					String[] auxiliar = linea.split("|");
					if(auxiliar.length>0 && !auxiliar[0].equalsIgnoreCase(String.valueOf(idEmpleado)))
					{

						memoriaEscritura.write(linea);
						memoriaEscritura.newLine();

					}
					
				}
				memoriaLectura.close();
				memoriaEscritura.close();
				
				File original = new File("lista_empleados.txt");
				File reemplazo = new File("archivo_auxiliar.txt");
				
				original.delete();
				reemplazo.renameTo(original);
			}
			
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	
	public String[] buscarEnListaEmpleados(BuscarPor tipo, Object valor) {
		String[] respuesta=null;
		int contador=0;
		
		try {
			
			FileReader archivoLectura=new FileReader("lista_empleados.txt", Charset.forName("UTF8"));
			BufferedReader memoria=new BufferedReader(archivoLectura);
			
			String linea="";
			while(linea!=null) {
				
				linea=memoria.readLine();
				if(linea!=null)
				{
					
					String[] auxiliar =linea.split("\\|");
					if(tipo==BuscarPor.ID && Integer.parseInt(auxiliar[0])==(Integer)valor)
					{
						
						contador++;
						
					}
					
					if(tipo==BuscarPor.NOMBRE && auxiliar[1].equalsIgnoreCase((String)valor))
					{

						contador++;

					}
					
					if(tipo==BuscarPor.PUESTO && auxiliar[2].equalsIgnoreCase((String)valor))
					{
						
						contador++;
						
					}
					
					if(tipo==BuscarPor.GENERO && auxiliar[7].equalsIgnoreCase((String)valor))
					{
						
						contador++;
						
					}
					
					if(tipo==BuscarPor.ESTATUS && auxiliar[8].equalsIgnoreCase((String)valor))
					{
						
						contador++;
						
					}
				}
				
			}
			archivoLectura.close();
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		//----------------------------------------------------------------------
		
		if(contador>0)
		{
			
			respuesta=new String[contador];
			int j=0;
			
			try {
				
				FileReader archivoLectura=new FileReader("lista_empleados.txt", Charset.forName("UTF8"));
				BufferedReader memoria=new BufferedReader(archivoLectura);
				
				String linea="";
				while(linea!=null) {
					
					linea=memoria.readLine();
					if(linea!=null)
					{
						
						String[] auxiliar=linea.split("\\|");
						if(tipo==BuscarPor.ID && Integer.parseInt(auxiliar[0])==(Integer)valor)
						{
							
							respuesta[j]=auxiliar[0] + "|" + auxiliar[1] + "|" + auxiliar[2] + "|" + auxiliar[3] + "|" + auxiliar[4] + "|" + auxiliar[5] + "|" + auxiliar[6] + "|" + auxiliar[7] + "|" + auxiliar[8] + "|" + auxiliar[9] + "|" + auxiliar[10];
							j++;
							
						}
						
						if (tipo==BuscarPor. NOMBRE && auxiliar [1].equalsIgnoreCase((String)valor))
						{
							
							respuesta[j]=auxiliar[0] + "|" + auxiliar[1] + "|" + auxiliar[2] + "|" + auxiliar[3] + "|" + auxiliar[4] + "|" + auxiliar[5] + "|" + auxiliar[6] + "|" + auxiliar[7] + "|" + auxiliar[8] + "|" + auxiliar[9] + "|" + auxiliar[10];
							j++;
							
						}
						
						if(tipo==BuscarPor.PUESTO && auxiliar[2].equalsIgnoreCase((String)valor))
						{
							
							respuesta[j]=auxiliar[0] + "|" + auxiliar[1] + "|" + auxiliar[2] + "|" + auxiliar[3] + "|" + auxiliar[4] + "|" + auxiliar[5] + "|" + auxiliar[6] + "|" + auxiliar[7] + "|" + auxiliar[8] + "|" + auxiliar[9] + "|" + auxiliar[10];
							j++;
							
						}
						
						if(tipo==BuscarPor.GENERO && auxiliar[7].equalsIgnoreCase((String)valor))
						{
							
							respuesta[j]=auxiliar[0] + "|" + auxiliar[1] + "|" + auxiliar[2] + "|" + auxiliar[3] + "|" + auxiliar[4] + "|" + auxiliar[5] + "|" + auxiliar[6] + "|" + auxiliar[7] + "|" + auxiliar[8] + "|" + auxiliar[9] + "|" + auxiliar[10];
							j++;
							
						}
						
						if(tipo==BuscarPor.ESTATUS && auxiliar[8].equalsIgnoreCase((String)valor))
						{
							
							respuesta[j]=auxiliar[0] + "|" + auxiliar[1] + "|" + auxiliar[2] + "|" + auxiliar[3] + "|" + auxiliar[4] + "|" + auxiliar[5] + "|" + auxiliar[6] + "|" + auxiliar[7] + "|" + auxiliar[8] + "|" + auxiliar[9] + "|" + auxiliar[10];
							j++;
							
						}
						
					}
					
				}
				archivoLectura.close();
				
			}catch(IOException ex) {
				
				throw new RuntimeException("Error al intentar leer el archivo.");
				
			}
			
		}
		
		return respuesta;
	}
	
	public boolean agregarDeduccion(Deducciones datos) {
		boolean respuesta=false;
		
		try {
			
			FileWriter archivo=new FileWriter("lista_deducciones.txt",true);
			
			archivo.write(String.valueOf(datos.getIdDeduccion()) + "|" + String.valueOf(datos.getIdEmpleado()) + "|" + datos.getFecha().toString() + "|" + datos.getTipoDeduccion().getNombreDeduccion()+ "|"  + datos.getTipoDeduccion().getPorcentajeDeLaDeduccion()+ "\n");
			
			archivo.close();
			respuesta=true;
			
		}catch(IOException ex) {
			
			System.out.println("No se ha encontrado el archivo.");
			
		}
		
		return respuesta;
	}
	

	public String[] buscarDeduccion(BuscarPor tipo, Object valor) {
		String[] respuesta=null;
		int contador=0;
		
		try {
			
			FileReader archivoLectura=new FileReader("lista_deducciones.txt", Charset.forName("UTF8"));
			BufferedReader memoria=new BufferedReader(archivoLectura);
			
			String linea="";
			while(linea!=null) {
				
				linea=memoria.readLine();
				if(linea!=null)
				{
					
					String[] auxiliar =linea.split("\\|");
					if(tipo==BuscarPor.ID && Integer.parseInt(auxiliar[1])==(Integer)valor)
					{
						
						contador++;
						
					}
					
				}
				
			}
			archivoLectura.close();
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		//----------------------------------------------------------------------
		
		if(contador>0)
		{
			
			respuesta=new String[contador];
			int j=0;
			
			try {
				
				FileReader archivoLectura=new FileReader("lista_deducciones.txt", Charset.forName("UTF8"));
				BufferedReader memoria=new BufferedReader(archivoLectura);
				
				String linea="";
				while(linea!=null) {
					
					linea=memoria.readLine();
					if(linea!=null)
					{
						
						String[] auxiliar=linea.split("\\|");
						if(tipo==BuscarPor.ID && Integer.parseInt(auxiliar[1])==(Integer)valor)
						{
							
							respuesta[j]=auxiliar[0] + "|" + auxiliar[1] + "|" + auxiliar[2] + "|" + auxiliar[3] + "|" + auxiliar[4] + "\n";
							j++;
							
						}
						
					}
					
				}
				archivoLectura.close();
				
			}catch(IOException ex) {
				
				throw new RuntimeException("Error al intentar leer el archivo.");
				
			}
			
		}
		
		return respuesta;
	}
	
	public boolean eliminarUnaDeduccion(int idDeduccion) {
		boolean respuesta=false;
		
		try {
			
			if(creaArchivoAuxiliar()==true)
			{
				FileReader archivoLectura=new FileReader("lista_deducciones.txt", Charset.forName("UTF8"));
				BufferedReader memoriaLectura=new BufferedReader(archivoLectura);
				
				FileWriter archivoAuxiliar=new FileWriter("archivo_auxiliar.txt",true);
				BufferedWriter memoriaEscritura=new BufferedWriter(archivoAuxiliar);

				String linea="";
				while((linea=memoriaLectura.readLine())!=null) {


					String[] auxiliar = linea.split("\\|");
					if(auxiliar.length>0 && !(auxiliar[0].equalsIgnoreCase(String.valueOf(idDeduccion))))
					{

						memoriaEscritura.write(linea);
						memoriaEscritura.newLine();

					}
					
				}
				memoriaLectura.close();
				memoriaEscritura.close();
				
				File original = new File("lista_deducciones.txt");
				File reemplazo = new File("archivo_auxiliar.txt");
				
				original.delete();
				reemplazo.renameTo(original);
			}
			
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	
	public boolean eliminarDeduccionesDeEmpleado(int idEmpleado) {
		boolean respuesta=false;
		
		try {
			
			if(creaArchivoAuxiliar()==true)
			{
				FileReader archivoLectura=new FileReader("lista_deducciones.txt", Charset.forName("UTF8"));
				BufferedReader memoriaLectura=new BufferedReader(archivoLectura);
				
				FileWriter archivoAuxiliar=new FileWriter("archivo_auxiliar.txt",true);
				BufferedWriter memoriaEscritura=new BufferedWriter(archivoAuxiliar);

				String linea="";
				while((linea=memoriaLectura.readLine())!=null) {


					String[] auxiliar = linea.split("\\|");
					if(auxiliar.length>0 && !(auxiliar[1].equalsIgnoreCase(String.valueOf(idEmpleado))))
					{

						memoriaEscritura.write(linea);
						memoriaEscritura.newLine();

					}
					
				}
				memoriaLectura.close();
				memoriaEscritura.close();
				
				File original = new File("lista_deducciones.txt");
				File reemplazo = new File("archivo_auxiliar.txt");
				
				original.delete();
				reemplazo.renameTo(original);
			}
			
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	
	public boolean editarDeduccion(int idDeduccion, Deduccion dato) {
		boolean respuesta=false;
		
		try {
			
			if(creaArchivoAuxiliar()==true)
			{
				FileReader archivoLectura=new FileReader("lista_deducciones.txt", Charset.forName("UTF8"));
				BufferedReader memoriaLectura=new BufferedReader(archivoLectura);
				
				FileWriter archivoAuxiliar=new FileWriter("archivo_auxiliar.txt",true);
				BufferedWriter memoriaEscritura=new BufferedWriter(archivoAuxiliar);

				String linea="";
				while((linea=memoriaLectura.readLine())!=null) {


					String[] auxiliar = linea.split("\\|");
					if(auxiliar.length>0 && auxiliar[0].equalsIgnoreCase(String.valueOf(idDeduccion)))
					{

						auxiliar[3]=String.valueOf(dato.getNombreDeduccion());
						auxiliar[4]=String.valueOf(dato.getPorcentajeDeLaDeduccion());
						String LineaModificada = String.join("|", auxiliar);
						memoriaEscritura.write(LineaModificada);
						memoriaEscritura.newLine();

					}else {
						
						memoriaEscritura.write(linea);
						memoriaEscritura.newLine();
						
					}

				}
				memoriaLectura.close();
				memoriaEscritura.close();
				
				File original = new File("lista_deducciones.txt");
				File reemplazo = new File("archivo_auxiliar.txt");
				
				original.delete();
				reemplazo.renameTo(original);
			}
			
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	
	public boolean agregarPercepcion(Percepciones datos) {
		boolean respuesta=false;
		
		try {
			
			FileWriter archivo=new FileWriter("lista_percepciones.txt",true);
			
			archivo.write(String.valueOf(datos.getIdPercepcion()) + "|" + String.valueOf(datos.getIdEmpleado()) + "|" + datos.getFecha().toString() + "|" + datos.getTipoPercepcion().getNombrePercepcion()+ "|"  + datos.getTipoPercepcion().getPorcentajeDeLaPercepcion()+ "\n");
			
			archivo.close();
			respuesta=true;
			
		}catch(IOException ex) {
			
			System.out.println("No se ha encontrado el archivo.");
			
		}
		
		return respuesta;
	}
	
	public String[] buscarPercepcion(BuscarPor tipo, Object valor) {
		String[] respuesta=null;
		int contador=0;
		
		try {
			
			FileReader archivoLectura=new FileReader("lista_percepciones.txt", Charset.forName("UTF8"));
			BufferedReader memoria=new BufferedReader(archivoLectura);
			
			String linea="";
			while(linea!=null) {
				
				linea=memoria.readLine();
				if(linea!=null)
				{
					
					String[] auxiliar =linea.split("\\|");
					if(tipo==BuscarPor.ID && Integer.parseInt(auxiliar[1])==(Integer)valor)
					{
						
						contador++;
						
					}
					
				}
				
			}
			archivoLectura.close();
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		//----------------------------------------------------------------------
		
		if(contador>0)
		{
			
			respuesta=new String[contador];
			int j=0;
			
			try {
				
				FileReader archivoLectura=new FileReader("lista_percepciones.txt", Charset.forName("UTF8"));
				BufferedReader memoria=new BufferedReader(archivoLectura);
				
				String linea="";
				while(linea!=null) {
					
					linea=memoria.readLine();
					if(linea!=null)
					{
						
						String[] auxiliar=linea.split("\\|");
						if(tipo==BuscarPor.ID && Integer.parseInt(auxiliar[1])==(Integer)valor)
						{
							
							respuesta[j]=auxiliar[0] + "|" + auxiliar[1] + "|" + auxiliar[2] + "|" + auxiliar[3] + "|" + auxiliar[4] + "\n";
							j++;
							
						}
						
					}
					
				}
				archivoLectura.close();
				
			}catch(IOException ex) {
				
				throw new RuntimeException("Error al intentar leer el archivo.");
				
			}
			
		}
		
		return respuesta;
	}
	
	public boolean eliminarUnaPercepcion(int idPercepcion) {
		boolean respuesta=false;
		
		try {
			
			if(creaArchivoAuxiliar()==true)
			{
				FileReader archivoLectura=new FileReader("lista_percepciones.txt", Charset.forName("UTF8"));
				BufferedReader memoriaLectura=new BufferedReader(archivoLectura);
				
				FileWriter archivoAuxiliar=new FileWriter("archivo_auxiliar.txt",true);
				BufferedWriter memoriaEscritura=new BufferedWriter(archivoAuxiliar);

				String linea="";
				while((linea=memoriaLectura.readLine())!=null) {


					String[] auxiliar = linea.split("\\|");
					if(auxiliar.length>0 && !(auxiliar[0].equalsIgnoreCase(String.valueOf(idPercepcion))))
					{

						memoriaEscritura.write(linea);
						memoriaEscritura.newLine();

					}
					
				}
				memoriaLectura.close();
				memoriaEscritura.close();
				
				File original = new File("lista_percepciones.txt");
				File reemplazo = new File("archivo_auxiliar.txt");
				
				original.delete();
				reemplazo.renameTo(original);
			}
			
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	
	public boolean eliminarPercepcionesDeEmpleado(int idEmpleado) {
		boolean respuesta=false;
		
		try {
			
			if(creaArchivoAuxiliar()==true)
			{
				FileReader archivoLectura=new FileReader("lista_percepciones.txt", Charset.forName("UTF8"));
				BufferedReader memoriaLectura=new BufferedReader(archivoLectura);
				
				FileWriter archivoAuxiliar=new FileWriter("archivo_auxiliar.txt",true);
				BufferedWriter memoriaEscritura=new BufferedWriter(archivoAuxiliar);

				String linea="";
				while((linea=memoriaLectura.readLine())!=null) {


					String[] auxiliar = linea.split("\\|");
					if(auxiliar.length>0 && !auxiliar[1].equalsIgnoreCase(String.valueOf(idEmpleado)))
					{

						memoriaEscritura.write(linea);
						memoriaEscritura.newLine();

					}
					
				}
				memoriaLectura.close();
				memoriaEscritura.close();
				
				File original = new File("lista_percepciones.txt");
				File reemplazo = new File("archivo_auxiliar.txt");
				
				original.delete();
				reemplazo.renameTo(original);
			}
			
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	
	public boolean editarPercepcion(int idPercepcion, Percepcion dato) {
		boolean respuesta=false;
		
		try {
			
			if(creaArchivoAuxiliar()==true)
			{
				FileReader archivoLectura=new FileReader("lista_percepciones.txt", Charset.forName("UTF8"));
				BufferedReader memoriaLectura=new BufferedReader(archivoLectura);
				
				FileWriter archivoAuxiliar=new FileWriter("archivo_auxiliar.txt",true);
				BufferedWriter memoriaEscritura=new BufferedWriter(archivoAuxiliar);

				String linea="";
				while((linea=memoriaLectura.readLine())!=null) {


					String[] auxiliar = linea.split("\\|");
					if(auxiliar.length>0 && auxiliar[0].equalsIgnoreCase(String.valueOf(idPercepcion)))
					{
						auxiliar[3]=String.valueOf(dato.getNombrePercepcion());
						auxiliar[4]=String.valueOf(dato.getPorcentajeDeLaPercepcion());
						String LineaModificada = String.join("|", auxiliar);
						memoriaEscritura.write(LineaModificada);
						memoriaEscritura.newLine();

					}else {
						
						memoriaEscritura.write(linea);
						memoriaEscritura.newLine();
						
					}

				}
				memoriaLectura.close();
				memoriaEscritura.close();
				
				File original = new File("lista_percepciones.txt");
				File reemplazo = new File("archivo_auxiliar.txt");
				
				original.delete();
				reemplazo.renameTo(original);
			}
			
			
		}catch(IOException ex) {
			
			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}
		
		return respuesta;
	}
	
	public String mostrar(String[] arreglo, int opcion) {
		String respuesta="";
		
		switch(opcion) {
		
			case 1:
				respuesta=Constantes.CABECERA_EMPLEADO;
		
				if (arreglo!=null)
				{
					
					for(int i=0; i<arreglo.length;i++) {
						
						respuesta+=arreglo[i]+"\n";
						
					}
					
				}
				break;
				
			case 2:
				respuesta=Constantes.CABECERA_DEDUCCIONES;
				
				if (arreglo!=null)
				{
					
					for(int i=0; i<arreglo.length;i++) {
						
						respuesta+=arreglo[i]+"\n";
						
					}
					
				}
				break;
				
			case 3:
				respuesta=Constantes.CABECERA_PERCEPCIONES;

				if (arreglo!=null)
				{

					for(int i=0; i<arreglo.length;i++) {

						respuesta+=arreglo[i]+"\n";

					}

				}
				break;
				
			case 4:
				respuesta=Constantes.CABECERA_NOMINA;

				if (arreglo!=null)
				{

					for(int i=0; i<arreglo.length;i++) {

						respuesta+=arreglo[i]+"\n";

					}

				}
				break;
		}
		
		return respuesta;
	}
	
	public int numeroDeAsistencias(int idEmpleado) {
		int respuesta=0;

		try {

			FileReader archivoLectura=new FileReader("lista_de_asistencias.txt", Charset.forName("UTF8"));
			BufferedReader memoria=new BufferedReader(archivoLectura);

			String linea="";
			while(linea!=null) {

				linea=memoria.readLine();
				if(linea!=null)
				{

					String[] auxiliar =linea.split("\\|");
					if(Integer.parseInt(auxiliar[1])==idEmpleado)
					{

						respuesta++;

					}
				}
			}
			archivoLectura.close();
			
		}catch(IOException ex) {

			throw new RuntimeException("Error al intentar leer el archivo.");
			
		}


		return respuesta;
	}
	
public float operacionesPercepciones(int idEmpleado) {
		
		String[] percepcionesPorEmpleado=buscarPercepcion(BuscarPor.ID, idEmpleado);
		String[] empleadoCompleto=buscarEnListaEmpleados(BuscarPor.ID,idEmpleado);
		int contadorAsistencias=numeroDeAsistencias(idEmpleado);
		float total=0;
		float auxiliar;
		
		if(percepcionesPorEmpleado!=null)
		{
			for(int i=0;i<percepcionesPorEmpleado.length;i++) {

				String[] percepcion=percepcionesPorEmpleado[i].split("\\|");
				String[] empleado=empleadoCompleto[0].split("\\|");
				auxiliar=(Float.parseFloat(percepcion[4])*(contadorAsistencias*Float.parseFloat(empleado[3])))/100;
				total+=auxiliar;

			}

		}
		
		
		return total;
	}
	
	public float operacionesDeducciones(int idEmpleado) {

		String[] deduccionesPorEmpleado=buscarDeduccion(BuscarPor.ID, idEmpleado);
		String[] empleadoCompleto=buscarEnListaEmpleados(BuscarPor.ID,idEmpleado);
		int contadorAsistencias=numeroDeAsistencias(idEmpleado);
		float total=0;
		float auxiliar;
		
		for(int i=0;i<deduccionesPorEmpleado.length;i++) {
			String[] deduccion=deduccionesPorEmpleado[i].split("\\|");
			String[] empleado=empleadoCompleto[0].split("\\|");
			auxiliar=(Float.parseFloat(deduccion[4])*(contadorAsistencias*Float.parseFloat(empleado[3])))/100;
			total+=auxiliar;
		}
		
		
		return total;
	}

	public float totalSalario(int idEmpleado) {

		String[] empleadoCompleto=buscarEnListaEmpleados(BuscarPor.ID,idEmpleado);
		int contadorAsistencias=numeroDeAsistencias(idEmpleado);
		float total=0,  salarioMensual=0;

		String[] empleado=empleadoCompleto[0].split("\\|");
		salarioMensual=(contadorAsistencias*Float.parseFloat(empleado[3]));
		salarioMensual=salarioMensual+operacionesPercepciones(idEmpleado);
		total=salarioMensual-operacionesDeducciones(idEmpleado);

		return total;

	}
	
	public boolean mostrarNominaPorEmpleado(int idEmpleado) {
		boolean respuesta=false;
		String nombreEmpleado=null;
		String nombreInicial="nombre.txt";

		try {

			FileReader archivoLectura=new FileReader("lista_empleados.txt", Charset.forName("UTF8"));
			BufferedReader memoria=new BufferedReader(archivoLectura);

			String linea="";
			while(linea!=null) {

				linea=memoria.readLine();
				if(linea!=null)
				{

					String[] auxiliar =linea.split("\\|");
					if(Integer.parseInt(auxiliar[0])==idEmpleado)
					{
						nombreEmpleado=auxiliar[1];

					}

				}

			}
			archivoLectura.close();

		}catch(IOException ex) {

			throw new RuntimeException("Error al intentar leer el archivo.");

		}

		//-------------------------------------


		if(nombreEmpleado!=null)
		{
			String nombreArchivo=nombreInicial.replace("nombre", nombreEmpleado);
			File nomina=new File(nombreArchivo);

			if(!nomina.exists())
			{

				try {

					nomina.createNewFile();

				} catch (IOException e) {

					throw new RuntimeException("Error al intentar crear el archivo "+ nombreArchivo);

				}

			}

			try {

				FileWriter archivo=new FileWriter(nombreArchivo,true);

				archivo.write(String.valueOf(Constantes.CABECERA_NOMINA + String.valueOf(idEmpleado) + "|" + LocalDate.now().toString() + "|" + String.valueOf(numeroDeAsistencias(idEmpleado)>=30?0:31-numeroDeAsistencias(idEmpleado)) + "|" + operacionesPercepciones(idEmpleado) + "|" + operacionesDeducciones(idEmpleado) + "|"+ String.valueOf(totalSalario(idEmpleado)) + "\n"));

				archivo.close();
				respuesta=true;

			}catch(IOException ex) {

				System.out.println("No se ha encontrado el archivo.");

			}

		}


		return respuesta;
	}

	public String mostrarNominaPorEmpleadoEnConsola(int idEmpleado) {
		String respuesta="";
		String nombreEmpleado=null;
		

		try {

			FileReader archivoLectura=new FileReader("lista_empleados.txt", Charset.forName("UTF8"));
			BufferedReader memoria=new BufferedReader(archivoLectura);

			String linea="";
			while(linea!=null) {

				linea=memoria.readLine();
				if(linea!=null)
				{

					String[] auxiliar =linea.split("\\|");
					if(Integer.parseInt(auxiliar[0])==idEmpleado)
					{
						nombreEmpleado=auxiliar[1];

					}

				}

			}
			archivoLectura.close();

		}catch(IOException ex) {

			throw new RuntimeException("Error al intentar leer el archivo.");

		}

		//-------------------------------------


		respuesta=(Constantes.CABECERA_NOMINA + String.valueOf(idEmpleado) + "|" + LocalDate.now().toString() + "|" + String.valueOf(numeroDeAsistencias(idEmpleado)>=30?0:31-numeroDeAsistencias(idEmpleado)) + "|" + operacionesPercepciones(idEmpleado) + "|" + operacionesDeducciones(idEmpleado) + "|"+ String.valueOf(totalSalario(idEmpleado)) + "\n");


		return respuesta;
	}
}
