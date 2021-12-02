package days.d02;

import interfaces.Day;

public class Day2 extends Day {

  public Day2() {
    super(2);
  }

  @Override
  public String resultLivPart1() {
    // 1. Array in einer Variable abspeichern 
    String[] zeilen = fileReaderLiv.getStringArray();
    // 2. Zählervariablen anlegen (Wieviele werden benötigt? Welcher Datentyp? Initialwert?)
    int forward, down, up, depth = 0, horizontal = 0;
    // 3. Schleife über alle Elemente anlegen
    for(int i = 0; i < zeilen.length; i++ ) {
      //   4. Zeile mit split() in seine Bestandteile aufteilen (Wie funktioniert split? An welchem Character muss gesplittet werden?)
      //   5. Mit der switch-Anweisung abhängig von der Richtung eine Entscheidung treffen und die entsprechende Variable modifizieren
      if(zeilen[i].split(" ")[0].equals("forward")) {
        horizontal += Integer.parseInt(zeilen[i].split(" ")[1]); 
      }
      else if(zeilen[i].split(" ")[0].equals("down")) {
        depth += Integer.parseInt(zeilen[i].split(" ")[1]);
      }
      else if(zeilen[i].split(" ")[0].equals("up")) {
        depth -= Integer.parseInt(zeilen[i].split(" ")[1]);
      }
    }
    return Integer.toString(horizontal * depth);
  }

  @Override
  public String resultLivPart2() {
    // TODO Auto-generated method stub
    String[] zeilen = fileReaderLiv.getStringArray();
    int forward, down, up, aim = 0, depth = 0, horizontal = 0;

    for(int i = 0; i < zeilen.length; i++ ) {
      int value = Integer.parseInt(zeilen[i].split(" ")[1]);

      if(zeilen[i].split(" ")[0].equals("forward")) {
        horizontal += value;
        depth += aim * value; 
      }
      else if(zeilen[i].split(" ")[0].equals("down")) {
        aim += value;
      }
      else if(zeilen[i].split(" ")[0].equals("up")) {
        aim -= value;
      }
    }

    return Integer.toString(horizontal * depth);
  }

  @Override
  public String resultTillPart1() {
    var rows = fileReaderTill.getStringArray();
    int x = 0, y = 0;
    
    for (String row : rows) {
      var fields = row.split(" ");
      int value = Integer.parseInt(fields[1]);
      
      switch(fields[0]) {
        case "forward":
          x += value; break;
        case "up":
          y -= value; break;
        case "down":
          y += value; break;
      }
    }

    return "" + x * y;
  }

  @Override
  public String resultTillPart2() {
    var rows = fileReaderTill.getStringArray();
    int x = 0, y = 0, aim = 0;
    
    for (String row : rows) {
      var fields = row.split(" ");
      int value = Integer.parseInt(fields[1]);
      
      switch(fields[0]) {
        case "forward":
          y += aim * value;
          x += value; break;
        case "up":
          aim -= value; break;
        case "down":
          aim += value; break;
      }
    }

    return "" + x * y;
  }
}
