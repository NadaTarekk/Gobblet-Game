
package application;
import javafx.util.Pair;
import application.model.Board;
import application.model.Game;
import application.model.Player;

import application.util.ConsoleColors;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Game game = initializeGame();
        game.getBoard().printBoard();
        printPlayers(game.getPlayerList());
        int totalPlayers = game.getPlayerList().size();
        int counter = 0;
        Scanner sc= new Scanner(System.in);

        while(true){
        	int current_row =0;
            int current_col =0;
            Player currTurn = game.getPlayerList().get(counter);
            System.out.print("Its turn of: " + currTurn.getName() + ". Enter piece you want to place: ");
            int pieceVal = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter external or internal: ");
            String type = sc.nextLine();
            
            
            System.out.print("Enter row and column you want to place it in: ");
            String str = sc.nextLine();
            int destRow = Integer.parseInt(str.split(" ")[0]);
            int destCol = Integer.parseInt(str.split(" ")[1]);
            if(type.equals("internal")) {
            	System.out.print("enter current row: ");
                current_row   = sc.nextInt();
                System.out.print("enter current col: ");
                current_col   = sc.nextInt();
            }
            
          
            Pair<Boolean, String> response = game.makeMove(currTurn, pieceVal, destRow, destCol,type,current_row,current_col);
            if(!response.getKey()){
                System.out.println(response.getValue());
                continue;
            }
            game.getBoard().printBoard();
            printPlayers(game.getPlayerList());
            Player winner = game.winner();
            if(Objects.nonNull(winner)){
                System.out.println(winner.getName() + " has won the game!");
                return;
            }
            counter = (counter+1)%totalPlayers;
        }

    }

    private static void  printPlayers(List<Player> playerList){
        for(Player player : playerList)
            player.printPlayerPieces();
        System.out.println();
    }

    private static Game initializeGame() {
        Board board = new Board(4,4);
        Player playerOne = new Player("1", "Player1", ConsoleColors.GREEN, 12);
        Player playerTwo = new Player("2", "Player2", ConsoleColors.RED, 12);
        Game game = new Game(board, Arrays.asList(playerOne, playerTwo));
        return game;
    }
}
