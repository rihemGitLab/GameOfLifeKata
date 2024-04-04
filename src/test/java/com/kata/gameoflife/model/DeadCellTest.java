package com.kata.gameoflife.model;

import com.kata.gameoflife.enums.CellState;
import com.kata.gameoflife.exception.GridException;
import com.kata.gameoflife.model.cell.AliveCell;
import com.kata.gameoflife.model.cell.Cell;
import com.kata.gameoflife.model.cell.DeadCell;
import com.kata.gameoflife.model.grid.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DeadCellTest {

    @Test
    void getSymbol_ReturnsDeadSymbol() {
        DeadCell deadCell = new DeadCell();
        assertEquals(CellState.DEAD.getSymbol(), deadCell.getSymbol());
    }

    @Test
    void isAlive_ReturnsFalse() {
        DeadCell deadCell = new DeadCell();
        assertFalse(deadCell.isAlive());
    }

    @Test
    void evolve_GridWithThreeAliveNeighbors_ReturnsAliveCell() {
        DeadCell deadCell = new DeadCell();
        Grid grid = new Grid(new Cell[][]{
                {new AliveCell(), new AliveCell(), new AliveCell()},
                {new DeadCell(), deadCell, new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()}
        });
        Cell nextGenerationCell = deadCell.evolve(grid, 1, 1);
        assertTrue(nextGenerationCell instanceof AliveCell);
    }

    @Test
    void evolve_GridWithLessThanThreeAliveNeighbors_ReturnsDeadCell() {
        DeadCell deadCell = new DeadCell();
        Grid grid = new Grid(new Cell[][]{
                {new AliveCell(), new AliveCell(), new DeadCell()},
                {new DeadCell(), deadCell, new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()}
        });
        Cell nextGenerationCell = deadCell.evolve(grid, 1, 1);
        assertTrue(nextGenerationCell instanceof DeadCell);
    }

    @Test
    void evolve_GridWithMoreThanThreeAliveNeighbors_ReturnsDeadCell() {
        DeadCell deadCell = new DeadCell();
        Grid grid = new Grid(new Cell[][]{
                {new AliveCell(), new AliveCell(), new AliveCell()},
                {new AliveCell(), deadCell, new AliveCell()},
                {new AliveCell(), new AliveCell(), new AliveCell()}
        });
        Cell nextGenerationCell = deadCell.evolve(grid, 1, 1);
        assertTrue(nextGenerationCell instanceof DeadCell);
    }

    @Test
    void evolve_NullGrid_ThrowsGridException() {
        DeadCell deadCell = new DeadCell();
        assertThrows(GridException.class, () -> deadCell.evolve(null, 1, 1));
    }

}

