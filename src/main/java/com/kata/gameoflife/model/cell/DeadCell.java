package com.kata.gameoflife.model.cell;

import com.kata.gameoflife.enums.CellState;
import com.kata.gameoflife.exception.GridException;
import com.kata.gameoflife.exception.InvalidCellStateException;
import com.kata.gameoflife.model.grid.Grid;

public class DeadCell implements Cell {
    private final CellState state=CellState.DEAD;



    @Override
    public String getSymbol() {
        return state.getSymbol();
    }

    @Override
    public boolean isAlive() {
        return state == CellState.ALIVE;
    }

    @Override
    public Cell evolve(Grid grid, int row, int col) {
        if (grid == null) {
            throw new GridException("Grid cannot be null");
        }
        int aliveNeighbors = grid.countAliveNeighbors(row, col);
        return (aliveNeighbors == 3) ? new AliveCell() : this;
    }
}
