package Entidades;

import java.time.LocalDateTime;

import Utilidades.Constantes;
import Utilidades.Constantes.*;

public class Empleado {
	
	private int id;
	private String nombre, curp;
	private Generos genero;
	private float sueldoDia;
	private LocalDateTime fechaContratacion;
	private static int siguienteId=1;
	
	public Empleado(String nombre, Generos genero, Movimientos movimiento) {
		
		this.id=siguienteId;
		this.nombre=nombre;
		this.genero=genero;
		this.sueldoDia=200;
		this.curp="Sin CURP";
		this.fechaContratacion=LocalDateTime.now();
		if(movimiento==Movimientos.INSERCION)
		{
			siguienteId++;
		}
		
	}

	public Empleado(String nombre, Generos genero, String curp, Movimientos movimiento) {

		this.id=siguienteId;
		this.nombre=nombre;
		this.genero=genero;
		this.sueldoDia=200;
		this.curp=curp;
		this.fechaContratacion=LocalDateTime.now();
		if(movimiento==Movimientos.INSERCION)
		{
			siguienteId++;
		}
	}
	
	public String getDatosGenerales() {
		return "id: "+id+"\n"+"Nombre: "+nombre+"\n"+"Genero: "+genero.getNombreGenero()+"\n"+"CURP: "+curp+"\n"+"Sueldo por dia: "+sueldoDia+"\n"+"Fecha de contratacion: "+fechaContratacion.format(Constantes.FORMATO_FECHA)+"\n"; 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public float getSueldoDia() {
		return sueldoDia;
	}

	public LocalDateTime getFechaContratacion() {
		return fechaContratacion;
	}
}
