import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GeneratingCombinations {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int[] set = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int length = Integer.parseInt(reader.readLine());
    int[] vector = new int[length];
    generate(set, vector, 0, 0);

  }

  private static void generate(int[] set, int[] vector, int index, int border) {
    if (index == vector.length){
      System.out.println(getVectorLine(vector));
    } else {
      for (int i = border; i < set.length; i++) {
        vector[index] = set[i];
        generate(set, vector, index+1, i+1);
      }
    }


  }

  private static String getVectorLine(int[] vector) {
    StringBuilder sb = new StringBuilder();
    for (int i : vector) {
      sb.append(i)
      .append(" ");
    }
    return sb.toString().trim();
  }



}
