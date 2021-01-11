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
private boolean cartasel=true;
private boolean acertado=false;

	public Partida() {
		this.tab=new Tablero();
		seleccionada1=null;
		seleccionada2=null;
		jug=new Jugador[2];
		jug[0]=new Jugador();
		jug[1]=new Jugador();
		

	}
	
	public boolean seleccionar(int a,int b) {
		//Si es posible selecciona la ficha que se encuentra en la fila a y la columna b del tablero asociado a la partida
		Ficha f=tab.getFicha(a, b);
		if(f.girada()) {
			return false;
		}else {
			if(this.seleccionada1==null) {
					this.seleccionada1=tab.getFicha(a, b);
						tab.girar(a, b);
						tab.show();
		}else {
			this.seleccionada2=tab.getFicha(a, b);
			tab.girar(a, b);
		}
		return true;
		}
		
	}
	public void jugar() {
		//Permite al jugador realizar una jugada en una partida
		if(finPartida()) {
			this.mostrarPuntos();
		}else {
			if(tabAnterior!=null && !acertado) {
				System.out.println("-----------Jugada Anterior-----------");
				tabAnterior.show();
			}
		System.out.println("------------------Nueva Jugada------------------");
		tab.show();
		int fi1=99;
		int co1=99;
		int fi2=99;
		int co2=99;
		while(cartasel) {
			System.out.println("Selecciona fila");
			Scanner fila1 = new Scanner (System.in);
			String f1 = fila1.nextLine();
			fi1 = Integer.parseInt(f1);
			System.out.println("Selecciona columna");
			Scanner columna1 = new Scanner (System.in);
			String c1 = fila1.nextLine();
			co1 = Integer.parseInt(c1);
			if(fi1-1>3 || co1-1>3 || fi1-1<0 || co1-1<0) {
				cartasel=true;
				System.out.println("Has introducido valores no validos, pruebe de nuevo");
			}else {
				cartasel=!seleccionar(fi1-1,co1-1);
				if(cartasel) {System.out.println("Esta carta ya ha sido seleccionada, seleccione otra");}
			}
		}
		cartasel=true;
		while(cartasel) {
			System.out.println("Selecciona fila");
			Scanner fila2 = new Scanner (System.in);
			String f2 = fila2.nextLine();
			fi2 = Integer.parseInt(f2);
			System.out.println("Selecciona columna");
			Scanner columna2 = new Scanner (System.in);
			String c2 = columna2.nextLine();
			co2 = Integer.parseInt(c2);
			if(fi2-1>3 || co2-1>3 || fi2-1<0 || co2-1<0) {
				cartasel=true;
				System.out.println("Has introducido valores no validos, pruebe de nuevo");
			}else {
				cartasel=!seleccionar(fi2-1,co2-1);
				if(cartasel) {System.out.println("Esta carta ya ha sido seleccionada, seleccione otra");}
			}
		}
		cartasel=true;
		
		if (seleccionada1.igual(seleccionada2)) {
			
			jug[turno].sumarPunto();
			if(!finPartida()) {
				seleccionada1=null;
				seleccionada2=null;
				acertado=true;
				this.jugar();
				
			}else {
				this.mostrarPuntos();
				cambiaTurno();
			}
			
		}else {
			acertado=false;
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
		//Muestra el resultado de una partida al final de esta
		System.out.println("--La partida ha terminado, todas las fichas han sido emparejadas--");
		System.out.println("El jugador "+this.jug[0].getNombre()+" ha obtenido "+this.jug[0].puntos());
		System.out.println("El jugador "+this.jug[1].getNombre()+" ha obtenido "+this.jug[1].puntos());
		
	}

	private void cambiaTurno() {
		//Cambia el turno al otro jugador
		if(this.turno==0) {
			this.turno=1;
		}else {
			this.turno=0;
		}		
	}

	public boolean finPartida() {
		//Devuelve true si la partida ha terminado, false en caso contrario
		if(tab.todasGiradas()) {
			return true;
		}
		return false;
	}
	public int turnoAct(){
		//Devuelve el turno actual
		return this.turno+1;
	}
	public void setNombresJug(String j1,String j2) {
		//Cambia el nombre de los jugadores de la partida
		this.jug[0].setNombre(j1);
		this.jug[1].setNombre(j2);
	}
	
	
}
