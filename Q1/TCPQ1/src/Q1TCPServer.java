import java.net.*;
import java.io.*;
public class Q1TCPServer {
	public static void main (String args[]) {
		try{
			// cria variavel inteira que recebe o numero da porta
			int serverPort = 7896; // the server port
			// cria um socket de servidor, chamado listenSocket cujo recebe como parametro a porta
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while(true) {
				/*
					Cria um socket do client que recebe o listenSocket.accept();, ou seja,
					permite a conexão do cliente com o servidor, liberando comunicação
				*/
				Socket clientSocket = listenSocket.accept();
				/*
					Foi criado uma classe para conexão, cuja recebe um 
					socket de client como parametro
				*/
				Connection c = new Connection(clientSocket);
			}
		} catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
	}
}
class Connection extends Thread {
	/*
		Cria variavel de fluxo de dados de entrada(in) e saida(out)
	*/
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	// método conexão
	public Connection (Socket aClientSocket) {
		try {
			//Socket de criente criado recebe o socket passado por parametro para o metodo conexão
			clientSocket = aClientSocket;
			in = new DataInputStream( clientSocket.getInputStream()); //pega fluxo de dados de entrada do socket client
			out =new DataOutputStream( clientSocket.getOutputStream()); //pega fluxo de dados de saida do socket client
			this.start();
		} catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
	}
	public void run(){
		try {			                 // an echo server

			/* Cria uma string chamada data que espera receber
				do fluxo de entrada do cliente, uma string que permite caracteres latinos. (ç por exemplo)
				ou seja, servidor espera receber uma mensagem que o cliente enviou
			*/
			String data = in.readUTF();	                  // read a line of data from the stream
			//
			out.writeUTF(data); 
			/*
				Manda escrever no fluxo de saída os dados
				cujo o servidor recebeu do cliente.
				Visto que, na linha 48 outra forma de traduzir
				é que o servidor espera receber estes dados vindos do cliente
			*/
			System.out.println("Connection succefull");
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
		

	}
}