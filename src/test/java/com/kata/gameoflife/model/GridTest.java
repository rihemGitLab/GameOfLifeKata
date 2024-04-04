package com.kata.gameoflife.model;

import com.kata.gameoflife.model.cell.Cell;
import com.kata.gameoflife.model.cell.AliveCell;
import com.kata.gameoflife.model.cell.DeadCell;
import com.kata.gameoflife.model.grid.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    @Test
    void countAliveNeighbors_NoAliveNeighbors_ReturnsZero() {
        Cell[][] cells = {
                {new DeadCell(), new DeadCell(), new DeadCell()},
                {new DeadCell(), new AliveCell(), new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()}
        };
        Grid grid = new Grid(cells);

        int aliveNeighbors = grid.countAliveNeighbors(1, 1);

        assertEquals(0, aliveNeighbors);
    }

    @Test
    void countAliveNeighbors_SomeAliveNeighbors_ReturnsCorrectCount() {
        Cell[][] cells = {
                {new AliveCell(), new DeadCell(), new AliveCell()},
                {new DeadCell(), new AliveCell(), new DeadCell()},
                {new AliveCell(), new DeadCell(), new AliveCell()}
        };
        Grid grid = new Grid(cells);

        int aliveNeighbors = grid.countAliveNeighbors(1, 1);

        assertEquals(4, aliveNeighbors);
    }

    @Test
    void countAliveNeighbors_BoundaryCell_ReturnsCorrectCount() {
        Cell[][] cells = {
                {new AliveCell(), new AliveCell(), new DeadCell()},
                {new AliveCell(), new AliveCell(), new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()}
        };
        Grid grid = new Grid(cells);

        int aliveNeighbors = grid.countAliveNeighbors(0, 0);

        assertEquals(3, aliveNeighbors);
    }
}
