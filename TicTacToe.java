package Video_48_TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(char[] row : board){
            Arrays.fill(row,' ');
        }

        char player = 'X';
        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;
        int counter = 0;
        while(!gameOver && counter < 9){
            printBoard(board);
            System.out.println("Player "+player+" turn ->");
//            System.out.println(": ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if(board[row][col] == ' '){
                //place the move
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if(gameOver){
                    System.out.println("Congratulation!! Player "+player+" won!");
                }
                else {
                    counter++;
                    player = (player == 'X') ? 'O' : 'X';
                }
            }
            else {
                System.out.println("Invalid Move!! Try Again");
            }
        }

        if(counter == 9){
            System.out.println("Draw!!!");
        }
        printBoard(board);

    }

    private static boolean haveWon(char[][] board, char player) {
        //For Rows
        for(int row = 0; row < 3; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        //For Col
        for(int col = 0; col < 3; col++){
            if(board[0][col] == player &&  board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        //For Diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }

        return false;
    }


    private static void printBoard(char[][] board) {
        for(int i = 0;i < 3 ;i++){
            for(int j = 0;j < 3 ;j++){
                System.out.print(board[i][j]);
                if(j<2){
                    System.out.print("  |  ");
                }
            }
            System.out.println();
            if(i<2){
                System.out.println("-------------");
            }
        }
    }
}
