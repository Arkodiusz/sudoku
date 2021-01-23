package com.sudoku;

public class Board {

    int[][] board;

    public Board() {
        this.board = new int[9][9];
        this.fill();
    }

    public void put(Cell cell) {
        board[cell.getY()][cell.getX()] = cell.getVal();
    }

    public void print() {
        String out_horizontal =   "# # # # # # # # # # # # # # # # # # # # # # # # # # # #\n";
        String in_horizontal  = "\n# - - + - - + - - # - - + - - + - - # - - + - - + - - #\n";

        StringBuilder grid = new StringBuilder();

        for(int i=0; i<9; i++) {
            if(i==0 || i==3 || i==6) grid.append(out_horizontal);

            for(int j=0; j<9; j++) {

                if (j==0) grid.append("#  ");
                grid.append(board[i][j]);
                if(j==2 || j==5) grid.append("  #  ");
                else if(j==8) grid.append("  #");
                else grid.append("  |  ");

            }
            if(i!=2 && i!=5 && i!=8) grid.append(in_horizontal);
            else if (i!=8) grid.append("\n");
        }
        grid.append("\n" + out_horizontal);
        System.out.print(grid);
    }

    private void fill() {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                board[i][j] = 0;
            }
        }
    }

}
