package solutions.d25;

import java.nio.file.Paths;
import skeleton.Skeleton;

public class Solution {
  private static String resultLiv() {
    String[] stringArray = Skeleton.getStringArray(Paths.get("input-liv"));
    int[] intArray = Skeleton.getIntArray(Paths.get("input-liv"));

    // Lösung Liv...

    // falls int als Lösung:
    // return Integer.toString(42);
    return "Keine Lösung";
  }

  private static String resultTill() {
    String[] stringArray = Skeleton.getStringArray(Paths.get("input-till"));
    int[] intArray = Skeleton.getIntArray(Paths.get("input-till"));

    // Lösung Till...

    return "Keine Lösung";
  }
 
  public static void main(String[] args) {
    Skeleton.printResults(resultLiv(), resultTill());
  }
}
