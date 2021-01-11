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
		//Suma un punto al jugador
		this.puntos++;
	}
	public int puntos() {
		//Devuelve el numero de puntos actual del jugador
		return this.puntos;
		
	}
	public void setNombre(String nom) {
		//Cambia el nombre del jugador
		this.nombre=nom;
	}
	public String getNombre() {
		//Devuelve el nombre del jugador
		return this.nombre;
	}
	

}
