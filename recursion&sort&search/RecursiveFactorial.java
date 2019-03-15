import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFactorial {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int number = Integer.parseInt(reader.readLine());
    long factorial = calcFactorial(number);
    System.out.println(factorial);
  }

  private static long calcFactorial(int number) {
    if (number == 0) {
      return 1;
    }

    return number * calcFactorial(number - 1);
  }
}
