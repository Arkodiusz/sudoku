package com.sudoku;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

@Getter
@NoArgsConstructor
public class Board {

    private int[][] board = new int[9][9];
    private boolean filled = false;
    private Conflicts conflicts = new Conflicts();

    public void put(Cell cell) {
        board[cell.getY()][cell.getX()] = cell.getVal();
    }

    public void verify() {
        checkIfIsFilled();
        conflicts.setColumns(checkConflictsInColumns());
        conflicts.setRows(checkConflictsInRow());
        conflicts.setBoxes(checkConflictsInBox());
    }

    private void checkIfIsFilled() {
        int zeros = 0;
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board[y][x] == 0) zeros++;
            }
        }
        filled = (zeros == 0);
    }

    private List<Integer> checkConflictsInRow() {
        List<Integer> conflictsInRows = new ArrayList<>();
        List<Integer> mem = new ArrayList<>();

        for (int row = 0; row < 9; row++) {
            mem.clear();
            for (int col = 0; col < 9; col++) mem.add(board[row][col]);

            if (checkForDuplicates(mem)) conflictsInRows.add(row);
        }
        return conflictsInRows;
    }

    private List<Integer> checkConflictsInColumns() {
        List<Integer> conflictsInColumns = new ArrayList<>();
        List<Integer> mem = new ArrayList<>();

        for (int col = 0; col < 9; col++) {
            mem.clear();
            for (int row = 0; row < 9; row++) mem.add(board[row][col]);

            if (checkForDuplicates(mem)) conflictsInColumns.add(col);
        }
        return conflictsInColumns;
    }


    private List<Integer> checkConflictsInBox() {
        List<Integer> conflictsInBoxes = new ArrayList<>();
        List<Integer> mem = new ArrayList<>();
        int startRow;
        int startCol;

        for (int box = 0; box < 9; box++) {

            mem.clear();

            switch (box) {
                case 0 -> {
                    startRow = 0;
                    startCol = 0;
                }
                case 1 -> {
                    startRow = 0;
                    startCol = 3;
                }
                case 2 -> {
                    startRow = 0;
                    startCol = 6;
                }
                case 3 -> {
                    startRow = 3;
                    startCol = 0;
                }
                case 4 -> {
                    startRow = 3;
                    startCol = 3;
                }
                case 5 -> {
                    startRow = 3;
                    startCol = 6;
                }
                case 6 -> {
                    startRow = 6;
                    startCol = 0;
                }
                case 7 -> {
                    startRow = 6;
                    startCol = 3;
                }
                case 8 -> {
                    startRow = 6;
                    startCol = 6;
                }
                default -> throw new IllegalStateException("Unexpected value: " + box);
            }

            for (int row = startRow; row < startRow + 3; row++) {
                for (int col = startCol; col < startCol + 3; col++) {
                    mem.add(board[row][col]);
                }
            }

            if (checkForDuplicates(mem)) conflictsInBoxes.add(box);
        }
        return conflictsInBoxes;
    }

    private boolean checkForDuplicates(List<Integer> list) {
        list.removeAll(Collections.singletonList(0));
        Set<Integer> set = new HashSet<>(list);
        return set.size() < list.size();
    }
}
