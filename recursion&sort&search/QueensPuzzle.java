import java.util.HashSet;

public class QueensPuzzle {
  private static boolean[][] board = new boolean[8][8];
  private static HashSet<Integer> attackedRows = new HashSet<>();
  private static HashSet<Integer> attackedCols = new HashSet<>();
  private static HashSet<Integer> attackedLeftDiagonals = new HashSet<>();
  private static HashSet<Integer> attackedRightDiagonals = new HashSet<>();
  public static void main(String[] args) {
    putQueens(0);
  }

  private static void putQueens( int row) {
    if (row >= 8) {
      printSolution();
    } else {
      for (int col = 0; col < 8; col++) {
        if (canPlaceQueen(row, col)) {
          markAllAttackedPositions(row, col);
          putQueens( row + 1);
          unmarkAllAttackedPositions(row, col);
        }

      }
    }
  }

  private static void unmarkAllAttackedPositions(int row, int col) {
    int leftDiagonal = row + col;
    int rightDiagonal = row - col;
    board[row][col] = false;
    attackedRows.remove(row);
    attackedCols.remove(col);
    attackedLeftDiagonals.remove(leftDiagonal);
    attackedRightDiagonals.remove(rightDiagonal);
  }

  private static void markAllAttackedPositions(int row, int col) {
    int leftDiagonal = row + col;
    int rightDiagonal = row - col;
    board[row][col] = true;
    attackedRows.add(row);
    attackedCols.add(col);
    attackedLeftDiagonals.add(leftDiagonal);
    attackedRightDiagonals.add(rightDiagonal);

  }

  private static boolean canPlaceQueen(int row, int col) {
    int leftDiagonal = row + col;
    int rightDiagonal = row - col;
    return !attackedCols.contains(col)
        && !attackedLeftDiagonals.contains(leftDiagonal)
        && !attackedRightDiagonals.contains(rightDiagonal)
        && !attackedRows.contains(row);
  }

  private static void printSolution() {
    StringBuilder line = new StringBuilder();
    for (boolean[] row : board) {
      StringBuilder sb = new StringBuilder();

      for (boolean cell : row) {
        if (cell){
          sb.append("*")
              .append(" ");
        } else {
          sb.append("-")
              .append(" ");
        }

      }

      line.append(sb.toString().trim()).append(System.lineSeparator());
    }
    System.out.println(line.toString());
  }
}
