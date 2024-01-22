import java.util.Arrays;

public class GameOfLife {
    private int rows;
    private int cols;
    private boolean[][] board;

    public GameOfLife(String filename) {
        readInitialState(filename);
    }

    private void readInitialState(String filename) {
        In in = new In(filename);
        rows = in.readInt();
        cols = in.readInt();
        board = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = in.readLine();
            for (int j = 0; j < line.length(); j++) {
                board[i][j] = (line.charAt(j) == 'x');
            }
        }
    }

    private int countNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void update() {
        boolean[][] newBoard = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbors = countNeighbors(i, j);
                if (board[i][j]) {
                    newBoard[i][j] = neighbors == 2 || neighbors == 3;
                } else {
                    newBoard[i][j] = neighbors == 3;
                }
            }
        }
        board = newBoard;
    }

    public void display() {
        StdDraw.clear();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j]) {
                    StdDraw.filledSquare(j, rows - i - 1, 0.5);
                }
            }
        }
        StdDraw.show();
    }

    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(args[0]);
        while (true) {
            game.display();
            game.update();
            StdDraw.pause(100); // delay for 100 milliseconds
        }
    }
}
