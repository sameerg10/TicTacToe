
package Assignment2.TicTacToe;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientIF extends Remote {
 
    void drawBoard(char [][] board) throws RemoteException;
    char[][] playerTurn(char[][]board, int playerNum) throws RemoteException;
    void end (int whichCase) throws RemoteException;
}
