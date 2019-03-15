import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {

  private static int[] array;
  private static int[] tempArray;

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    array = Arrays
        .stream(reader.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    tempArray = new int[array.length];

    sort(0, array.length - 1);
    print();
  }

  private static void print() {
    StringBuilder sb = new StringBuilder();
    Arrays.stream(array).forEach(n->sb.append(n).append(" "));
    System.out.println(sb.toString().trim());
  }

  private static void sort(int low, int high) {
    if (low < high){
      int middle = low + (high - low)/2;
      sort(low, middle);
      sort(middle+1, high);
      merge(low, middle, high);
    }
    
  }

  private static void merge(int low, int middle, int high) {
    for (int i = low; i <= high; i++) {
      tempArray[i] = array[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;

    while (i <= middle && j <= high) {
      if (tempArray[i] <= tempArray[j]) {
        array[k] = tempArray[i];
        i++;
      } else {
        array[k] = tempArray[j];
        j++;
      }
      k++;
    }

    while (i <= middle) {
      array[k] = tempArray[i];
      k++;
      i++;
    }
  }


}
