// Grid.java
package com.kata.gameoflife.model.grid;

import com.kata.gameoflife.exception.GridException;
import com.kata.gameoflife.model.cell.Cell;

public class Grid {
    private final Cell[][] cells;

    public Grid(Cell[][] cells) {
        if (cells == null) {
            throw new GridException("Cells cannot be null");
        }
        for (Cell[] row : cells) {
            if (row == null) {
                throw new GridException("Row in cells cannot be null");
            }
            for (Cell cell : row) {
                if (cell == null) {
                    throw new GridException("Cell in cells cannot be null");
                }
            }
        }
        this.cells = cells;
    }

    public int getHeight() {
        return cells.length;
    }

    public int getWidth() {
        return cells[0].length;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int countAliveNeighbors(int row, int col) {
        int aliveNeighbors = 0;
        for (int i = Math.max(0, row - 1); i <= Math.min(cells.length - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(cells[0].length - 1, col + 1); j++) {
                if (i != row || j != col) {
                    if (cells[i][j].isAlive()) {
                        aliveNeighbors++;
                    }
                }
            }
        }
        return aliveNeighbors;
    }
}
