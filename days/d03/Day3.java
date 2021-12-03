package days.d03;

import java.util.Arrays;
import java.util.List;

import interfaces.Day;

public class Day3 extends Day {

  public Day3() {
    super(3);
  }

  @Override
  public String resultLivPart1() {
    String[] input = fileReaderLiv.getStringArray();
    int[] columnCount = getColumnCount(input);

    String gammarate = "";
    String epsilonrate = "";

    for(int column : columnCount) {
      if(column > input.length/2){
        gammarate += "1";
        epsilonrate += "0";
      }
      else{
        gammarate += "0";
        epsilonrate += "1";
      }
    }
    return "" + Integer.parseInt(gammarate, 2) * Integer.parseInt(epsilonrate, 2);
  }


  private static int[] getColumnCount(String[] input) {
    int[] columnCount = new int[input[0].length()];
    
    for(int i = 0; i < input.length; i++) {
      for(int j = 0; j < input[i].length(); j++) {
        if(input[i].toCharArray()[j] == '1') {
          columnCount[j]++;
        }
      }
    }
    return columnCount;
  }

  @Override
  public String resultLivPart2() {
    // TODO Auto-generated method stub
    String[] input = fileReaderLiv.getStringArray();
    int[] columnCount = getColumnCount(input);
    String[] oxygenArray = Arrays.copyOf(input, input.length);
    String[] co2Array = Arrays.copyOf(input, input.length);
    int oxygenCounter = 0;
    int co2Counter = 0;

    for (int i = 0; i < columnCount.length; i++) {
      char oxygenBitCriteria = columnCount[i] >= input.length ? '1' : '0';
      char co2BitCriteria = columnCount[i] <= input.length ? '1' : '0';

      for (int j = 0; j < input.length; j++) {
        if (input[j].toCharArray()[i] != oxygenBitCriteria && oxygenArray.length - oxygenCounter > 1) {
          oxygenArray[j] = null;
          oxygenCounter++;
        }
        if (input[j].toCharArray()[i] != co2BitCriteria && co2Array.length - co2Counter > 1) {
          co2Array[j] = null;
          co2Counter++;
        }
      }
    }

    String oxygenRating = "";
    String co2Rating = "";
    for (String rating : oxygenArray) {
      if (rating != null) {
        oxygenRating = rating;
        break;
      }
    } 

    for (String rating : co2Array)
      if (rating != null) {
        co2Rating = rating;
        break;
      }
      System.out.println(co2Rating + " " + oxygenRating);
    return "" + Integer.parseInt(oxygenRating, 2) * Integer.parseInt(co2Rating);
  }

  @Override
  public String resultTillPart1() {
    String[] input = fileReaderTill.getStringArray();
    int[] columnCount = new int[12];
    
    for(int i = 0; i < input.length; i++ ) {
      for(int j = 0; j < input[i].length(); j++) {
        if(input[i].toCharArray()[j] == '1') {
          columnCount[j]++;
        }
      }
    }

    String gammarate = "";
    String epsilonrate = "";
    for(int column : columnCount) {
      if(column > input.length / 2){
        gammarate += "1";
        epsilonrate += "0";
      }
      else{
        gammarate += "0";
        epsilonrate += "1";
      }
    }
    return "" + Integer.parseInt(gammarate, 2) * Integer.parseInt(epsilonrate, 2);
  }

  @Override
  public String resultTillPart2() {
    // TODO Auto-generated method stub
    return null;
  }
}
