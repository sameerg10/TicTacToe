
package Assignment2.TicTacToe;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface ServerIF extends Remote {
    void Register (ClientIF Client) throws RemoteException;

    void checkStart() throws RemoteException;

    void initBoard() throws RemoteException;

    void playGame() throws RemoteException;
  
}
