package com.kata.gameoflife.service;

import com.kata.gameoflife.enums.CellState;
import com.kata.gameoflife.exception.GridException;
import com.kata.gameoflife.model.cell.AliveCell;
import com.kata.gameoflife.model.cell.Cell;
import com.kata.gameoflife.model.cell.DeadCell;
import com.kata.gameoflife.model.grid.Grid;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class NextGenerationCalculatorImplTest {

    @Test
    void calculateNextGeneration_NullGrid_ThrowsGridException() {
        NextGenerationCalculatorImpl calculator = new NextGenerationCalculatorImpl();
        assertThrows(GridException.class, () -> calculator.calculateNextGeneration(null));
    }

    @Test
    void calculateNextGeneration_NullGrid_ThrowsException() {
        NextGenerationCalculatorImpl calculator = new NextGenerationCalculatorImpl();

        assertThrows(GridException.class, () -> calculator.calculateNextGeneration(null));
    }

    @Test
    void printGrid_NullGrid_ThrowsException() {
        NextGenerationCalculatorImpl calculator = new NextGenerationCalculatorImpl();

        assertThrows(GridException.class, () -> calculator.printGrid(null));
    }
    @Test
    void calculateNextGeneration_SingleAliveCellWithNoNeighbors_ReturnsDeadCell() {
        NextGenerationCalculatorImpl calculator = new NextGenerationCalculatorImpl();
        Cell[][] singleAliveCell = {{new AliveCell()}};
        Grid grid = new Grid(singleAliveCell);

        // Act
        Grid nextGeneration = calculator.calculateNextGeneration(grid);

        // Assert
        assertTrue(nextGeneration.getCells()[0][0] instanceof DeadCell);
    }


    @Test
    void calculateNextGeneration_SingleAliveCellWithFourNeighbors_ReturnsDeadCell() {
        // Arrange
        NextGenerationCalculatorImpl calculator = new NextGenerationCalculatorImpl();
        Cell[][] singleAliveCellWithNeighbors = {
                {new AliveCell(), new AliveCell(), new AliveCell()},
                {new AliveCell(), new AliveCell(), new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()}
        };
        Grid grid = new Grid(singleAliveCellWithNeighbors);

        Grid nextGeneration = calculator.calculateNextGeneration(grid);

        assertTrue(nextGeneration.getCells()[1][1] instanceof DeadCell);
    }

    @Test
    void calculateNextGeneration_AliveCellWithLessThanTwoAliveNeighbors_ReturnsDeadCell() {
        // Arrange
        NextGenerationCalculatorImpl calculator = new NextGenerationCalculatorImpl();
        Cell[][] cells = {
                {new AliveCell(), new DeadCell(), new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()}
        };
        Grid grid = new Grid(cells);

        // Act
        Grid nextGeneration = calculator.calculateNextGeneration(grid);

        // Assert
        assertTrue(nextGeneration.getCells()[0][0] instanceof DeadCell);
    }

    @Test
    void calculateNextGeneration_AliveCellWithMoreThanThreeAliveNeighbors_ReturnsDeadCell() {
        NextGenerationCalculatorImpl calculator = new NextGenerationCalculatorImpl();
        Cell[][] cells = {
                {new AliveCell(), new AliveCell(), new AliveCell()},
                {new AliveCell(), new AliveCell(), new AliveCell()},
                {new AliveCell(), new DeadCell(), new DeadCell()}
        };
        Grid grid = new Grid(cells);

        Grid nextGeneration = calculator.calculateNextGeneration(grid);

        assertTrue(nextGeneration.getCells()[1][1] instanceof DeadCell);
    }

    @Test
    void calculateNextGeneration_DeadCellWithExactlyThreeAliveNeighbors_ReturnsAliveCell() {
        NextGenerationCalculatorImpl calculator = new NextGenerationCalculatorImpl();
        Cell[][] cells = {
                {new AliveCell(), new AliveCell(), new AliveCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()}
        };
        Grid grid = new Grid(cells);

        Grid nextGeneration = calculator.calculateNextGeneration(grid);

        assertTrue(nextGeneration.getCells()[1][1] instanceof AliveCell);
    }


    @Test
    void calculateNextGeneration_AliveCellWithThreeAliveNeighbors_ReturnsAliveCell() {
        NextGenerationCalculatorImpl calculator = new NextGenerationCalculatorImpl();
        Cell[][] cells = {
                {new AliveCell(), new AliveCell(), new AliveCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()}
        };
        Grid grid = new Grid(cells);

        Grid nextGeneration = calculator.calculateNextGeneration(grid);

        assertTrue(nextGeneration.getCells()[1][1] instanceof AliveCell);
    }

    @Test
    void calculateNextGeneration_DeadCellWithLessThanThreeAliveNeighbors_ReturnsDeadCell() {
        NextGenerationCalculatorImpl calculator = new NextGenerationCalculatorImpl();
        Cell[][] cells = {
                {new AliveCell(), new AliveCell(), new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()},
                {new DeadCell(), new DeadCell(), new DeadCell()}
        };
        Grid grid = new Grid(cells);

        Grid nextGeneration = calculator.calculateNextGeneration(grid);

        assertTrue(nextGeneration.getCells()[0][2] instanceof DeadCell);
    }

    @Test
    void calculateNextGeneration_DeadCellWithMoreThanThreeAliveNeighbors_ReturnsDeadCell() {
        NextGenerationCalculatorImpl calculator = new NextGenerationCalculatorImpl();
        Cell[][] cells = {
                {new AliveCell(), new AliveCell(), new AliveCell()},
                {new AliveCell(), new DeadCell(), new AliveCell()},
                {new AliveCell(), new AliveCell(), new AliveCell()}
        };
        Grid grid = new Grid(cells);

        Grid nextGeneration = calculator.calculateNextGeneration(grid);

        assertTrue(nextGeneration.getCells()[1][1] instanceof DeadCell);
    }

}
