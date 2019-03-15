import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeneratingVectors {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int length = Integer.parseInt(reader.readLine());
    int[] vector = new int[length];
    generate(0, vector);
  }

  private static void generate(int index, int[] vector) {
    if (index == vector.length){
      System.out.println(getVectorLine(vector));
    } else {
      for (int i = 0; i <= 1 ; i++) {
        vector[index] = i;
        generate(index+1, vector);
      }
    }

  }

  private static String getVectorLine(int[] vector) {
    StringBuilder sb = new StringBuilder();
    for (int i : vector) {
      sb.append(i);
    }
    return sb.toString();
  }
}
