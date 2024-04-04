package com.kata.gameoflife.service;


import com.kata.gameoflife.model.grid.Grid;

public interface NextGenerationCalculator {
    Grid calculateNextGeneration(Grid currentGeneration);
    void printGrid(Grid grid);

    }
