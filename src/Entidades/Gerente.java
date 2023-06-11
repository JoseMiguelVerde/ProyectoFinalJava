package Entidades;
import java.time.LocalDate;
import java.time.LocalDateTime;

import Utilidades.Constantes.Generos;
import Utilidades.Constantes.Movimientos;
import Utilidades.Constantes.Puesto;

public class Gerente extends Empleado {
	
	public Gerente(String nombre,Puesto puesto, String rfc, String curp, String direccion, Generos genero, LocalDate fechaNacimiento) {
		super(nombre,puesto,rfc,curp,direccion,genero,fechaNacimiento);
		
	}	
}
