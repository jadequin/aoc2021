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
    String resLivP1 = resultLivPart1();
    String resLivP2 = resultLivPart2();
    String resTillP1 = resultTillPart1();
    String resTillP2 = resultTillPart2();

    System.out.printf(
      "+++ Tag %d +++\n\tPart 1:\n\t\tLiv --> %s\n\t\tTill --> %s\n\tPart 2:\n\t\tLiv --> %s\n\t\tTill --> %s\n\n", 
      day,
      resLivP1 == null ? "Keine Lösung" : resLivP1,
      resTillP1 == null ? "Keine Lösung" : resTillP1,
      resLivP2 == null ? "Keine Lösung" : resLivP2,
      resTillP2 == null ? "Keine Lösung" : resTillP2
    );
  }
}
