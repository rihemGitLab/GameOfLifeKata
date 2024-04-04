package com.kata.gameoflife.model;

import com.kata.gameoflife.enums.CellState;
import com.kata.gameoflife.model.cell.AliveCell;
import com.kata.gameoflife.model.cell.Cell;
import com.kata.gameoflife.model.cell.DeadCell;
import com.kata.gameoflife.model.grid.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AliveCellTest {

    @Test
    void getSymbol_ReturnsCorrectSymbol() {
        AliveCell aliveCell = new AliveCell();
        String symbol = aliveCell.getSymbol();
        assertEquals(CellState.ALIVE.getSymbol(), symbol);
    }

    @Test
    void isAlive_ReturnsTrue() {
        AliveCell aliveCell = new AliveCell();
        assertTrue(aliveCell.isAlive());
    }

    @Test
    void evolve_GridWithLessThanTwoAliveNeighbors_ReturnsDeadCell() {
        AliveCell aliveCell = new AliveCell();
        Grid grid = new Grid(new Cell[][]{{new DeadCell(), new DeadCell(), new DeadCell()},
                {new DeadCell(), new AliveCell(), new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()}});
        Cell nextGenerationCell = aliveCell.evolve(grid, 1, 1);
        assertTrue(nextGenerationCell instanceof DeadCell);
    }


    @Test
    void evolve_GridWithTwoAliveNeighbors_ReturnsDeadCell() {
        AliveCell aliveCell = new AliveCell();
        Grid grid = new Grid(new Cell[][]{
                {new DeadCell(), new AliveCell(), new DeadCell()},
                {new DeadCell(), new AliveCell(), new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()}
        });
        Cell nextGenerationCell = aliveCell.evolve(grid, 1, 1);
        assertTrue(nextGenerationCell instanceof DeadCell);
    }

}
