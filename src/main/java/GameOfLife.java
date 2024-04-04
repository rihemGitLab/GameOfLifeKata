import com.kata.gameoflife.enums.CellState;
import com.kata.gameoflife.model.cell.AliveCell;
import com.kata.gameoflife.model.cell.Cell;
import com.kata.gameoflife.model.cell.DeadCell;
import com.kata.gameoflife.model.grid.Grid;
import com.kata.gameoflife.service.NextGenerationCalculator;
import com.kata.gameoflife.service.NextGenerationCalculatorImpl;

public class GameOfLife {
    public static void main(String[] args) {
        // Création d'une grille initiale
        Cell[][] initialCells = {
                {createCell(CellState.DEAD), createCell(CellState.DEAD), createCell(CellState.DEAD), createCell(CellState.DEAD)},
                {createCell(CellState.DEAD), createCell(CellState.DEAD), createCell(CellState.ALIVE), createCell(CellState.DEAD)},
                {createCell(CellState.DEAD), createCell(CellState.ALIVE), createCell(CellState.ALIVE), createCell(CellState.DEAD)},
                {createCell(CellState.DEAD), createCell(CellState.DEAD), createCell(CellState.DEAD), createCell(CellState.DEAD)}
        };
        Grid initialGrid = new Grid(initialCells);

        // Calcul de la prochaine génération
        NextGenerationCalculator nextGenCalculator = new NextGenerationCalculatorImpl();
        Grid nextGeneration = nextGenCalculator.calculateNextGeneration(initialGrid);

        // Affichage de la prochaine génération
        System.out.println("Generation 2:");
        nextGenCalculator.printGrid(nextGeneration);
    }

    public static Cell createCell(CellState state) {
        return state == CellState.ALIVE ? new AliveCell() : new DeadCell();
    }
}
