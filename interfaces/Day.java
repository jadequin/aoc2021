package interfaces;

import java.nio.file.Path;

import helpers.FileReader;

public abstract class Day implements IDay {
  private int day;
  protected FileReader fileReaderTill;
  protected FileReader fileReaderLiv;

  public Day(int day) {
    this.day = day;
    this.fileReaderTill = new FileReader(Path.of(String.format("days/d%02d/input-till", day))); 
    this.fileReaderLiv = new FileReader(Path.of(String.format("days/d%02d/input-liv", day))); 
  }

  public void printResult() {
    System.out.printf(
      "+++ Tag %d +++\n\tPart 1:\n\t\tLiv --> %s\n\t\tTill --> %s\n\tPart 2:\n\t\tLiv --> %s\n\t\tTill --> %s\n\n", 
      day,
      resultLivPart1() == null ? "Keine Lösung" : resultLivPart1(),
      resultTillPart1() == null ? "Keine Lösung" : resultTillPart1(),
      resultLivPart2() == null ? "Keine Lösung" : resultLivPart2(),
      resultTillPart2() == null ? "Keine Lösung" : resultTillPart2()
    );
  }
}
