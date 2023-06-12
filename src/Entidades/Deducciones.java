package Entidades;
import java.time.LocalDateTime;

import Datos.Archivos;
import Utilidades.Constantes.Deduccion;
public class Deducciones {
	Archivos manipulacionArchivo= new Archivos();
	private int idEmpleado;
	private int idDeduccion;
	private LocalDateTime fecha;
	private Deduccion tipoDeduccion;
	
	
	
	public Deducciones(int idEmpleado,Deduccion tipoDeduccion)
	{
		this.idDeduccion=manipulacionArchivo.dameIdDeducciones();
		this.idEmpleado=idEmpleado;
		this.fecha=LocalDateTime.now();
		this.tipoDeduccion=tipoDeduccion;
		
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

	public Deduccion getTipoDeduccion() {
		return tipoDeduccion;
	}

	public void setTipoDeduccion(Deduccion tipoDeduccion) {
		this.tipoDeduccion = tipoDeduccion;
	}

	public int getIdDeduccion() {
		return idDeduccion;
	}

	public void setIdDeduccion(int idDeduccion) {
		this.idDeduccion = idDeduccion;
	}
}
