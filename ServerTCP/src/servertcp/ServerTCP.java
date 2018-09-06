package servertcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author lucasffz
 */
public class ServerTCP {

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
        
        //Criar Socket de conexão 
       System.out.println("Aguardando conexão..."); 
       ServerSocket server = new ServerSocket(8090);
      
       // Instancia um socket
       Socket socket = server.accept();
       System.out.println("Cliente conectado.");
       //Cria o tratamento de entrada e saída de objetos
       ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
       ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
       
       while(true){
           String mensagem = input.readUTF();
           System.out.println("Cliente:" + mensagem);
           
           if(mensagem.equalsIgnoreCase("close"))
               break;
           
           System.out.print(">>:");
           String saida = sc.nextLine();
           output.writeUTF(saida);
           output.flush();
       }
       input.close();
       output.close();
       socket.close();
      
        
    }
    
}
