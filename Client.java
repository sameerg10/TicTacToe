
package Assignment2.TicTacToe;



import static Assignment2.TicTacToe.Server.board;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client extends UnicastRemoteObject implements ClientIF{

    
    
    public static int user=0;
    
    public Client(ServerIF chatServer) throws RemoteException {
     
    }
    
    public void end (int whichCase){
        if (whichCase == 1){
            System.out.println("Player X wins! Game is over now!");
        }
        else if (whichCase == 2){
            System.out.println("Player O wins! Game is over now!");
        }
        else{
            System.out.println("Game is a draw! Game is over now!");
        }
    }
    
    public void drawBoard(char [][] board) throws RemoteException {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n---------");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n---------");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "\n");
    }
    
    public char[][] playerTurn(char[][]board, int activePlayer) throws RemoteException{
        
        Scanner in = new Scanner(System.in);
        drawBoard(board);
        System.out.print("Enter coordinates (row [1-3]) (column [1-3]): ");
            
        int row = in.nextInt() - 1;  
        int col = in.nextInt() - 1;
        
        //bad input
        while ( row > 2 || col > 2 || row < 0 || col < 0 || board[row][col] != ' ' ){
            System.out.println("Invalid input. Try again...");
            row = in.nextInt() - 1;  
            col = in.nextInt() - 1;
        }
            
        if (activePlayer == 1){
            board[row][col] = 'x';
        }
        else{
            board[row][col] = 'o';
        }
        drawBoard(board);
        return board;    
    }

    public static void main(String[] args) {

        
	Scanner in = new Scanner(System.in);
	
	String host = (args.length < 1) ? null : args[0];
	try {
	    Registry registry = LocateRegistry.getRegistry(host);
	    ServerIF stub = (ServerIF) registry.lookup("Hello");
            
            //registering a new client
            Client client;  
            client = new Client(stub);
            stub.Register(client);
            
            //play game
            stub.initBoard();
            stub.checkStart();
            stub.playGame();
            
	    
	} catch (Exception e) {
	    System.err.println("Client exception: " + e.toString());
	    e.printStackTrace();
	}
    }     

    

    
    
}
