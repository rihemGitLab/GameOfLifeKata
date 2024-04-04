package com.kata.gameoflife.model.cell;

import com.kata.gameoflife.model.grid.Grid;


public interface Cell {
    String getSymbol();
    Cell evolve(Grid grid, int row, int col);
    public boolean isAlive();

    }

