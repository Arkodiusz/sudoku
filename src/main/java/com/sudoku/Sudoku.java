package com.sudoku;

public class Sudoku {

    private static long lastTime = 0;
    private static long summarizedTime = 0;
    private static long avgTime = 0;

    public static void main(String[] args) {

        Board board = new Board();
        Ui ui = new Ui();

        board.print();
        board.put(ui.getCell());
        board.print();
    }
}
