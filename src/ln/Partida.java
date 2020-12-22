package ln;

import java.io.Serializable;
import java.util.Scanner;

public class Partida implements Serializable{

	private static final long serialVersionUID = 1L;
private Tablero tab;
private Ficha seleccionada1;
private Ficha seleccionada2;
private int turno=0;
private Jugador[] jug; 
private Tablero tabAnterior=null;

	public Partida() {
	this.tab=new Tablero();
	seleccionada1=null;
	seleccionada2=null;
	jug=new Jugador[2];
	jug[0]=new Jugador();
	jug[1]=new Jugador();

	}
	
	public void seleccionar(int a,int b) {
		if(this.seleccionada1==null) {
		this.seleccionada1=tab.getFicha(a, b);
		tab.show();
		}else {
		this.seleccionada2=tab.getFicha(a, b);
		}
		
	}
	public void jugar() {
		if(finPartida()) {
			this.mostrarPuntos();
		}else {
			if(tabAnterior!=null) {
				System.out.println("-----------Jugada Anterior-----------");
				tabAnterior.show();
			}
		System.out.println("------------------Nueva Jugada------------------");
		tab.show();
		System.out.println("Selecciona fila");
		Scanner fila1 = new Scanner (System.in);
		String f1 = fila1.nextLine();
		int fi1 = Integer.parseInt(f1);
		System.out.println("Selecciona columna");
		Scanner columna1 = new Scanner (System.in);
		String c1 = fila1.nextLine();
		int co1 = Integer.parseInt(c1);
		seleccionar(fi1-1,co1-1);
		
		System.out.println("Selecciona fila");
		Scanner fila2 = new Scanner (System.in);
		String f2 = fila1.nextLine();
		int fi2 = Integer.parseInt(f2);
		System.out.println("Selecciona columna");
		Scanner columna2 = new Scanner (System.in);
		String c2 = fila1.nextLine();
		int co2 = Integer.parseInt(c2);
		seleccionar(fi2-1,co2-1);
		
		if (seleccionada1.igual(seleccionada2)) {
			
			jug[turno].sumarPunto();
			if(!finPartida()) {
				seleccionada1=null;
				seleccionada2=null;
				this.jugar();
				
			}else {
				this.mostrarPuntos();
				cambiaTurno();
			}
			
		}else {
			tabAnterior=tab.clonar();
			seleccionada1=null;
			seleccionada2=null;
			System.out.println("------------------------------------");
			tab.show();
			tab.girar(fi1-1, co1-1);
			tab.girar(fi2-1, co2-1);
			System.out.println("------------------------------------");
			tab.show();
			cambiaTurno();

		}
		}
		
	}
	
	private void mostrarPuntos() {
		System.out.println("El jugador 1 ha obtenido "+this.jug[0].puntos());
		System.out.println("El jugador 2 ha obtenido "+this.jug[1].puntos());
		
	}

	private void cambiaTurno() {
		if(this.turno==0) {
			this.turno=1;
		}else {
			this.turno=0;
		}		
	}

	public boolean finPartida() {
		if(tab.todasGiradas()) {
			return true;
		}
		return false;
	}
	public int turnoAct(){
		return this.turno+1;
	}
	
	
}
