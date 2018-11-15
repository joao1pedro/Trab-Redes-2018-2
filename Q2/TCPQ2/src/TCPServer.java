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
			String data = in.readUTF();
			Date date = new Date(); //cria variavel do tipo data
			
			//verifica se a mensagem que recebeu do cliente
			//é igual a algum comando que o servidor interpreta
			//para retornar a resposta + data
			if(data.trim().equals("cmd1")) {
				out.writeUTF("Servidor -- FRASE 1 --" + date);
			}
			else if(data.trim().equals("cmd2")) {
				out.writeUTF("Servidor -- FRASE 2 --" + date);
			}
			else if(data.trim().equals("cmd3")) {
				out.writeUTF("Servidor -- FRASE 3 --" + date);
			}
			else if(data.trim().equals("cmd4")){
				out.writeUTF("Servidor -- FRASE 4 --" + date);
			}
			else if(data.trim().equals("cmd5")){
				out.writeUTF("Servidor -- FRASE 5 --" + date);
			}
			else if(data.trim().equals("cmd6")){
				out.writeUTF("Servidor -- FRASE 6 --" + date);
			}
			else if(data.trim().equals("cmd7")){
				out.writeUTF("Servidor -- FRASE 7 --" + date);
			}
			else if(data.trim().equals("cmd8")){
				out.writeUTF("Servidor -- FRASE 8 --" + date);
			}
			else if(data.trim().equals("cmd9")){
				out.writeUTF("Servidor -- FRASE 9 --" + date);
			}
			else if(data.trim().equals("cmd10")){
				out.writeUTF("Servidor -- FRASE 10 --" + date);
			}
			else if(data.trim().equals("cmd11")){
				out.writeUTF("Servidor -- FRASE 11 --" + date);
			}
			else if(data.trim().equals("cmd12")){
				out.writeUTF("Servidor -- FRASE 12 --" + date);
			}
			else if(data.trim().equals("cmd13")){
				out.writeUTF("Servidor -- FRASE 13 --" + date);
			}
			else if(data.trim().equals("cmd14")){
				out.writeUTF("Servidor -- FRASE 14--" + date);
			}
			else if(data.trim().equals("cmd15")){
				out.writeUTF("Servidor -- FRASE 15 --" + date);
			}
			else if(data.trim().equals("cmd16")){
				out.writeUTF("Servidor -- FRASE 16 --" + date);
			}
			else if(data.trim().equals("cmd17")){
				out.writeUTF("Servidor -- FRASE 17 --" + date);
			}
			else if(data.trim().equals("cmd18")){
				out.writeUTF("Servidor -- FRASE 18 --" + date);
			}
			else if(data.trim().equals("cmd19")){
				out.writeUTF("Servidor -- FRASE 19 --" + date);
			}
			else if(data.trim().equals("cmd20")){
				out.writeUTF("Servidor -- FRASE 20 --" + date);
			}
			else if(data.trim().equals("cmd21")){
				out.writeUTF("Servidor -- FRASE 21 --" + date);
			}
			else if(data.trim().equals("cmd22")){
				out.writeUTF("Servidor -- FRASE 22 --" + date);
			}
			else if(data.trim().equals("cmd23")){
				out.writeUTF("Servidor -- FRASE 23 --" + date);
			}
			else if(data.trim().equals("cmd24")){
				out.writeUTF("Servidor -- FRASE 24 --" + date);
			}
			else if(data.trim().equals("cmd25")){
				out.writeUTF("Servidor -- FRASE 25 --" + date);
			}
			else if(data.trim().equals("cmd26")){
				out.writeUTF("Servidor -- FRASE 26 --" + date);
			}
			else if(data.trim().equals("cmd27")){
				out.writeUTF("Servidor -- FRASE 27 --" + date);
			}
			else if(data.trim().equals("cmd28")){
				out.writeUTF("Servidor -- FRASE 28 --" + date);
			}
			else if(data.trim().equals("cmd29")){
				out.writeUTF("Servidor -- FRASE 29 --" + date);
			}
			else if(data.trim().equals("cmd30")){
				out.writeUTF("Servidor -- FRASE 30 --" + date);
			}
			else if(data.trim().equals("cmd31")){
				out.writeUTF("Servidor -- FRASE 31 --" + date);
			}else {
				out.writeUTF("Servidor -- Invalid command!");
			}
			System.out.println("Connection succefull");
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
		

	}
}