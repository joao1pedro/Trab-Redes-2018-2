import java.net.*;
import java.io.*;
public class Q1TCPClient {
	public static void main (String args[]) {
		// arguments supply message and hostname
		// cria um socket de cliente inicialmente nulo
		Socket s = null;
		try{
			// cria variavel inteira que recebe o numero da porta
			int serverPort = 7896;
			// o socket s criado anteriormente, recebe um novo socket 
			// cujo tem como parametro "localhost" em seu campo de endereço
			// e a variavel de porta criada anteriormente
			s = new Socket("localhost", serverPort);    
			//Cria variveis de entrada e saida de fluxo de dados
			DataInputStream in = new DataInputStream( s.getInputStream());
			DataOutputStream out =new DataOutputStream( s.getOutputStream());
			// escreve no fluxo de saída a mensagem que desejar
			//cujo a mensagem é passada como argumento, em args[0]
			out.writeUTF(args[0]);      	// UTF is a string encoding see Sn. 4.4
			/* cria variavel de string chamada data que espera receber como entrada um fluxo de dados 
				que parte do servidor para o cliente, como entrada
				uma string que permite caracteres latinos
			*/
			String data = in.readUTF();	    // read a line of data from the stream
			// imprime a mensagem recebida, que foi retornada pelo servidor
			System.out.println("Received: "+ data) ; 
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
     }
}
