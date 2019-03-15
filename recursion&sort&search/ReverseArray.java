import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseArray {
  private static int[] numbers;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    numbers = Arrays
        .stream(reader.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    reverse(numbers.length - 1, 0);
    print();
  }

  private static void print() {
    StringBuilder sb = new StringBuilder();
    for (int number : numbers) {
      sb.append(number).append(" ");
    }
    System.out.println(sb.toString().trim());
  }

  private static void reverse(int startIndex, int index) {
    if (startIndex <= (numbers.length - 1)/2) {
      return;
    }
    int temp = numbers[startIndex];
    numbers[startIndex] = numbers[index];
    numbers[index] = temp;
    reverse(startIndex - 1, index + 1);
  }
}
