package Utilidades;

import java.time.format.DateTimeFormatter;

public class Constantes {
	//menu
	public static final String BIENVENIDO= "Consulta de Empleados\n";
	public static final String MENU_INICIAL="Selecciona una opcion:\n1)Empleados\n2)Deducciones \n3)Percepciones\n4)Generacion de recibos de nomina \n5)Salir\n";
	public static final String MENU_EMPLEADOS="Selecciona una opcion:\n1)Dar de alta\n2)Dar de Baja \n3)Modificar\n4)Consultar\n";
	public static final String MENU_DEDUCCIONES="Selecciona una opcion:\n1)Agregar\n2)Eliminar \n3)Modificar\n4)Consultar\n";
	public static final String MENU_PERCEPCIONES="Selecciona una opcion:\n1)Agregar\n2)Eliminar \n3)Modificar\n4)Consultar\n";
	public static final String VOLVER_AL_MENU="\n¿Quiere volver al menu? \n1) Si \nsi quiere salir del programa presione cualquier tecla";
	public final static String INGRESAR_VALOR_NUMERICO="Debe ingresar un valor numerico y correcto.";
	public final static String OPCION_INVALIDA="Opcion invalida, escoga un numero de la opcion del menu";
	public final static String DESPEDIDA="Adios, gracias por utilizar el programa.";
	public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	public static final DateTimeFormatter FORMATO_FECHA_NACIMIENTO = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	//Empleado
	public final static String ALTA_EMPLEADO="\tAlta Empleado\nFavor de ingresar los siguientes datos:\n";
	public static final String NOMBRE_COMPLETO="Nombre Completo:\n";
	public final static String DAME_ID_EMPLEADO="Dame el id del Empleado:\n";
	public static final String CURP="CURP:\n";
	public static final String RFC="RFC:\n";
	public static final String DIRECCION="Direccion sin codigo Postal:\n";
	public static final String CODIGO_POSTAL="Codigo Postal:\n";
	public static final String FECHA_DE_NACIMIENTO="Fecha de Nacimiento, formato dd-MM-yyyy:\n";
	public static final String PUESTO="Puesto(elige la opcion):\n 1)Empleado\n 2)Gerente\n";
	public static final String GENERO="Genero(elige la opcion):\n 1)Masculino\n 2)Femenino\n";
	public static final String ESTATUS="Estatus(elige la opcion):\n 1)Activo\n 2)Baja\n";
	public final static String INSERTADO="Se ha dado de Alta el empleado";
	public final static String NO_INSERTADO="No se pudo dar de alta, vuelva a intentarlo";
	
	public final static String BAJA_EMPLEADO="\tBaja Empleado\n1)Logica(Se le cambiará el estatus a BAJA)\n2)Fisica(Se borrarán todos los datos del empleado, incluyendo percepciones y deducciones.)\n";
	public final static String ELIMINADO="Se ha dado de Baja el empleado";
	public final static String NO_ELIMINADO="No se pudo dar de Baja, vuelva a intentarlo";
	public final static String NO_HAY_DATOS="No hay datos en el archivo\n";
	
	
	
	public final static String MODIFICAR_EMPLEADO="\tModifica Empleado\n1)Nombre\n2)Puesto\n3)Rfc\n4)Curp\n 5)Direccion\n6)Codigo Postal\n7)Genero\n8)Fecha de nacimiento\n";
	public final static String EDITADO="Se ha editado el empleado";
	public final static String NO_EDITADO="No se pudo editar, vuelva a intentarlo";
	
	public final static String CONSULTAR_EMPLEADO="\tConsultar Empleado\n1)Id\n2)Nombre\n3)Puesto\n4)Genero\n 5)Estatus\n 6)Todos los Empleados\n";
	
	//Deducciones
	
