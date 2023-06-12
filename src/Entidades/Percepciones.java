package Entidades;
import java.time.LocalDateTime;
import Utilidades.Constantes.Percepcion;
import Datos.Archivos;
import Datos.ManipulacionArreglo;
public class Percepciones {
	Archivos manipulacionArchivo= new Archivos();
	private int idEmpleado;
	private int idPercepcion;
	private LocalDateTime fecha;
	private Percepcion tipoPercepcion;
	
	
	
	public Percepciones(int idEmpleado,Percepcion tipoPercepcion)
	{
		this.idPercepcion=manipulacionArchivo.dameIdPercepciones();
		this.idEmpleado=idEmpleado;
		this.fecha=LocalDateTime.now();
		this.tipoPercepcion=tipoPercepcion;
		
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Percepcion getTipoPercepcion() {
		return tipoPercepcion;
	}

	public void setTipoPercepcion(Percepcion tipoPercepcion) {
		this.tipoPercepcion = tipoPercepcion;
	}

	public int getIdPercepcion() {
		return idPercepcion;
	}

	public void setIdPercepcion(int idPercepcion) {
		this.idPercepcion = idPercepcion;
	}

}
