package ln;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class Tablero implements Serializable{

	private static final long serialVersionUID = 1L;
	private Ficha[][] tablero;
public Tablero() {
	generarTablero();
}

private void generarTablero() {
	//Genera el tablero inicial
	Random r = new Random();
	tablero = new Ficha[4][4];
	int posi;
	int i=0;
	int o=0;
	Ficha f;

	ArrayList<Integer> numeros=new ArrayList<Integer>();
	while(i<(16/2)) {
		while(o<2) {
		numeros.add(i);
		o++;
		}
		o=0;
		i++;
	}
	i=0;
	o=0;
	while(i<4) {	
		while(o<4) {
			posi=r.nextInt(numeros.size());
			tablero[i][o]=new Ficha(numeros.get(posi));
			numeros.remove(posi);
			o++;
		}
		o=0;
		i++;
		}
	}
public void setFicha(int a,int b,Ficha f) {
	//Coloca la ficha f en la posicion indicada por a y b
	this.tablero[a][b]=f;
}

public Ficha getFicha(int a,int b) {
	//Obtiene la ficha en la posicion a b
	return tablero[a][b];
}
public Ficha dupFicha(int a,int b) {
	// Devuelve una copia exacta de la ficha en la posicion a b
	return tablero[a][b].duplicar();
}

public void girar(int a,int b) {
	//Gira la ficha de la posicion a b
	tablero[a][b].girar();
}
public void show() {
	//Muestra por pantalla el tablero
	
	String fila=new String();
	int i=0;
	int o=0;
	while(i<4) {
		while(o<4) {
			fila=fila+tablero[i][o].mostrar();
			o++;
		}
		System.out.println(fila);
		fila=new String();
		o=0;
		i++;
	}
}
public boolean todasGiradas() {
	//Devuelve true si todas las fichas muestran numeros, false en caso contrario
	int i=0;
	int o=0;
	while(i<4) {
		while(o<4) {
				if(!tablero[i][o].girada()) {
					return false;
				}
				o++;
		}
		o=0;
		i++;
	}
	return true;
	
}
public Tablero clonar() {
	//Devuelve un tablero igual
	Tablero t=new Tablero();
	int i=0;
	int o=0;
	while(i<4) {
		while(o<4) {
			t.setFicha(i, o, this.dupFicha(i, o));
			o++;
		}
		o=0;
		i++;
	}
	return t;
	
	
}
}
