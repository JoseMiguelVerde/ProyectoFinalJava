package Utilidades;

import java.time.format.DateTimeFormatter;

public class Constantes {
	//menu
	public static final String BIENVENIDO= "Consulta de Empleados\n";
	public static final String MENU_INICIAL="Selecciona una opcion:\n1)Empleados\n2)Deducciones \n3)Percepciones\n4)Generacion de recibos de nomina \n5)Salir\n";
	public static final String MENU_EMPLEADOS="Selecciona una opcion:\n1)Dar de alta\n2)Dar de Baja \n3)Modificar\n4)Consultar\n";
	public static final String MENU_DEDUCCIONES="Selecciona una opcion:\n1)Agregar\n2)Eliminar \n3)Modificar\n4)Consultar\n";
	public static final String MENU_PERCEPCIONES="Selecciona una opcion:\n1)Agregar\n2)Eliminar \n3)Modificar\n4)Consultar\n";
	public final static String ALTA_EMPLEADO="\tAlta Empleado\nFavor de ingresar los siguientes datos:\n";
	public static final String VOLVER_AL_MENU="\n¿Quiere volver al menu? \n1) Si \nsi quiere salir del programa presione cualquier tecla";
	public final static String INGRESAR_VALOR_NUMERICO="Debe ingresar un valor numerico.";
	public final static String OPCION_INVALIDA="Opcion invalida, escoga un numero de la opcion del menu";
	public final static String DESPEDIDA="Adios, gracias por utilizar el programa.";
	public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	public static final DateTimeFormatter FORMATO_FECHA_NACIMIENTO = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	//Empleado
	public static final String NOMBRE_COMPLETO="Nombre Completo:\n";
	public static final String CURP="CURP:\n";
	public static final String RFC="RFC:\n";
	public static final String DIRECCION="Direccion sin codigo Postal:\n";
	public static final String CODIGO_POSTAL="Codigo Postal:\n";
	public static final String FECHA_DE_NACIMIENTO="Fecha de Nacimiento, formato dd-MM-yyyy:\n";
	public static final String PUESTO="Puesto(elige la opcion):\n 1)Empleado\n 2)Gerente\n";
	public static final String GENERO="Genero(elige la opcion):\n 1)Masculino\n 2)Femenino\n";
	public final static String INSERTADO="Se ha dado de Alta el empleado";
	public final static String NO_INSERTADO="No se pudo dar de alta, vuelva a intentarlo";
	
	
	//equivocaciones
	public final static  String NOMBRE_EQUIVOCADO="Nombre Invalido, vuelva a intentarlo\n";
	public final static  String RFC_EQUIVOCADA="RFC Invalido, vuelva a intentarlo\n";
	public final static  String CURP_EQUIVOCADA="Curp Invalido, vuelva a intentarlo\n";
	public final static  String DIRECCION_EQUIVOCADA="Direccion Invalida, vuelva a intentarlo\n";
	public final static  String CODIGO_POSTAL_EQUIVOCADA="Direccion Invalida, vuelva a intentarlo\n";
	public final static  String UNIDADES_EQUIVOCADA=" Unidades Invalido, vuelva a intentarlo\n";

	
	//cabeceras
	public static final String CABECERA_EMPLEADO="Id empleado\t|\tNombre Completo\t|\tPuesto\t|\tSueldo Por dia\t|\tRFC\t|\tCURP\t|\tDirección\t|\tGénero\t|\tEstatus\t|\tFecha de nacimiento\t|\tFecha de contratación\n";
	public static final String CABECERA_DEDUCCIONES="Id deducción\t|\tId empleado\t|\tPeriodo\t|\tTipo de deducción\t|\tPorcentaje\n";
	public static final String CABECERA_PERCEPCIONES="Id percepcion\t|\tId empleado\t|\tPeriodo\t|\tTipo de percepcion\t|\tPorcentaje\n";
	public static final String CABECERA_NOMINA="Id Empleado\t|\tFecha de nomina\t|\tFaltas\t|\tTotal percepción\t|\tTotal deduccion\t|\tTotal\n";
	//enumeraciones
	public enum BuscarPor{ID,NOMBRE,PUESTO,GENERO,ESTATUS};
	
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
		COMISION(0,"Comision",6),BONO(1,"Bono",10),PRIMA_VACACIONAL(2,"Prima Vacasional",25); // el 6, 10 y 25 son los porcentajes de cada percepcion(mensuales)
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
		FORMACION_PROFESIONAL(0,"Formacion Profecional",4f),CONTINGENCIA_COMUN(1,"Contingencia Comun",8f),SEGURO_MEDICO(2,"Seguro Medico",9f); // el 4, 8 y 9 son los porcentajes de cada deduccion (mensuales)
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

