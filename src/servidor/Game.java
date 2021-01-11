package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ln.Partida;

public class Game extends Thread{
private Socket s1;
private Socket s2;
private Partida p1;
public Game(Socket so,Socket so2,Partida p) {
	this.s1=so;
	this.s2=so2;
	this.p1=p;
	
}
public void run() {
	
try {
	//Obtenemos los Streams a partir de los sockets
	ObjectOutputStream oos1=new ObjectOutputStream(s1.getOutputStream());
	ObjectInputStream oin1=new ObjectInputStream(s1.getInputStream());
	
	ObjectOutputStream oos2=new ObjectOutputStream(s2.getOutputStream());
	ObjectInputStream oin2=new ObjectInputStream(s2.getInputStream());
	//Obtenemos los nombres de los jugadores
	String nombre1;
	String nombre2;
	oos1.writeBytes("Introduce tu nombre\r\n");
	oos1.flush();
	nombre1=oin1.readLine();
	
	oos2.writeBytes("Introduce tu nombre\r\n");
	oos2.flush();
	nombre2=oin2.readLine();
	if(nombre1.equals(nombre2)) {nombre2+="(2)";}
	p1.setNombresJug(nombre1, nombre2);
	//Parte en la que se juega la partida
	while(!p1.finPartida()) {
		if(p1.turnoAct()==1) {
	oos1.writeObject(p1);
	oos1.flush();
	p1=(Partida) oin1.readObject();
		}else {
			oos2.writeObject(p1);
			oos2.flush();
			p1=(Partida) oin2.readObject();
		}
}
	//Envio del mensaje final al jugador que no acaba la partida
	if(p1.turnoAct()==1) {
	oos1.writeObject(p1);
	oos1.flush();
		}else {
			oos2.writeObject(p1);
			oos2.flush();
		}
	
}catch(IOException ex) {ex.printStackTrace();} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
}
