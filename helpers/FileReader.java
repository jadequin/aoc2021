package helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
  private Path path;

  public FileReader(Path path) {
    this.path = path;
  }

  public List<String> getStringList() {
    try {
      return Files.readAllLines(path);
    } catch (IOException e) {
      System.out.printf("File not found\n\t--> %s", path.toAbsolutePath().toString());
      return List.of();
    }
  }

  public List<Integer> getIntegerList() {
    return getStringList()
      .stream()
      .map(Integer::parseInt)
      .toList();
  }

  public String[] getStringArray() {
    return getStringList().toArray(String[]::new);
  }
  
  public int[] getIntegerArray() {
    return getIntegerList()
      .stream()
      .mapToInt(i->i)
      .toArray();
  }
}
