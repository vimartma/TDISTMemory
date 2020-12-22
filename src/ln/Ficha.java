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
		if (this.girado) {
			this.girado = false;
		} else {
			this.girado = true;
		}
	}

	public String mostrar() {
		if (this.girado==true) {
			return "" + this.num;
		} 
		if(this.girado==false){
			return "X";
		}
		return ".";
	}
	public int getNum() {
		return this.num;
	}
	public boolean igual(Ficha f) {
		return f.getNum()==this.num;
	}
	public boolean girada() {
		return girado;
	}
	public Ficha duplicar() {
		Ficha f =new Ficha(this.getNum());
	if(this.girado) {
		f.girar();
	}
		return f;
	}
	
}
