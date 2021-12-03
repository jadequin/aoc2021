package days.d03;

import interfaces.Day;

public class Day3 extends Day {

  public Day3() {
    super(3);
  }

  @Override
  public String resultLivPart1() {
    String[] input = fileReaderLiv.getStringArray();
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
    //result += "1";
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
  public String resultLivPart2() {
    // TODO Auto-generated method stub
    return null;
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
