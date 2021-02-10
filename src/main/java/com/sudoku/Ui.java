package com.sudoku;

import java.util.Scanner;

public class Ui {
    Scanner sc = new Scanner(System.in);

    public void printBoard(int[][] board) {
        String out_horizontal =   "# # # # # # # # # # # # # # # # # # # # # # # # # # # #\n";
        String in_horizontal  = "\n# - - + - - + - - # - - + - - + - - # - - + - - + - - #\n";

        StringBuilder grid = new StringBuilder();

        for(int i=0; i<9; i++) {
            if(i==0 || i==3 || i==6) grid.append(out_horizontal);
            for(int j=0; j<9; j++) {
                if (j==0) grid.append("#  ");

                int val = board[i][j];
                if (val!=0) grid.append(val);
                else grid.append(" ");

                if(j==2 || j==5) grid.append("  #  ");
                else if(j==8) grid.append("  #");
                else grid.append("  |  ");
            }
            if(i!=2 && i!=5 && i!=8) grid.append(in_horizontal);
            else if (i!=8) grid.append("\n");
        }
        grid.append("\n").append(out_horizontal);
        System.out.print(grid);
    }

    public void printConflicts(Conflicts conflicts) {
        if(!conflicts.getColumns().isEmpty()) {
            System.out.print("Conflicts in columns: ");
            conflicts.getColumns().forEach(i -> System.out.print((i + 1) + " "));
            System.out.print("\n");
        }

        if(!conflicts.getRows().isEmpty()) {
            System.out.print("Conflicts in rows: ");
            conflicts.getRows().forEach(i -> System.out.print((i + 1) + " "));
            System.out.print("\n");
        }

        if(!conflicts.getBoxes().isEmpty()) {
            System.out.print("Conflicts in boxes: ");
            conflicts.getBoxes().forEach(i -> System.out.print((i + 1) + " "));
            System.out.print("\n");
        }
    }

    public Cell getCell() {
        int x;
        int y;
        int val;

        System.out.println("\nEdit cell");

        System.out.print("column = ");
        x = validateCoordinates() - 1;
        System.out.print("row = ");
        y = validateCoordinates() - 1;
        System.out.print("value = ");
        val = validateValue();

        return new Cell (x, y, val);
    }

    private int validateCoordinates() {
        int i = 0;
        int number;
        do {
            i++;
            while (!sc.hasNextInt()) {
                i++;
                System.out.println("That's not a number!");
                sc.next();
            }
            number = sc.nextInt();
            if (i!=0 && (number < 1 || number > 9)) {
                System.out.println("Out of bounds!");
            }
        } while (number < 1 || number > 9);
        System.out.println("Thank you! Got " + number);
        return number;
    }

    private int validateValue() {
        int i = 0;
        int number;
        do {
            i++;
            while (!sc.hasNextInt()) {
                i++;
                System.out.println("That's not a number!");
                sc.next();
            }
            number = sc.nextInt();
            if (i!=0 && (number < 0 || number > 9)) {
                System.out.println("Out of bounds!");
            }
        } while (number < 0 || number > 9);
        System.out.println("Thank you! Got " + number);
        return number;
    }
}
