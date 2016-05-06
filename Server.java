
package Assignment2.TicTacToe;

	
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
	
public class Server implements ServerIF {

    
    public ArrayList<ClientIF> Clients;
    public int turn = 2;
    public int num = 0;
    public static int clientNum=0;
    public static char board[][] = new char[3][3];
    public static int playerNum=1;
    
    
    public Server() throws RemoteException{
         Clients = new ArrayList<ClientIF>();
         
     }
    
    public void Register(ClientIF Client) throws RemoteException {
        
        this.Clients.add(Client);
        clientNum++;  
    }
    
    public void checkStart() throws RemoteException{
        
        
        if (Clients.size() == 2){
            Clients.get(1).drawBoard(board);
        }
            
        
    }
    public void playGame() throws RemoteException{

        int isOver = 0;
 
        if (Clients.size() == 2){
        while(isOver == 0){

            if (playerNum == 1){
                board = Clients.get(0).playerTurn(board, playerNum);
            }
            else{
                board = Clients.get(1).playerTurn(board, playerNum);
            }
             
            isOver = checkWin();
            if (isOver == 0){
                isOver = checkFull();
            }
            
            if (playerNum == 1){
                playerNum = 2;
            }
            else{
                playerNum = 1;
            }
 
        }
        }
    }
    
    public int checkWin() throws RemoteException{
        int i;
        int x;
        
        for (i=0;i<3;i++){ //checking rows
            if ((board[i][0] == 'x' && board[i][1] == 'x' && board[i][2] == 'x') || (board[i][0] == 'o' && board[i][1] == 'o' && board[i][2] == 'o')){
                if (playerNum == 1){
                    Clients.get(0).end(1);
                    Clients.get(1).end(1);         
                }
                else {
                    Clients.get(0).end(2);
                    Clients.get(1).end(2);  
                }
                return 1;
            }
        }
        for (i=0;i<3;i++){ //checking columns
            if ((board[0][i] == 'x' && board[1][i] == 'x' && board[2][i] == 'x') || (board[0][i] == 'o' && board[1][i] == 'o' && board[2][i] == 'o')){
                if (playerNum == 1){
                    Clients.get(0).end(1);
                    Clients.get(1).end(1); 
                }
                else {
                    Clients.get(0).end(2);
                    Clients.get(1).end(2);
                } 
                return 1;
            }
        }
        
        if ((board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') || (board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x') || (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o') || (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o')){
                if (playerNum == 1){
                    Clients.get(0).end(1);
                    Clients.get(1).end(1); 
                }
                else {
                    Clients.get(0).end(2);
                    Clients.get(1).end(2);
                } 
                return 1;
            }
        return 0;
    }
    
    public int checkFull() throws RemoteException{
        int i;
        int x;
        int full=0;
        for (i=0;i<3;i++){
            for (x=0;x<3;x++){
                if (board[i][x] != ' '){
                    full++;
                }
            }
        }
        if (full == 9){
            Clients.get(0).end(3);
            Clients.get(1).end(3);
            return 1;
        }
        else{
            return 0;
        }
    }

    public void initBoard() {
        int i;
        int x;
        for (i=0;i<3;i++){
            for (x=0;x<3;x++){
                board[i][x] = ' ';
            }
        }
    }
    
    public static void main(String args[]) {
	
	try {
	    Server obj = new Server();
	    ServerIF stub = (ServerIF) UnicastRemoteObject.exportObject(obj, 0);

	    // Bind the remote object's stub in the registry
            
	    Registry registry = LocateRegistry.getRegistry();
	    registry.bind("Hello", stub);

	    System.err.println("Server ready");
		
	} catch (Exception e) {
	    System.err.println("Server exception: " + e.toString());
	    e.printStackTrace();
	}
    }   
}
