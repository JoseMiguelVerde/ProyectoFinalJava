package Entidades;

import java.time.LocalDateTime;
import Datos.ManipulacionArreglo;
import Utilidades.Constantes.Deduccion;

public class Nomina {
	ManipulacionArreglo manipulacion= new ManipulacionArreglo();
	private int idEmpleado;
	private int idNomina;
	private int faltas;
	private LocalDateTime fecha;
	public Nomina(int idEmpleado, int faltas)
	{
		this.idNomina=manipulacion.dameIdNomina();
		this.idEmpleado=idEmpleado;
		this.fecha=LocalDateTime.now();
		this.faltas=faltas;
	}
	
	public int getFaltas() {
		return faltas;
	}
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdNomina() {
		return idNomina;
	}
	public void setIdNomina(int idNomina) {
		this.idNomina = idNomina;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
}
