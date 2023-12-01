package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextArea;

public interface InteraccionCliente extends Remote {
    void receiveMessage(String message) throws RemoteException;
    String getUsername() throws RemoteException;
}
