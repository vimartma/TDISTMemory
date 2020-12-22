package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ln.Partida;

public class Servidor {


	public static void main(String[] args) {
		Partida p1=new Partida();
		ExecutorService pool=Executors.newCachedThreadPool();
		try(ServerSocket ser=new ServerSocket(7654);){
			while(true) {
				try {
					p1=new Partida();
					Socket cli=ser.accept();
					Socket cli2=ser.accept();
					Game g=new Game(cli,cli2,p1);
					pool.execute(g);
					
				}catch(IOException e){
					e.printStackTrace();
				}

			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}