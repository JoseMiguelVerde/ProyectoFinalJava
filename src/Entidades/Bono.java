package Entidades;
import java.time.LocalDateTime;
import Utilidades.Constantes;
import Utilidades.Constantes.Bonos;
import Utilidades.Constantes.Movimientos;
public class Bono {
	private int idEmpleado;
	private int idBono;
	private static int idSiguienteBono=1;
	private LocalDateTime fecha;
	private Bonos tipoBono;
	
	
	public Bono(int idEmpleado,Bonos tipoBono, Movimientos movimiento)
	{
		this.idBono=idSiguienteBono;
		this.idEmpleado=idEmpleado;
		this.fecha=LocalDateTime.now();
		this.tipoBono=tipoBono;
		if(movimiento==Movimientos.INSERCION)
        {
			idSiguienteBono++;
        }
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

	public Bonos getTipoBono() {
		return tipoBono;
	}

	public void setTipoBono(Bonos tipoBono) {
		this.tipoBono = tipoBono;
	}

	public int getIdBono() {
		return idBono;
	}

	public void setIdBono(int idBono) {
		this.idBono = idBono;
	}

}
