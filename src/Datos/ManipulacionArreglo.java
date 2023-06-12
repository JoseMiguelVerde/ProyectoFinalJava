package Datos;

import Entidades.Empleado;
import Entidades.Gerente;
import Entidades.Percepciones;
import Utilidades.Constantes.BuscarPor;
import Utilidades.Constantes.Estatus;
import Utilidades.Constantes.Generos;
import Utilidades.Constantes.Puesto;

import java.time.LocalDateTime;
import java.time.LocalDate;

import Entidades.Deducciones;
import Entidades.Nomina;
public class ManipulacionArreglo {
	
	private Empleado[] listaEmpleados=new Empleado[10];
	private Percepciones[] listaPercepciones=new Percepciones[8];
	private Deducciones[] listaDeducciones=new Deducciones[8];
	private Nomina[] arregloNomina=new Nomina[10];
	
	private int buscaEspacio(int arreglo) {
		int indice=-1;
		//1 es lista empleados
		if(arreglo==1) {
			for(int i=0;i<listaEmpleados.length;i++) {
				if(listaEmpleados[i]==null)
				{
					indice=i;
					break;
				}
			}
		}
		//2 es lista Percepciones
		if(arreglo==2) {
			for(int i=0;i<listaPercepciones.length;i++) {
				if(listaPercepciones[i]==null)
				{
					indice=i;
					break;
				}
			}
		}
		//3 es lista deducciones
		if(arreglo==3) {
			for(int i=0;i<listaDeducciones.length;i++) {
				if(listaDeducciones[i]==null)
				{
					indice=i;
					break;
				}
			}
		}
		//4 es nomina
		if(arreglo==4) {
			for(int i=0;i<arregloNomina.length;i++) {
				if(arregloNomina[i]==null)
				{
					indice=i;
					break;
				}
			}
		}
		
		return indice;
	}
	private boolean estaVacio(int arreglo) {
		boolean respuesta=true;
		//1 es lista empleados
		if(arreglo==1) {
			for(int i=0;i<listaEmpleados.length;i++) {
				if(listaEmpleados[i]!=null)
				{
					respuesta=false;
					break;
				}
			}
		}
		//2 es lista Percepciones
		if(arreglo==2) {
			for(int i=0;i<listaPercepciones.length;i++) {
				if(listaPercepciones[i]!=null)
				{
					respuesta=false;
					break;
				}
			}
		}
		//3 es lista deducciones
		if(arreglo==3) {
			for(int i=0;i<listaDeducciones.length;i++) {
				if(listaDeducciones[i]!=null)
				{
					respuesta=false;
					break;
				}
			}
		}
		//4 es nomina
		if(arreglo==4) {
			for(int i=0;i<arregloNomina.length;i++) {
				if(arregloNomina[i]!=null)
				{
					respuesta=false;
					break;
				}
			}
		}
		
		return respuesta;
	}
	
	public int dameIdEmpleados() {
		int indice=0, id=0;
		for(int i=0;i<listaEmpleados.length;i++) {
			if(listaEmpleados[i]!=null)
			{
				if(listaEmpleados[i].getId()>indice)
				{
					indice=listaEmpleados[i].getId();
				}			
			}
		}
		id=indice+1;
		return id;
	}
	
	public int dameIdPercepcion() {
		int indice=0, id=0;
		for(int i=0;i<listaPercepciones.length;i++) {
			if(listaPercepciones[i]!=null)
			{
				if(listaPercepciones[i].getIdPercepcion()>indice)
				{
					indice=listaPercepciones[i].getIdPercepcion();
				}			
			}
		}
		id=indice+1;
		return id;
	}
	
	public int dameIdDeducciones() {
		int indice=0, id=0;
		for(int i=0;i<listaDeducciones.length;i++) {
			if(listaDeducciones[i]!=null)
			{
				if(listaDeducciones[i].getIdDeduccion()>indice)
				{
					indice=listaDeducciones[i].getIdDeduccion();
				}			
			}
		}
		id=indice+1;
		return id;
	}
	
	public int dameIdNomina() {
		int indice=0, id=0;
		for(int i=0;i<arregloNomina.length;i++) {
			if(arregloNomina[i]!=null)
			{
				if(arregloNomina[i].getIdNomina()>indice)
				{
					
					indice=arregloNomina[i].getIdNomina();
					
				}			
			}
		}
		id=indice+1;
		return id;
	}
	
	public boolean guardaEmpleado(Empleado datos) {
		boolean respuesta=false;
		int indice=buscaEspacio(1);
		if(indice!=-1)
		{	
			listaEmpleados[indice]=datos;
			respuesta=true;
			
		}
		return respuesta;
	}
	
