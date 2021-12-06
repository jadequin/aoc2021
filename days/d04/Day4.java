package days.d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import interfaces.Day;

public class Day4 extends Day {
  
  public Day4() {
    super(4);
  }

  @Override
  public String resultLivPart1() {
    // TODO Auto-generated method stub
    return null;
  }
  
  @Override
  public String resultLivPart2() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String resultTillPart1() {

    String input = fileReaderTill.getString();
    
    int[] numbers = Arrays.stream(input.substring(0, input.indexOf("\r\n")).trim().split(","))
    .mapToInt(Integer::parseInt)
    .toArray();
    
    Board[] boards = Arrays.stream(input.substring(input.indexOf("\r\n\r\n")).trim().split("\r\n\r\n"))
    .map(x -> new Board(x))
    .toArray(Board[]::new);
    
    for (var n : numbers)
      for (var b : boards) {
        Integer s = b.shot(n);
        if (s != null)
          return "" + s;
      }

    return null;
  }

  @Override
  public String resultTillPart2() {

    String input = fileReaderTill.getString();
    
    int[] numbers = Arrays.stream(input.substring(0, input.indexOf("\r\n")).trim().split(","))
    .mapToInt(Integer::parseInt)
    .toArray();
    
    Board[] boards = Arrays.stream(input.substring(input.indexOf("\r\n\r\n")).trim().split("\r\n\r\n"))
    .map(x -> new Board(x))
    .toArray(Board[]::new);
    
    Integer res = null;
    for (var n : numbers)
      for (var b : boards) {
        if (!b.bingo) {
          Integer s = b.shot(n);
          if (s != null)
            res = s;
        }
      }

    return "" + res;
  }

  class Board {
    boolean bingo = false;
    int[][] field;
  
    Board(String strBoard) {
      this.field = parseBoard(strBoard);
    }
  
    private int[][] parseBoard(String strBoard) {
      int[][] res = new int[5][5];
  
      String[] rows = strBoard.trim().split("\r\n");
      for (int i = 0; i < res.length; i++)
        res[i] = Arrays.stream(rows[i].trim().split("\\s+"))
          .mapToInt(Integer::parseInt)
          .toArray();
      
      return res;
    }

    @Override
    public String toString() {
      var sb = new StringBuilder();
      for(int i = 0; i < field.length; i++) {
        for(int j = 0; j < field[i].length; j++)
          sb.append(String.format("%3d", field[i][j]));
        sb.append("\n");
      }
      return sb.toString();
    }

    Integer shot(int num) {
      boolean hit = false;
      int finY = -1, finX = -1;
      for (int y = 0; y < field.length; y++) {
        for (int x = 0; x < field[y].length; x++) {
          if (field[y][x] == num) {
            field[y][x] = -1;
            finY = y;
            finX = x;
            hit = true;
          }
        }
      }

      if (hit) {
        int sumY = 0, sumX = 0;
        for (int i = 0; i < field.length; i++) {
          sumY += field[finY][i];
          sumX += field[i][finX];
        }
        if (sumY == -5 || sumX == -5) {
          int res = 0;
          for (int i = 0; i < field.length; i++)
            for(int j = 0; j < field[i].length; j++)
              res += field[i][j] == -1 ? 0 : field[i][j];

          bingo = true;
          return res * num;
        }
      }
      return null;
    }
  }
}
