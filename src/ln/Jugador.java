package ln;

import java.io.Serializable;

public class Jugador implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int puntos=0;
String nombre="Jugador";
	public Jugador() {
	
	}
	
	public void sumarPunto(){
		this.puntos++;
	}
	public int puntos() {
		return this.puntos;
		
	}
	public void setNombre(String nom) {
		this.nombre=nom;
	}
	public String getNombre() {
		return this.nombre;
	}
	

}
