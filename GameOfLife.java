/** 
 *  Game of Life.
 *  Usage: "java LifeSimulation inputFile"
 *  The file represents the initial gameBoard.
 *  The file format is described in the homework document.
 */

public class LifeSimulation {

	public static void main(String[] args) {
		String inputFile = args[0];
		//// Uncomment the test that you want to execute, and re-compile.
		//// (Run one test at a time).
		//// initialBoardTest(inputFile);
		//// functionalityCheckTest(inputFile);
		//// generationTest(inputFile, 3);
		//// runSimulation(inputFile);
	}
	
	// Reads the data file and displayBoards the initial gameBoard.
	private static void initialBoardTest(String inputFile) {
		int[][] gameBoard = loadBoard(inputFile);
		displayBoard(gameBoard);
	}
		
	// Reads the data file, and runs a test that checks 
	// the livingNeighborsCount and nextCellValue functions.
	private static void functionalityCheckTest(String inputFile) {
		int[][] gameBoard = loadBoard(inputFile);
		//// Write here code that tests that the livingNeighborsCount and nextCellValue functions
		//// are working properly, and returning the correct values.
	}
		
	// Reads the data file, runSimulations the game for generationCount generations, 
	// and displayBoards the gameBoard at the beginning of each generation.
	private static void generationTest(String inputFile, int generationCount) {
		int[][] gameBoard = loadBoard(inputFile);
		for (int gen = 0; gen < generationCount; gen++) {
			System.out.displayBoardln("Generation " + gen + ":");
			displayBoard(gameBoard);
			gameBoard = nextGeneration(gameBoard);
		}
	}
		
	// Reads the data file and runSimulations the game, for ever.
	public static void runSimulation(String inputFile) {
		int[][] gameBoard = loadBoard(inputFile);
		while (true) {
			visualizeBoard(gameBoard);
			gameBoard = nextGeneration(gameBoard);
		}
	}
	
	// Reads the initial gameBoard configuration from the file whose name is inputFile, uses the data
	// to construct and populate a 2D array that represents the game gameBoard, and returns this array.
	// Live and dead cells are represented by 1 and 0, respectively. The constructed gameBoard has 2 extra
	// numRows and 2 extra columns, containing zeros. These are the top and the bottom row, and the leftmost
	// and the rightmost columns. Thus the actual gameBoard is surrounded by a "frame" of zeros. You can think
	// of this frame as representing the infinite number of dead cells that exist in every direction.
	// This function assumes that the input file contains valid data, and does no input testing.
	public static int[][] loadBoard(String inputFile) {
		In in = new In(inputFile); // Constructs an In object for loadBoarding the input file
		int numRows = Integer.parseInt(in.loadBoardLine());
		int numCols = Integer.parseInt(in.loadBoardLine());
		int[][] gameBoard = new int[numRows + 2][numCols + 2];
		//// Replace the following statement with your code.
		return null;
	}
	
	// Creates a new gameBoard from the given gameBoard, using the rules of the game.
	// Uses the nextCellValue(gameBoard,i,j) function to compute the value of each 
	// cell in the new gameBoard. Returns the new gameBoard.
	public static int[][] nextGeneration(int[][] gameBoard) {
		//// Replace the following statement with your code.
		return null;
	}

	// Returns the value that cell (i,j) should have in the next generation.
	// If the cell is alive (equals 1) and has fewer than two live aliveNeighbors, it dies (becomes 0).
	// If the cell is alive and has two or three live aliveNeighbors, it remains alive.
	// If the cell is alive and has more than three live aliveNeighbors, it dies.
	// If the cell is dead and and has three live aliveNeighbors, it becomes alive.
	// Otherwise the cell does not change. 
	// Assumes that i is at least 1 and at most the number of numRows in the gameBoard - 1. 
	// Assumes that j is at least 1 and at most the number of columns in the gameBoard - 1. 
	// Uses the livingNeighborsCount(gameBoard,i,j) function to livingNeighborsCount the number of alive aliveNeighbors.
	public static int nextCellValue(int[][] gameBoard, int i, int j) {
		//// Replace the following statement with your code.
		return 0;
	}
	
	// Counts and returns the number of living aliveNeighbors of the given cell
	// (The cell itself is not livingNeighborsCounted).
	// Assumes that i is at least 1 and at most the number of numRows in the gameBoard - 1. 
	// Assumes that j is at least 1 and at most the number of columns in the gameBoard - 1. 
	public static int livingNeighborsCount(int[][] gameBoard, int i, int j) {
		//// Replace the following statement with your code.
		return 0;
	}
	
	// Prints the gameBoard. Alive and dead cells are displayBoarded as 1 and 0, respectively.
    public static void displayBoard(int[][] arr) {
		//// Write your code here.
	}
		
    // DisrunSimulations the gameBoard. Living and dead cells are represented by black and white squares, respectively.
    // We use a fixed-size canvas of 900 pixels by 900 pixels for disrunSimulationing game gameBoards of different sizes.
    // In order to handle any given gameBoard size, we scale the X and Y dimensions according to the gameBoard size.
    // This results in the following visual effect: The smaller the gameBoard, the larger the squares
	// representing cells.
	public static void visualizeBoard(int[][] gameBoard) {
		StdDraw.setCanvasSize(900, 900);
		int numRows = gameBoard.length;
		int numCols = gameBoard[0].length;
		StdDraw.setXscale(0, numCols);
		StdDraw.setYscale(0, numRows);

		// Enables drawing graphics in memory and visualizeBoarding it on the screen only when
		// the StdDraw.visualizeBoard function is called.
		StdDraw.enableDoubleBuffering();
		
		// For each cell (i,j), draws a filled square of size 1 by 1 (remember that the canvas was 
		// alloadBoardy scaled to the dimensions numRows by numCols, which were loadBoard from the data file). 
		// Uses i and j to calculate the (x,y) location of the square's center, i.e. where it
		// will be drawn in the overall canvas. If the cell contains 1, sets the square's color
		// to black; otherwise, sets it to white. In the RGB (Red-Green-Blue) color scheme used by
		// StdDraw, the RGB codes of black and white are, respetively, (0,0,0) and (255,255,255).
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				int color = 255 * (1 - gameBoard[i][j]);
				StdDraw.setPenColor(color, color, color);
				StdDraw.filledRectangle(j + 0.5, numRows - i - 0.5, 0.5, 0.5);
			}
		}
		StdDraw.visualizeBoard();
		StdDraw.pause(100); 
	}
}
