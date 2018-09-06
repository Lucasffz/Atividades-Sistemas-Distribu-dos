
package clientetcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author lucasffz
 */
public class ClienteTCP {

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
        
       System.out.println("Estabelecendo conexão...");
       Socket socket = new Socket("localhost",8090);
       System.out.println("Conexão estabelecida");
        
       ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
       ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
       
       while(true){
            System.out.print(">>:");
            String mensagem = sc.nextLine();
            output.writeUTF(mensagem);
            output.flush();
            if(mensagem.equalsIgnoreCase("close"))
                break;
            String resposta = input.readUTF();
            System.out.println("Servidor:" + resposta);
       }
       input.close();
       output.close();
       socket.close();
        
    }
    
}
