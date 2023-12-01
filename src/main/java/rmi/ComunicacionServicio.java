package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextArea;

public interface ComunicacionServicio extends Remote {
    void registerClient(InteraccionCliente client, String username) throws RemoteException;
    void unregisterClient(InteraccionCliente client) throws RemoteException;
    void broadcastMessage(String message) throws RemoteException;
    void sendDirectMessage(String sender, String receiver, String message) throws RemoteException;
}
