package interfaces;

import java.nio.file.Path;

import helpers.FileReader;

public abstract class Day implements IDay {
  private int day;
  protected FileReader fileReaderTill;
  protected FileReader fileReaderLiv;

  public Day(int day) {
    this.day = day;
    this.fileReaderTill = new FileReader(Path.of(String.format("d%02d/input-till", day))); 
    this.fileReaderLiv = new FileReader(Path.of(String.format("d%02d/input-liv", day))); 
  }

  public void printResult() {
    System.out.printf(
      "Lösung für Tag %s:\n\tLiv --> %s\n\tTill --> %s\n\n", 
      day,
      resultLiv() == null ? "Keine Lösung" : resultLiv(),
      resultTill() == null ? "Keine Lösung" : resultTill());
  }
}
