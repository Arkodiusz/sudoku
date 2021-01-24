package com.sudoku;

import java.util.Scanner;

public class Ui {
    Scanner sc = new Scanner(System.in);

    public Cell getCell() {
        int x;
        int y;
        int val;

        System.out.print("column = ");
        x = sc.nextInt()-1;
        System.out.print("row = ");
        y = sc.nextInt()-1;
        System.out.print("value = ");
        val = sc.nextInt();

        return new Cell (x, y, val);
    }

}
