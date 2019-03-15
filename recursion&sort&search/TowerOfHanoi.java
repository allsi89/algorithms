import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;


public class TowerOfHanoi {
  private static int stepsTaken = 0;
  private static Deque<String> start = new ArrayDeque<>();
  private static Deque<String> end = new ArrayDeque<>();
  private static Deque<String> temp = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(reader.readLine());
    getNumbers(count);
    printRods();
    moveDisks(count, start, temp, end);

  }

  private static void moveDisks(int count, Deque<String> source, Deque<String> spare, Deque<String> destination) {

    if (count > 1) {
      moveDisks(count - 1, source, destination, spare);


      destination.push(source.pop());
      stepsTaken++;
      System.out.println("Step #" + stepsTaken + ": Moved disk");
      printRods();

      moveDisks(count - 1, spare, source, destination);
    } else {

      destination.push(source.pop());
      stepsTaken++;
      System.out.println("Step #" + stepsTaken + ": Moved disk");
      printRods();
    }
  }

  private static void printRods() {
    StringBuilder output = new StringBuilder();
    output.append("Source: ")
        .append(getReversedDequeStr(start))
        .append(System.lineSeparator())
        .append("Destination: ")
        .append(getReversedDequeStr(end))
        .append(System.lineSeparator())
        .append("Spare: ")
        .append(getReversedDequeStr(temp))
        .append(System.lineSeparator());
    System.out.println(output.toString());
  }

  private static String getReversedDequeStr(Deque<String> deque){
    if (deque.isEmpty()){
      return "";
    }
    StringBuilder sb = new StringBuilder();
    Iterator it = deque.descendingIterator();
    while (it.hasNext()){
      sb.append(it.next())
          .append(", ");
    }
    String numbers = sb.toString();
    return numbers.substring(0, numbers.length() - 2);
  }

  private static void getNumbers(int count) throws IOException {
    for (int i = count; i > 0; i--) {
      start.push(String.valueOf(i));
    }
  }
}
