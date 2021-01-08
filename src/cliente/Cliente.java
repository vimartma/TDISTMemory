package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import ln.Partida;

public class Cliente {
	public static void main(String[] args) {
		Partida p1=new Partida();
		try(Socket s = new Socket("localhost",7654)) {
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				ObjectInputStream oin=new ObjectInputStream(s.getInputStream());
				
				System.out.println(oin.readLine());
				Scanner nombre = new Scanner (System.in);
				oos.writeBytes(nombre.nextLine()+"\r\n");
				oos.flush();
				
				
				while(!p1.finPartida()) {
					p1=(Partida) oin.readObject();
					p1.jugar();
					oos.writeObject(p1);
					oos.flush();
				}
			
		}
		catch(IOException | ClassNotFoundException ex) {			
			ex.printStackTrace();
		}

	}
	
}
