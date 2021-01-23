package com.sudoku;

public class Cell {
    private int x;
    private int y;
    private int val;

    public Cell(int x, int y, int val) {
        this.x = x-1;
        this.y = y-1;
        this.val = val;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVal() {
        return val;
    }
}
