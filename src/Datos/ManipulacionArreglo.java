package Datos;

import Entidades.Empleado;

public class ManipulacionArreglo {
	private String[][] listaEmpleados=new String[8][7];
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
	private int dameIndice() {
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
			listaEmpleados[indice][1]=(datos instanceof Gerente?"1":"0");
			listaEmpleados[indice][2]=datos.getNombre();
			listaEmpleados[indice][3]=String.valueOf(datos.getGenero().getIdGenero());
			listaEmpleados[indice][4]=datos.getCurp();
			listaEmpleados[indice][5]=String.valueOf(datos.getSueldoDia());
			listaEmpleados[indice][6]=String.valueOf(datos.getFechaContratacion());
			listaEmpleados[indice][7]=(datos instanceof Gerente? String.valueOf(((Gerente)datos).getIncentivo()):"0.0");
			listaEmpleados[indice][8]=(datos instanceof Gerente? (((Gerente)datos).getConVehiculo()?"1":"0"):"0");
			respuesta=true;
			
		}
		return respuesta;
	}
}
