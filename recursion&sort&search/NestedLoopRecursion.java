import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestedLoopRecursion {
  private static int[] combination;
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int number = Integer.parseInt(reader.readLine());
    combination = new int[number];
    
    generate(0, number);
  }

  private static void generate(int index, int number) {
    if (index == number) {
      System.out.println(getLine());
    } else {
      for (int i = 0; i < number; i++) {
        combination[index] = i + 1;
        generate(index + 1 , number);
      }
    }
  }

  private static String getLine() {
    StringBuilder sb = new StringBuilder();
    for (int number : combination) {
      sb.append(number)
          .append(" ");
    }
   return sb.toString().trim();
  }
}
