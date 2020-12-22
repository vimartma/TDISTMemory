package servidor;

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
	ObjectOutputStream dos1=new ObjectOutputStream(s1.getOutputStream());
	ObjectInputStream din1=new ObjectInputStream(s1.getInputStream());
	
	ObjectOutputStream dos2=new ObjectOutputStream(s2.getOutputStream());
	ObjectInputStream din2=new ObjectInputStream(s2.getInputStream());
	
	while(!p1.finPartida()) {
		if(p1.turnoAct()==1) {
	dos1.writeObject(p1);
	dos1.flush();
	p1=(Partida) din1.readObject();
		}else {
			dos2.writeObject(p1);
			dos2.flush();
			p1=(Partida) din2.readObject();
		}
	
	
}
}catch(IOException ex) {ex.printStackTrace();} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
}
