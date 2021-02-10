package com.sudoku;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Conflicts {
    private List<Integer> columns = new ArrayList<>();
    private List<Integer> rows = new ArrayList<>();
    private List<Integer> boxes = new ArrayList<>();
}
