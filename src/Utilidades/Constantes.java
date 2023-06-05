package Utilidades;

import java.time.format.DateTimeFormatter;

public class Constantes {
	
	public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

	public static final String CABECERA_EMPLEADO="Id empleado\t\tNombre Completo\t\tPuesto\t\tRFC\t\tCURP\t\tDirección\t\tGénero\t\tEstatus\t\tFecha de nacimiento\t\tAntigüedad\n";
	
	public static final String CABECERA_DEDUCCIONES="Id deducción\t\tId empleado\t\tNombre de la deducción\t\tTipo de deducción\t\tCantidad fija de la deducción\t\tPorcentaje\t\tPeriodo\n";
	
	public static final String CABECERA_PERCEPCIONES="Id percepciones\t\tId empleado\t\tNombre de la percepción\t\tTipo de la percepción\t\tCantidad fija de la percepción\t\tPeriodo\n";
	
	public static final String CABECERA_NOMINA="Id Empleado\t\tId de nomina\t\tFecha de nomina\t\tFaltas\t\tTotal\t\tTotal percepción\t\tTotal deducción\n";
	
	public enum BuscarPor{ID,NOMBRE};
	
	public enum Movimientos{EDICION, INSERCION};
	
	public enum Generos{
		MASCULINO(1,"Masculino"), FEMENINO(0,"Femenino");
		
		private int idGenero;
		private String nombreGenero;
		
		
		private Generos(int idGenero, String nombreGenero) {
			this.idGenero=idGenero;
			this.nombreGenero=nombreGenero;
		}


		public int getIdGenero() {
			return idGenero;
		}


		public String getNombreGenero() {
			return nombreGenero;
		}
		
		
	}
	
	public enum Estatus{
		ACTIVO(1,"Activo"), BAJA(2,"Baja");
		
		private int idEstatus;
		private String estatus;
		
		private Estatus(int idEstatus, String estatus) 
		{
			this.idEstatus=idEstatus;
			this.estatus=estatus;
		}

		public int getIdEstatus() {
			return idEstatus;
		}

		public String getEstatus() {
			return estatus;
		}
		
		
	}
	
	public enum Puesto{
		EMPLEADO(1,"Empleado",300f),GERENTE(2,"Gerente",600f);
		
		private int idPuesto;
		private String puesto;
		private float sueldo;
		
		private Puesto(int idEmpleado, String puesto, float sueldo)
		{
			this.idPuesto=idEmpleado;
			this.puesto=puesto;
			this.sueldo=sueldo;
		}

		public int getIdPuesto() {
			return idPuesto;
		}

		public String getPuesto() {
			return puesto;
		}

		public float getSueldo() {
			return sueldo;
		}
		
		
	}
	
	public enum Tipo{
		PERCEPCION(1,"Percepción"),DEDUCCION(2,"Deducción");
		
		private int idTipo;
		private String nombreTipo;
		
		private Tipo(int idTipo, String nombreTipo) 
		{
			this.idTipo=idTipo;
			this.nombreTipo=nombreTipo;
		}

		public int getIdTipo() {
			return idTipo;
		}

		public String getNombreTipo() {
			return nombreTipo;
		}
		
		
	}
	
	public enum Percepcion{
		COMISION(0,"Comision",3),BONO(1,"Bono",5),PRIMA_VACACIONAL(2,"Prima Vacasional",25); // el 3, 5 y 25 son los porcentajes de cada percepcion
		private int idPercepcion;
		private String nombrePercepcion;
		private int porcentajeDeLaPercepcion;
		
		private Percepcion(int idPercepcion,String nombrePercepcion,int porcentajeDeLaPercepcion)
		{
			this.idPercepcion=idPercepcion;
			this.nombrePercepcion=nombrePercepcion;
			this.porcentajeDeLaPercepcion=porcentajeDeLaPercepcion;
		}

		public int getIdPercepcion() {
			return idPercepcion;
		}

		public String getNombrePercepcion() {
			return nombrePercepcion;
		}

		public float getPorcentajeDeLaPercepcion() {
			return porcentajeDeLaPercepcion;
		}
		
	}
	public enum Deduccion{
		FORMACION_PROFESIONAL(0,"Formacion Profecional",2f),CONTINGENCIA_COMUN(1,"Contingencia Comun",4f),SEGURO_MEDICO(2,"Seguro Medico",4.5f); // el 2, 4 y 4.5 son los porcentajes de cada percepcion
		private int idDeduccion;
		private String nombreDeduccion;
		private float porcentajeDeLaDeduccion;
		
		private Deduccion(int idDeduccion,String nombreDeduccion,float porcentajeDeLaDeduccion)
		{
			this.idDeduccion=idDeduccion;
			this.nombreDeduccion=nombreDeduccion;
			this.porcentajeDeLaDeduccion=porcentajeDeLaDeduccion;
		}

		public int getIdDeduccion() {
			return idDeduccion;
		}

		public String getNombreDeduccion() {
			return nombreDeduccion;
		}

		public float getPorcentajeDeLaDeduccion() {
			return porcentajeDeLaDeduccion;
		}
		
	}
}
