import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PathsInLabyrinth {
  private static Character[][] labyrinth;
  private static List<Character> path = new ArrayList<>();
  private static List<Cell> visitedCells = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int rows = Integer.parseInt(reader.readLine());
    int cols = Integer.parseInt(reader.readLine());
    labyrinth = new Character[rows][cols];
    for (int row = 0; row < rows; row++) {
      String line = reader.readLine();
      for (int col = 0; col < cols; col++) {
        labyrinth[row][col] = line.charAt(col);
      }
    }

    findPaths(0, 0, 'S');

  }

  private static void findPaths(int row, int col, char direction) {
    if (!isInBounds(row, col)) {
      return;
    }
    path.add(direction);

    if (isExit(row, col)) {
      printPath();
    } else if (!isVisited(row, col) && isFree(row, col)) {
      mark(row, col);
      findPaths(row, col + 1, 'R');
      findPaths(row + 1, col, 'D');
      findPaths(row, col - 1, 'L');
      findPaths(row - 1, col, 'U');
      unmark(row, col);
    }

    path.remove(path.size() - 1);

  }

  private static void unmark(int row, int col) {
    visitedCells
        .stream()
        .filter(c -> c.getRow() == row && c.getCol() == col)
        .findFirst().ifPresent(cell -> visitedCells.remove(cell));
  }

  private static void mark(int row, int col) {
    visitedCells.add(new Cell(row, col));
  }

  private static boolean isFree(int row, int col) {
    return labyrinth[row][col].equals('-');
  }

  private static boolean isVisited(int row, int col) {
    for (Cell visitedCell : visitedCells) {
      if (visitedCell.getRow() == row && visitedCell.getCol() == col) {
        return true;
      }
    }
    return false;
  }

  private static void printPath() {
    StringBuilder sb = new StringBuilder();
    for (Character ch : path) {
      sb.append(ch);
    }
    if (sb.toString().startsWith("S")){
      System.out.println(sb.toString().substring(1));
    } else {
      System.out.println(sb.toString());
    }
  }

  private static boolean isExit(int row, int col) {
    return labyrinth[row][col].equals('e');
  }

  private static boolean isInBounds(int row, int col) {
    return row >= 0 && col >= 0 && row < labyrinth.length && col < labyrinth[row].length;
  }

  private static class Cell {
    private int row;
    private int col;

    public Cell() {
    }

    public Cell(int row, int col) {
      this.row = row;
      this.col = col;
    }

    public int getRow() {
      return row;
    }

    public int getCol() {
      return col;
    }
  }
}
