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
	
	public enum Bonos{
		PUNTUALIDAD(0,"Puntualidad",400f),EFICIENCIA(1,"Eficiencia",600f),COMISION_VENTA(2,"Comisión",500f);
		private int idBono;
		private String nombreBono;
		private float costoBono;
		
		private Bonos(int idBono,String nombreBono,float costoBono)
		{
			this.idBono=idBono;
			this.nombreBono=nombreBono;
			this.costoBono=costoBono;
		}

		public int getIdBono() {
			return idBono;
		}

		public String getNombreBono() {
			return nombreBono;
		}

		public float getCostoBono() {
			return costoBono;
		}
		
	}
}
