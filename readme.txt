Program: TicTacToe

This program basically allows for two player tictactoe via a server

The users (2 clients) can play tictactoe against each other. THE GAME ONLY STARTS WHEN THE SECOND CLIENT HAS CONNECTED TO THE SERVER.
Game is simple in that you have to enter coordinates for where you want your move to be located. ie. "1 3" will put it on the first row, third column.
X starts first then goes on until someone wins or draws.

TO RUN:
-navigate to the directory with the .java files. compile with javac "javac *.java"
-now navigate two directories back... to get out of the Assignment2>TicTacToe "cd .." "cd .." <- do it twice!
-start the rmi registry "start rmiregistry" or "rmiregistry &" (can optionally open a new command prompt and just run the server without start)
-start the Server "start java Assignment2.TicTacToe.Server" (can optionally open a new command prompt and just run the server without start)
-start the first client "start java Assignment2.TicTacToe.Client" (can optionally open a new command prompt and just run the server without start)
-start the first client "start java Assignment2.TicTacToe.Client" (can optionally open a new command prompt and just run the server without start)


These instructions are based on Windows mainly.  Make sure you are two directories outside the java files (make sure to "cd.." twice!!) and then
follow step 3 onwards. This will be for the rest of my questions as well.