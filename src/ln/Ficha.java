package ln;

import java.io.Serializable;

public class Ficha implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;
	private boolean girado = false;

	public Ficha(int numero) {
		this.num = numero;
	}

	public void girar() {
		//Gira la ficha para mostrar el numero u ocultarlo
		if (this.girado) {
			this.girado = false;
		} else {
			this.girado = true;
		}
	}

	public String mostrar() {
		//Devuelve la parte visible de la ficha en cada momento
		if (this.girado==true) {
			return "" + this.num;
		} 
		if(this.girado==false){
			return "X";
		}
		return ".";
	}
	public int getNum() {
		//Devuelve el numero de la ficha
		return this.num;
	}
	public boolean igual(Ficha f) {
		//Compara si dos Fichas tienen el mismo numero
		return f.getNum()==this.num;
	}
	public boolean girada() {
		//Devuelve true en caso de que la parte visible de la ficha sea el numero, false en caso contrario
		return girado;
	}
	public Ficha duplicar() {
		//Devuelve una ficha igual
		Ficha f =new Ficha(this.getNum());
	if(this.girado) {
		f.girar();
	}
		return f;
	}
	
}
