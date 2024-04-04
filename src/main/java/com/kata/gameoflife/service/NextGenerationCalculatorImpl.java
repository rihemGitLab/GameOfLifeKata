package com.kata.gameoflife.service;

import com.kata.gameoflife.exception.GridException;
import com.kata.gameoflife.model.cell.Cell;
import com.kata.gameoflife.model.grid.Grid;

import java.util.stream.IntStream;

public class NextGenerationCalculatorImpl implements NextGenerationCalculator {

    @Override
    public Grid calculateNextGeneration(Grid currentGeneration) {
        if (currentGeneration == null) {
            throw new GridException("Current generation cannot be null");
        }

        Cell[][] nextGenerationCells = IntStream.range(0, currentGeneration.getHeight())
                .mapToObj(i -> IntStream.range(0, currentGeneration.getWidth())
                        .mapToObj(j -> currentGeneration.getCells()[i][j].evolve(currentGeneration, i, j))
                        .toArray(Cell[]::new))
                .toArray(Cell[][]::new);

        return new Grid(nextGenerationCells);
    }

    public void printGrid(Grid grid) {
        if (grid == null) {
            throw new GridException("Grid cannot be null");
        }

        IntStream.range(0, grid.getHeight())
                .forEach(i -> {
                    IntStream.range(0, grid.getWidth())
                            .mapToObj(j -> grid.getCells()[i][j].getSymbol())
                            .forEach(System.out::print);
                    System.out.println();
                });
    }
}
