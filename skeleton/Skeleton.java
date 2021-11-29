package skeleton;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Skeleton {
  /**
   * 
   * @param resLiv
   * Ergebnis von Liv als String
   * @param resTill
   * Ergebnis von Till als String
   */
  public static void printResults(String resLiv, String resTill) {
    System.out.format("Livs Ergebnis: %s\n", resLiv);
    System.out.format("Tills Ergebnis: %s\n", resTill);
  }

  /**
   * Nicht verändern!
   * 
   * @param path
   * Pfad zur Input-Datei
   * @return 
   * Gibt den Input als int-Array zurück 
   */
  public static int[] getIntArray(Path path) {
    return getIntegerList(path)
    .stream()
    .mapToInt(i->i)
    .toArray();
  }

  /**
   * 
   * @param path
   * Pfad zur Input-Datei
   * @return
   * Gibt den Input als Liste von Integern zurück
   */
  public static List<Integer> getIntegerList(Path path) {
    return getStringList(path)
    .stream()
    .map(Integer::parseInt)
    .toList();
  }

  /**
   * Nicht verändern!
   * 
   * @param path
   * Pfad zur Input-Datei
   * @return 
   * Gibt den Input als String-Array zurück 
   */
  public static String[] getStringArray(Path path) {
    return getStringList(path).toArray(String[]::new);
  }

  /**
   * Nicht verändern!
   * 
   * @param path
   * Pfad zur Input-Datei
   * @return 
   * Gibt den Input als Liste von Strings zurück 
   */
  public static List<String> getStringList(Path path) {
    try {
      return Files.readAllLines(path);
    } catch(Exception e) {
      return List.of();
    }
  }
}