	public boolean bajaEmpleadoPorIdFisica(int idEmpleado) {
		boolean respuesta=false;

		for (int i=0;i<listaEmpleados.length;i++) {
			if(listaEmpleados[i]!=null)
			{
				if(listaEmpleados[i].getId()==idEmpleado)
				{
					respuesta=true;
					for (int j=0;j<listaPercepciones.length;j++) {
						if(listaPercepciones[j]!=null)
						{
							if(listaPercepciones[j].getIdEmpleado()==listaEmpleados[i].getId())
							{
								listaPercepciones[j]=null;
								break;
							}
						}
					}
					for (int k=0;k<listaDeducciones.length;k++) {
						if(listaDeducciones[k]!=null)
						{
							if(listaDeducciones[k].getIdEmpleado()==listaEmpleados[i].getId())
							{
								listaDeducciones[k]=null;
								break;
							}
						}
					}
					if(respuesta==false) {
						break;
					}else {
						if(respuesta==true) {
							listaEmpleados[i]=null;
							break;
						}
					}

				}
			}
		}
		return respuesta;
	}
	
	public boolean bajaEmpleadoPorIdLogica(int idEmpleado) {
		boolean respuesta=false;
		
		for (int i=0;i<listaEmpleados.length;i++) {
			if(listaEmpleados[i]!=null)
			{
				if(listaEmpleados[i].getId()==idEmpleado)
				{
					respuesta=true;
					listaEmpleados[i].setEstatus(Estatus.BAJA);
					break;
				}
			}
		}
		
		return respuesta;
	}
	
