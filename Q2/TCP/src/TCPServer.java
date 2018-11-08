import java.net.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.io.*;
public class TCPServer {
	public static void main (String args[]) {
		try{
			int serverPort = 7896; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while(true) {
				Socket clientSocket = listenSocket.accept();
				Connection c = new Connection(clientSocket);
			}
		} catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
	}
}
class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	public Connection (Socket aClientSocket) {
		try {
			clientSocket = aClientSocket;
			in = new DataInputStream( clientSocket.getInputStream());
			out =new DataOutputStream( clientSocket.getOutputStream());
			this.start();
		} catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
	}
	public void run(){
		try {			                 // an echo server
			String data = in.readUTF();	                  // read a line of data from the stream
			//metodo para pegar o dia do mes e de acordo com este, retornar a frase do dia
			// apos realizar comparacoes
			writeOut();
			System.out.println("Connection succefull");
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
		

	}
	
	public void writeOut() throws IOException{
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int day   = localDate.getDayOfMonth();
		if(day == 1) {
			out.writeUTF("Servidor -- FRASE DIA 1--" + date);
		}
		else if(day == 2) {
			out.writeUTF("Servidor -- FRASE DIA 2 --" + date);
		}
		else if(day == 3) {
			out.writeUTF("Servidor -- FRASE DIA 3--" + date);
		}
		else if(day == 4) {
			out.writeUTF("Servidor -- FRASE DIA 4--" + date);
		}
		else if(day == 5) {
			out.writeUTF("Servidor -- FRASE DIA 5 --" + date);
		}
		else if(day == 6) {
			out.writeUTF("Servidor -- FRASE DIA 6 --" + date);
		}
		else if(day == 7) {
			out.writeUTF("Servidor -- FRASE DIA 7 --" + date);
		}
		else if(day == 8) {
			out.writeUTF("Servidor -- FRASE DIA 8 --" + date);
		}
		else if(day == 9) {
			out.writeUTF("Servidor -- FRASE DIA 9 --" + date);
		}
		else if(day == 10) {
			out.writeUTF("Servidor -- FRASE DIA 10 --" + date);
		}
		else if(day == 11) {
			out.writeUTF("Servidor -- FRASE DIA 11 --" + date);
		}
		else if(day == 12) {
			out.writeUTF("Servidor -- FRASE DIA 12 --" + date);
		}
		else if(day == 13) {
			out.writeUTF("Servidor -- FRASE DIA 13 --" + date);
		}
		else if(day == 14) {
			out.writeUTF("Servidor -- FRASE DIA 14--" + date);
		}
		else if(day == 15) {
			out.writeUTF("Servidor -- FRASE DIA 15 --" + date);
		}
		else if(day == 16) {
			out.writeUTF("Servidor -- FRASE DIA 16 --" + date);
		}
		else if(day == 17) {
			out.writeUTF("Servidor -- FRASE DIA 17 --" + date);
		}
		else if(day == 18) {
			out.writeUTF("Servidor -- FRASE DIA 18 --" + date);
		}
		else if(day == 19) {
			out.writeUTF("Servidor -- FRASE DIA 19 --" + date);
		}
		else if(day == 20) {
			out.writeUTF("Servidor -- FRASE DIA 20 --" + date);
		}
		else if(day == 21) {
			out.writeUTF("Servidor -- FRASE DIA 21 --" + date);
		}
		else if(day == 22) {
			out.writeUTF("Servidor -- FRASE DIA 22 --" + date);
		}
		else if(day == 23) {
			out.writeUTF("Servidor -- FRASE DIA 23 --" + date);
		}
		else if(day == 24) {
			out.writeUTF("Servidor -- FRASE DIA 24 --" + date);
		}
		else if(day == 25) {
			out.writeUTF("Servidor -- FRASE DIA 25 --" + date);
		}
		else if(day == 26) {
			out.writeUTF("Servidor -- FRASE DIA 26 --" + date);
		}
		else if(day == 27) {
			out.writeUTF("Servidor -- FRASE DIA 27 --" + date);
		}
		else if(day == 28) {
			out.writeUTF("Servidor -- FRASE DIA 28 --" + date);
		}
		else if(day == 29) {
			out.writeUTF("Servidor -- FRASE DIA 29 --" + date);
		}
		else if(day == 30) {
			out.writeUTF("Servidor -- FRASE DIA 30 --" + date);
		}
		else if(day == 31) {
			out.writeUTF("Servidor -- FRASE DIA 31 --" + date);
		}
	}
}