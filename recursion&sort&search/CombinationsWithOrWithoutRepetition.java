import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationsWithOrWithoutRepetition {
  private static int[] combination;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int number = Integer.parseInt(reader.readLine());
    int count = Integer.parseInt(reader.readLine());
    combination = new int[count];

    generate(0, count, number, 1);
  }

  private static void generate(int index, int count, int number, int first) {
    if (index < count) {
      for (int i = first; i <= number; i++) {
        combination[index] = i;
        //generate(index + 1, count, number, i); //with repetition
        generate(index + 1, count, number, i+1); // without repetition
      }
    } else {
      System.out.println(getLine());
    }
  }

  private static String getLine() {
    StringBuilder sb = new StringBuilder();

    for (int i : combination) {
      sb.append(i).append(" ");
    }
    return sb.toString().trim();
  }
}
