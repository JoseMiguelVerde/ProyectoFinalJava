package Entidades;

import java.time.LocalDateTime;

import Utilidades.Constantes.*;

public class Empleado {
	
	private int id;
	private String nombreCompleto, rfc, curp, direccion;
	private Puesto puesto;
	private Generos genero;
	private Estatus estatus;
	private LocalDateTime fechaContratacion, fechaNacimiento;
	private static int siguienteId=1;
	

	public Empleado(String nombreCompleto,Puesto puesto, String rfc, String curp, String direccion, Generos genero, LocalDateTime fechaNacimiento, Movimientos movimiento) {

		this.id=siguienteId;
		this.nombreCompleto=nombreCompleto;
		this.puesto=puesto;
		this.rfc=rfc;
		this.curp=curp;
		this.direccion=direccion;
		this.genero=genero;
		estatus=estatus.ACTIVO;
		this.fechaNacimiento=fechaNacimiento;
		this.fechaContratacion=LocalDateTime.now();
		if(movimiento==Movimientos.INSERCION)
		{
			siguienteId++;
		}
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Generos getGenero() {
		return genero;
	}

	public void setGenero(Generos genero) {
		this.genero = genero;
	}

	public LocalDateTime getFechaContratacion() {
		return fechaContratacion;
	}


	public String getRfc() {
		return rfc;
	}


	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Puesto getPuesto() {
		return puesto;
	}


	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}


	public Estatus getEstatus() {
		return estatus;
	}


	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}


	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public static int getSiguienteId() {
		return siguienteId;
	}


	public static void setSiguienteId(int siguienteId) {
		Empleado.siguienteId = siguienteId;
	}


	public void setFechaContratacion(LocalDateTime fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	
	
}
