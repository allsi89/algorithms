import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursiveArraySum {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int[] numbers = Arrays.stream(reader.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    int sum = sum(numbers, 0);
    System.out.println(sum);

  }

  static int sum(int[] array, int index) {
    if (index == array.length){
      return 0;
    }

    int currentSum = array[index] + sum(array, index + 1);

    return currentSum;
  }
}
