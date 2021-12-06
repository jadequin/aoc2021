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
    int[] columnCount = new int[12];
    
    for(int i = 0; i < input.length; i++) {
      if (input[i] == null) continue; // skip all filtered entries

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

    List<String> input = fileReaderLiv.getStringList();
    List<String> oxygenList = input.stream().toList();
    List<String> co2List = input.stream().toList();

    for (int i = 0; i < input.get(0).length(); i++) {
      int x = i;

      // Oxygen
      if (oxygenList.size() > 1) {
        int onesOxygen = oxygenList.stream()
          .filter(line -> line.charAt(x) == '1')
          .toList()
          .size();
        
        char oxygenBitCriteria = onesOxygen >= Math.ceil(oxygenList.size() / 2.) ? '1' : '0';
  
        oxygenList = oxygenList.stream()
          .filter(line -> line.charAt(x) == oxygenBitCriteria)
          .toList();
      }

      // Co2
      if (co2List.size() > 1) {
        int onesCo2 = co2List.stream()
        .filter(line -> line.toCharArray()[x] == '1')
        .toList()
        .size();
        
        char co2BitCriteria = onesCo2 >= Math.ceil(co2List.size() / 2.) ? '0' : '1';
  
        co2List = co2List.stream()
          .filter(line -> line.toCharArray()[x] == co2BitCriteria)
          .toList();
      }

    }
    return "" + Integer.parseInt(oxygenList.get(0), 2) * Integer.parseInt(co2List.get(0), 2);
  }

  @Override
  public String resultTillPart1() {
    String[] input = fileReaderTill.getStringArray();
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

  @Override
  public String resultTillPart2() {
    List<String> input = fileReaderTill.getStringList();
    List<String> oxygenList = input.stream().toList();
    List<String> co2List = input.stream().toList();

    for (int i = 0; i < input.get(0).length(); i++) {
      int x = i;

      // Oxygen
      if (oxygenList.size() > 1) {
        int onesOxygen = oxygenList.stream()
          .filter(line -> line.charAt(x) == '1')
          .toList()
          .size();
        
        char oxygenBitCriteria = onesOxygen >= Math.ceil(oxygenList.size() / 2.) ? '1' : '0';
  
        oxygenList = oxygenList.stream()
          .filter(line -> line.charAt(x) == oxygenBitCriteria)
          .toList();
      }

      // Co2
      if (co2List.size() > 1) {
        int onesCo2 = co2List.stream()
        .filter(line -> line.toCharArray()[x] == '1')
        .toList()
        .size();
        
        char co2BitCriteria = onesCo2 >= Math.ceil(co2List.size() / 2.) ? '0' : '1';
  
        co2List = co2List.stream()
          .filter(line -> line.toCharArray()[x] == co2BitCriteria)
          .toList();
      }

    }
    return "" + Integer.parseInt(oxygenList.get(0), 2) * Integer.parseInt(co2List.get(0), 2);
  }
}
