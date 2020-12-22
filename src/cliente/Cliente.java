package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ln.Partida;

public class Cliente {
	public static void main(String[] args) {
		Partida p1=new Partida();
		try(Socket s = new Socket("localhost",7654)) {
				ObjectOutputStream dos=new ObjectOutputStream(s.getOutputStream());
				ObjectInputStream din=new ObjectInputStream(s.getInputStream());
				
				while(!p1.finPartida()) {
					p1=(Partida) din.readObject();
					p1.jugar();
					dos.writeObject(p1);
					dos.flush();
				}
			
		}
		catch(IOException | ClassNotFoundException ex) {			
			ex.printStackTrace();
		}

	}
	
}
