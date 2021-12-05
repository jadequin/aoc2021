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

    var numbers = Arrays.asList(input.substring(0, input.indexOf("\r\n")).split(","))
      .stream()
      .map(Integer::parseInt)
      .collect(Collectors.toList());

      List<ArrayList<Integer>> boards = Arrays.asList(input.substring(input.indexOf("\r\n\r\n")).trim().split("\r\n\r\n"))
        .stream()
        .map(b -> {
          return new ArrayList<Integer>(
            Arrays.asList(b.trim().split("\\s+"))
              .stream()
              .map(Integer::parseInt)
              .collect(Collectors.toList())
          );
        })
        .collect(Collectors.toList());

      var bingoRows = List.of(
        List.of(0,1,2,3,4),
        List.of(5,6,7,8,9),
        List.of(10,11,12,13),
        List.of(15,16,17,18,19),
        List.of(20,21,22,23,24),
        List.of(0,5,10,15,20),
        List.of(1,6,11,16,21),
        List.of(2,7,12,17,22),
        List.of(3,8,13,18,23),
        List.of(4,9,14,19,24)
      );
      
      for (var n : numbers) {
        for (var b : boards) {
          var hit = b.stream()
            .filter(x -> x == n)
            .findFirst()
            .orElse(null);

          if (hit != null) {
            int potentialBingoFinisher = hit;
            hit = -1;

            // check if there is a bingo
            boolean bingo = true;
            for (int i = 0; i < bingoRows.size(); i++) {
              for (var num : bingoRows.get(i)) {
                if (b.get(num) != -1) {
                  bingo = false;
                  break;
                }
              }
              // Big Hit
              if (bingo) {
                int res = b.stream()
                  .mapToInt(Integer::intValue)
                  .sum() + 5;
                
                return "" + res * potentialBingoFinisher;
              }
            }
          }
        }
      }
      
    return null;
  }

  @Override
  public String resultTillPart2() {
    // TODO Auto-generated method stub
    return null;
  }

}
