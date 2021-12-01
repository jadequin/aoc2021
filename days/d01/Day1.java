package days.d01;

import interfaces.Day;

public class Day1 extends Day {

  public Day1() {
    super(1);
  }
  
  @Override
  public String resultLivPart1() {
    int[] input = fileReaderLiv.getIntegerArray();
    int sum = 0;
    for(int i = 0; i < input.length - 1; i++) {
      if(input[i + 1] > input[i]){
        sum = sum + 1;
      }
    }
    return Integer.toString(sum);
  }

  @Override
  public String resultLivPart2() {
    // TODO Auto-generated method stub
    int[] input = fileReaderLiv.getIntegerArray();
    int counter = 0;

    for(int i = 0; i < input.length - 3; i++)
      if(input[i] + input[i+1] + input[i+2] < input[i+1] + input[i+2] + input[i+3]) {
        counter++;
    }
    return Integer.toString(counter);
  }

  @Override
  public String resultTillPart1() {
    int[] input = fileReaderTill.getIntegerArray();
    int counter = 0;

    for(int i = 0; i < input.length - 3; i++)
      if(input[i] + input[i+1] + input[i+2] < input[i+1] + input[i+2] + input[i+3]) {
        counter++;
    }
    return Integer.toString(counter);
  }

  @Override
  public String resultTillPart2() {
    int[] input = fileReaderTill.getIntegerArray();

    int count = 0;
    for(int i = 0; i < input.length - 1; i++)
      if(input[i + 1] > input[i])
        count++;

    return Integer.toString(count);
  }
}
