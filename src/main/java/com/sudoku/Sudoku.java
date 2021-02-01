package com.sudoku;

public class Sudoku {

    public static void main(String[] args) {
        Board board = new Board();
        Ui ui = new Ui();

        ui.printBoard(board.getBoard());

        while(!board.isFilled()) {
            board.put(ui.getCell());
            board.verify();
            ui.printBoard(board.getBoard());
            ui.printConflicts(board.getConflicts());
        }
    }
}