	public static final String TIPOS_DEDUCCIONES="Tipos de deduccion(elige la opcion que le quieras agregar al empleado):\n 1)Formacion Profesional\n 2)Contingencia Comun\n3)Seguro Medico\n";
	public static final String AGREGAR_DEDUCCIONES="\tAgregar Deducciones\nDame el id del Empleado a agregar la deduccion:\n";
	public static final String AGREGADO="Se agrego la deduccion\n";
	public static final String NO_AGREGADO="No se pudo agregar la deduccion\n";
	public static final String ELIMINAR_DEDUCCIONES="\tEliminar\n 1)Por id de Deduccion \n 2)Todas las deducciones de un empleado\n";
	public static final String ELIMINADO_DEDUCCION="Se Elimino la deduccion\n";
	public static final String NO_ELIMINADO_DEDUCCION="No se pudo Eliminar la deduccion\n";
	public static final String EDITAR_DEDUCCIONES="\tEditar Tipo de deduccion\n Dame el id de la deduccion:\n";
	public static final String EDITADO_DEDUCCION="Se Edito la deduccion\n";
	public static final String NO_EDITADO_DEDUCCION="No se pudo Editar la deduccion\n";
	public static final String MOSTRAR_DEDUCCIONES="\tMostrar deducciones Por id de Empledo\n Dame id de empleado:";
	public final static String DAME_ID_DEDUCCIONES="Dame el id de la deduccion:\n";
	//Percepciones
	public static final String TIPOS_PERCEPCIONES="Tipos de percepcion(elige la opcion que le quieras agregar al empleado):\n 1)Comision\n 2)Bono\n3)Prima Vacacional\n";
	public static final String AGREGAR_PERCEPCIONES="\tAgregar Percepcion\nDame el id del Empleado a agregar la percepcion:\n";
	public static final String AGREGADO_PERCEPCIONES="Se agrego la Percepcion\n";
	public static final String NO_AGREGADO_PERCEPCIONES="No se pudo agregar la percepcion\n";
	public static final String ELIMINAR_PERCEPCIONES="\tEliminar\n 1)Por id de Percepcion \n 2)Todas las percepciones de un empleado\n";
	public static final String ELIMINADO_PERCEPCION="Se Elimino la percepcion\n";
	public static final String NO_ELIMINADO_PERCEPCION="No se pudo Eliminar la percepcion\n";
	public static final String EDITAR_PERCEPCIONES="\tEditar Tipo de percepcion\n Dame el id de la percepcion:\n";
	public static final String EDITADO_PERCEPCION="Se Edito la percepcion\n";
	public static final String NO_EDITADO_PERCEPCION="No se pudo Editar la percepcion\n";
	public static final String MOSTRAR_PERCEPCIONES="\tMostrar percepciones Por id de Empledo\n Dame id de empleado:";
	public final static String DAME_ID_PERCEPCIONES="Dame el id de la percepcion:\n";
	
	//Nomina
	public final static String ERROR_AL_CREAR_NOMINA="No se pudo crear el recibo de nomina.";
	//equivocaciones
	public final static  String NOMBRE_EQUIVOCADO="Nombre Invalido, vuelva a intentarlo\n";
	public final static  String RFC_EQUIVOCADA="RFC Invalido, vuelva a intentarlo\n";
	public final static  String RFC_EXISTENTE="RFC Existente, vuelva a intentarlo\n";
	public final static  String CURP_EQUIVOCADA="Curp Invalido, vuelva a intentarlo\n";
	public final static  String CURP_EXISTENTE="Curp Existente, vuelva a intentarlo\n";
	public static final String FECHA_DE_NACIMIENTO_EQUIVOCADA="Fecha de Nacimiento invalida\n";
	public final static  String DIRECCION_EQUIVOCADA="Direccion Invalida, vuelva a intentarlo\n";
	public final static  String CODIGO_POSTAL_EQUIVOCADA="Codigo Postal Invalida, vuelva a intentarlo\n";


	
	//cabeceras
	public static final String CABECERA_EMPLEADO="Id empleado\t|\tNombre Completo\t|\tPuesto\t|\tSueldo Por dia\t|\tRFC\t|\tCURP\t|\tDirección\t|\tCodigoPostal\t|\tGénero\t|\tEstatus\t|\tFecha de nacimiento\t|\tFecha de contratación\n";
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

