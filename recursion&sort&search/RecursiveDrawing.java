import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveDrawing {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int index = Integer.parseInt(reader.readLine());
    print(index);

  }

  private static void print(int index) {
    if (index == 0) {
      return;
    }
    System.out.println(getLine('*', index));
    print(index - 1);
    System.out.println(getLine('#', index));
  }

  private static String getLine(Character s, int index) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= index; i++) {
       sb.append(s);
    }
    return sb.toString();
  }

}
