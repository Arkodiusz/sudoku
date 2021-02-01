package com.sudoku;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Cell {
    private int x;
    private int y;
    private int val;
}

