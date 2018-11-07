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
			Date date = new Date();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int day   = localDate.getDayOfMonth();
			String data = in.readUTF();	                  // read a line of data from the stream
			//Gambiarra p/ pegar retornar uma mensagem especifica p/ cada dia do mes
			if(day == 6) {
				out.writeUTF(data + "Servidor -- Iam groot --" + date);
			}
			else if(day == 7) {
				out.writeUTF(data + "Servidor -- Test gambiarra --" + date);
			}
			//out.writeUTF(data +"Server date/time -> "+ date + "O dia do mês é : " + day);
			System.out.println("Connection succefull");
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
		

	}
}