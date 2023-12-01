package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import javax.swing.JTextArea;

public class ComunicacionCliente {
    ComunicacionServicio chatService;
    
    public void startClient(String username, JTextArea jTextArea, String ip){
        try {
            String serverUrl = "rmi://"+ip+":9000/ChatService";

            
            chatService = (ComunicacionServicio) Naming.lookup(serverUrl);

            InteraccionClienteImpl clientCallback = new InteraccionClienteImpl(username, jTextArea);
            chatService.registerClient(clientCallback, username);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String message, String username) throws RemoteException{
        chatService.broadcastMessage(username + ": " + message);

    }
    
    public void sendPrivate(String username, String privateuser, String message) throws RemoteException{
        chatService.sendDirectMessage(username, privateuser, message);
        

    }
    
}
