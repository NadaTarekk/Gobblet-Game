package application.model;

import application.util.ConsoleColors;

import java.util.Objects;

public class Board {
    int rows;
    int cols;
    Cell[][] cells;

    public Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        //Query: Any way to do better initialization of below cells array
        this.cells = new Cell[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                this.cells[i][j] = new Cell();
    }

    public void printBoard(){
        for(int i=0;i<rows;i++){

            System.out.println();
            for(int j=0;j<cols;j++) {
                System.out.print(" ");
                Player player = this.cells[i][j].getPlayer();
                Piece piece = this.cells[i][j].getPiece();

                String name = Objects.isNull(player) ? "" : player.getName();
                String val = Objects.isNull(piece) ? " " : String.valueOf(piece.getVal());

                System.out.print( val+" "+name);
                if (j != cols - 1)
                    System.out.print(" | ");
            }
            
            System.out.println();
            if(i!=rows-1)
                for(int k=0;k<(4*cols);k++)
                    System.out.print("-");

        }
    }

    public void setCell(int i, int j, Player player, Piece piece){
        this.cells[i][j].setPiece(piece);
        this.cells[i][j].setPlayer(player);
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}