	public boolean modificarPorIdEmpleado(int idEmpleado, String empleadoEditado, int datoAEditar) {
		boolean respuesta=false;
		
		for (int i=0;i<listaEmpleados.length;i++) {
			if(listaEmpleados[i]!=null)
			{
				if(listaEmpleados[i].getId()==idEmpleado)
				{
					switch(datoAEditar) {

						case 1://nombreCompleto
							listaEmpleados[i].setNombreCompleto(String.valueOf(empleadoEditado));
							respuesta=true;
							break;
	
						case 2://puesto
							listaEmpleados[i].setPuesto(Puesto.valueOf(empleadoEditado));
							respuesta=true;
							break;
	
						case 3://rfc
							listaEmpleados[i].setRfc(empleadoEditado);
							respuesta=true;
							break;
	
						case 4://curp
							listaEmpleados[i].setCurp(empleadoEditado);
							respuesta=true;
							break;
	
						case 5://direccion
							listaEmpleados[i].setDireccion(empleadoEditado);
							respuesta=true;
							break;
	
						case 6://genero
							listaEmpleados[i].setGenero(Generos.valueOf(empleadoEditado));
							respuesta=true;
							break;
	
						case 7://fechaNacimiento
							listaEmpleados[i].setFechaNacimiento(LocalDate.parse(empleadoEditado));
							respuesta=true;
							break;

					}
					break;
				}
			}
		}
		
		
		
		return respuesta;
	}
	private Empleado[] buscarEnListaEmpleados(BuscarPor tipo, Object valor){

		Empleado[] respuesta=null;
		int contador=0;
		//contar coincidencias
		for(int i=0;i<listaEmpleados.length;i++) {
			if(listaEmpleados[i]!=null)
			{
				if(tipo==BuscarPor.ID)
				{
					if(listaEmpleados[i].getId()==(Integer)valor)
					{
						contador++;
					}
				}

				if(tipo==BuscarPor.NOMBRE)
				{
					if(listaEmpleados[i].getNombreCompleto().equalsIgnoreCase((String)valor))
					{
						contador++;
					}
				}
				if(tipo==BuscarPor.PUESTO)
				{
					if(listaEmpleados[i].getPuesto()==(Puesto)valor)
					{
						contador++;
					}
				}
				if(tipo==BuscarPor.ESTATUS)
				{
					if(listaEmpleados[i].getEstatus()==(Estatus)valor)
					{
						contador++;
					}
				}
				
			}
		}
		//-----
		if(contador>0)
		{
			respuesta=new Empleado[contador];
			int j=0;
			for(int i=0;i<listaEmpleados.length;i++) {
				if(listaEmpleados[i]!=null)
				{
					if(tipo==BuscarPor.ID)
					{
						if(listaEmpleados[i].getId()==(Integer)valor)
						{
							respuesta[j]=listaEmpleados[i];
							j++;
						}
					}

					if(tipo==BuscarPor.NOMBRE)
					{
						if(listaEmpleados[i].getNombreCompleto().equalsIgnoreCase((String)valor))
						{
							respuesta[j]=listaEmpleados[i];
							j++;
						}
					}
					if(tipo==BuscarPor.PUESTO)
					{
						if(listaEmpleados[i].getPuesto()==(Puesto)valor)
						{
							respuesta[j]=listaEmpleados[i];
							j++;
						}
					}
					if(tipo==BuscarPor.ESTATUS)
					{
						if(listaEmpleados[i].getEstatus()==(Estatus)valor)
						{
							respuesta[j]=listaEmpleados[i];
							j++;
						}
					}
					
				}
			}
		}
		
		
		return respuesta;
	}
	private Percepciones[] buscarEnListaPercepciones(BuscarPor tipo, Object valor){

		Percepciones[] respuesta=null;
		int contador=0;
		//contar coincidencias
		for(int i=0;i<listaPercepciones.length;i++) {
			if(listaPercepciones[i]!=null)
			{
				
				if(tipo==BuscarPor.ID_PERCEPCION)
				{
					if(listaPercepciones[i].getIdPercepcion()==(int)valor)
					{
						contador++;
					}
				}
				if(tipo==BuscarPor.PERCEPCION_ID_EMPLEADO)
				{
					if(listaPercepciones[i].getIdEmpleado()==(int)valor)
					{
						contador++;
					}
				}
				
			}
		}
		//-----
		if(contador>0)
		{
			respuesta=new Percepciones[contador];
			int j=0;
			for(int i=0;i<listaPercepciones.length;i++) {
				if(listaPercepciones[i]!=null)
				{
					
					if(tipo==BuscarPor.ID_PERCEPCION)
					{
						if(listaPercepciones[i].getIdPercepcion()==(int)valor)
						{
							respuesta[j]=listaPercepciones[i];
							j++;
						}
					}
					if(tipo==BuscarPor.PERCEPCION_ID_EMPLEADO)
					{
						if(listaPercepciones[i].getIdEmpleado()==(int)valor)
						{
							respuesta[j]=listaPercepciones[i];
							j++;
						}
					}
				}
			}
		}
		
		
		return respuesta;
	}
	private Deducciones[] buscarEnListaDeducciones(BuscarPor tipo, Object valor){

		Deducciones[] respuesta=null;
		int contador=0;
		//contar coincidencias
		for(int i=0;i<listaDeducciones.length;i++) {
			if(listaDeducciones[i]!=null)
			{
				
				if(tipo==BuscarPor.ID_DEDUCCION)
				{
					if(listaDeducciones[i].getIdDeduccion()==(int)valor)
					{
						contador++;
					}
				}
				if(tipo==BuscarPor.DEDUCCION_ID_EMPLEADO)
				{
					if(listaDeducciones[i].getIdEmpleado()==(int)valor)
					{
						contador++;
					}
				}
				
			}
		}
		//-----
		if(contador>0)
		{
			respuesta=new Deducciones[contador];
			int j=0;
			for(int i=0;i<listaDeducciones.length;i++) {
				if(listaDeducciones[i]!=null)
				{
					
					if(tipo==BuscarPor.ID_DEDUCCION)
					{
						if(listaDeducciones[i].getIdDeduccion()==(int)valor)
						{
							respuesta[j]=listaDeducciones[i];
							j++;
						}
					}
					if(tipo==BuscarPor.DEDUCCION_ID_EMPLEADO)
					{
						if(listaDeducciones[i].getIdEmpleado()==(int)valor)
						{
							respuesta[j]=listaDeducciones[i];
							j++;
						}
					}
				}
			}
		}
		
		
		return respuesta;
	}
	private Nomina[] buscarEnListaNomina(BuscarPor tipo, Object valor){

		Nomina[] respuesta=null;
		int contador=0;
		//contar coincidencias
		for(int i=0;i<arregloNomina.length;i++) {
			if(arregloNomina[i]!=null)
			{
				
				if(tipo==BuscarPor.ID_NOMINA)
				{
					if(arregloNomina[i].getIdNomina()==(int)valor)
					{
						contador++;
					}
				}
				if(tipo==BuscarPor.NOMINA_ID_EMPLEADO)
				{
					if(arregloNomina[i].getIdEmpleado()==(int)valor)
					{
						contador++;
					}
				}
			}
		}
		//-----
		if(contador>0)
		{
			respuesta=new Nomina[contador];
			int j=0;
			for(int i=0;i<arregloNomina.length;i++) {
				if(arregloNomina[i]!=null)
				{
					
					if(tipo==BuscarPor.ID_NOMINA)
					{
						if(arregloNomina[i].getIdNomina()==(int)valor)
						{
							respuesta[j]=arregloNomina[i];
							j++;
						}
					}
					if(tipo==BuscarPor.NOMINA_ID_EMPLEADO)
					{
						if(arregloNomina[i].getIdEmpleado()==(int)valor)
						{
							respuesta[j]=arregloNomina[i];
							j++;
						}
					}
					
				}
			}
		}	
		return respuesta;
	}
	public boolean guardaDeduccion(Deducciones datos) {
		boolean respuesta=false;
		int indice=buscaEspacio(3);
		if(indice!=-1)
		{	
			listaDeducciones[indice]=datos;
			respuesta=true;
			
		}
		return respuesta;
	}
	public boolean guardaPercepcion(Percepciones datos) {
		boolean respuesta=false;
		int indice=buscaEspacio(2);
		if(indice!=-1)
		{	
			listaPercepciones[indice]=datos;
			respuesta=true;
			
		}
		return respuesta;
	}
}