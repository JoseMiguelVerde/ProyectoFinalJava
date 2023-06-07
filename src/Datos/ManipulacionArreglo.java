package Datos;

import Entidades.Empleado;
import Entidades.Gerente;

public class ManipulacionArreglo {
	private String[][] listaEmpleados=new String[10][10];
	private String[][] listaPercepciones=new String[8][6];
	private String[][] listaDeducciones=new String[8][6];
	private String[][] arregloNomina=new String[10][7];
	
	private int buscaEspacio() {
		int indice=-1;
		for(int i=0;i<listaEmpleados.length;i++) {
			if(listaEmpleados[i][0]==null)
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
			if(listaEmpleados[i][0]!=null)
			{
				if(Integer.parseInt(listaEmpleados[i][0])>indice)
				{
					indice=Integer.parseInt(listaEmpleados[i][0]);
				}			
			}
		}
		id=indice+1;
		return id;
	}
	
	public int dameIdPercepcion() {
		int indice=0, id=0;
		for(int i=0;i<listaPercepciones.length;i++) {
			if(listaPercepciones[i][0]!=null)
			{
				if(Integer.parseInt(listaPercepciones[i][0])>indice)
				{
					indice=Integer.parseInt(listaPercepciones[i][0]);
				}			
			}
		}
		id=indice+1;
		return id;
	}
	
	public int dameIdDeducciones() {
		int indice=0, id=0;
		for(int i=0;i<listaDeducciones.length;i++) {
			if(listaDeducciones[i][0]!=null)
			{
				if(Integer.parseInt(listaDeducciones[i][0])>indice)
				{
					indice=Integer.parseInt(listaDeducciones[i][0]);
				}			
			}
		}
		id=indice+1;
		return id;
	}
	
	public int dameIdNomina() {
		int indice=0, id=0;
		for(int i=0;i<arregloNomina.length;i++) {
			if(arregloNomina[i][0]!=null)
			{
				if(Integer.parseInt(arregloNomina[i][0])>indice)
				{
					
					indice=Integer.parseInt(arregloNomina[i][0]);
					
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
			
			listaEmpleados[indice][0]=String.valueOf(datos.getId());
			listaEmpleados[indice][1]=datos.getNombreCompleto();
			listaEmpleados[indice][2]=(datos instanceof Gerente?"1":"0");
			listaEmpleados[indice][3]=datos.getRfc();
			listaEmpleados[indice][4]=datos.getCurp();
			listaEmpleados[indice][5]=datos.getDireccion();
			listaEmpleados[indice][6]=String.valueOf(datos.getGenero().getIdGenero());
			listaEmpleados[indice][7]=String.valueOf(datos.getEstatus().getEstatus());
			listaEmpleados[indice][8]=String.valueOf(datos.getFechaNacimiento());
			listaEmpleados[indice][9]=String.valueOf(datos.getFechaContratacion());
			respuesta=true;
			
		}
		return respuesta;
	}
	
	
}