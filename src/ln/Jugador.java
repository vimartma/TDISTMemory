package ln;

import java.io.Serializable;

public class Jugador implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int puntos=0;

public Jugador() {

}

public void sumarPunto(){
	this.puntos++;
}
public int puntos() {
	return this.puntos;
	
}

}