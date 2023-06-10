package Datos;

import Entidades.Empleado;
import Entidades.Gerente;
import Entidades.Percepciones;
import Utilidades.Constantes.Estatus;
import Utilidades.Constantes.Generos;
import Utilidades.Constantes.Puesto;

import java.time.LocalDateTime;

import Entidades.Deducciones;
import Entidades.Nomina;
public class ManipulacionArreglo {
	
	private Empleado[] listaEmpleados=new Empleado[10];
	private Percepciones[] listaPercepciones=new Percepciones[8];
	private Deducciones[] listaDeducciones=new Deducciones[8];
	private Nomina[] arregloNomina=new Nomina[10];
	
	private int buscaEspacio() {
		int indice=-1;
		for(int i=0;i<listaEmpleados.length;i++) {
			if(listaEmpleados[i]==null)
			{
				indice=i;
				break;
			}
		}
		return indice;
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
		int indice=buscaEspacio();
		if(indice!=-1)
		{
			/*
			 
		 	0-Id
		 	1-Puesto
		 	2-Nombre
		 	3-Genero
		 	4-Curp
		 	5-Sueldo por dia
		 	6-Fecha de contratacion
		 	7-Incentivo
		 	8-Con vehiculo
		 	
			*/
			
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
							listaEmpleados[i].setFechaNacimiento(LocalDateTime.parse(empleadoEditado));
							respuesta=true;
							break;

					}
					break;
				}
			}
		}
		
		
		
		return respuesta;
	}
	
}