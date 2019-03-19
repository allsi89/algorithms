import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConnectedAreasInMatrix {
  private static Cell[][] matrix;
  private static List<Cell> area = new ArrayList<>();
  private static List<List<Cell>> areas = new LinkedList<>();
  private static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int rows = Integer.parseInt(reader.readLine());
    int cols = Integer.parseInt(reader.readLine());
    matrix = getMatrix(rows, cols, reader);
    visited = new boolean[rows][cols];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (isValid(i, j)) {
          area = new LinkedList<>();
          areas.add(area);
          findAreas(i, j);
        }
      }
    }

    System.out.println("Total areas found: " + areas.size());
    final int[] count = {0};
    areas.stream().sorted((a1, a2)->{
      int comp = Integer.compare(a2.size(), a1.size());
      if (comp == 0){
        comp = Integer.compare(a1.get(0).getRow(), a2.get(0).getRow());
        if (comp == 0){
          comp = Integer.compare(a1.get(0).getCol(), a2.get(0).getCol());
        }
      }
      return comp;
    }).forEach(a->{
      count[0]++;
      System.out.println(String.format("Area #%d at (%d, %d), size: %d",
          count[0], a.get(0).getRow(), a.get(0).getCol(), a.size()));
        });

  }

  private static void findAreas(int row, int col) {
    if (!isValid(row, col)) {
      return;
    }
    area.add(matrix[row][col]);
    visited[row][col] = true;
    findAreas(row, col + 1);
    findAreas(row + 1, col);
    findAreas(row, col - 1);
    findAreas(row - 1, col);
  }



  private static boolean isValid(int row, int col) {
    return row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length &&
        !visited[row][col] && !matrix[row][col].getValue().equals('*');
  }

  private static Cell[][] getMatrix(int rows, int cols, BufferedReader reader) throws IOException {
    matrix = new Cell[rows][cols];
    for (int row = 0; row < rows; row++) {
      String line = reader.readLine();
      for (int col = 0; col < cols; col++) {
        matrix[row][col] = new Cell(row, col, line.charAt(col));
      }
    }
    return matrix;
  }

  private static class Cell {
    private int row;
    private int col;
    private Character value;

    public Cell() {
    }

    public Cell(int row, int col, Character value) {
      this.row = row;
      this.col = col;
      this.value = value;
    }

    public int getRow() {
      return row;
    }

    public int getCol() {
      return col;
    }

    public Character getValue() {
      return value;
    }
  }
}
