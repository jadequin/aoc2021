package days.d06;

import java.util.ArrayList;
import java.util.Arrays;

import interfaces.Day;

public class Day6 extends Day {

  public Day6() {
    super(6);
  }
  
  @Override
  public String resultLivPart1() {
    long[] fische = Arrays.stream(fileReaderLiv.getString().split(","))
      .mapToLong(Long::parseLong)
      .toArray();

    Fish.fishes = new ArrayList<Fish>();
    for (Long fisch : fische) {
      Fish.fishes.add(new Fish(fisch));
    }

    Fish.pastDays(80);

    return "" + Fish.fishes.size();
  }

  @Override
  public String resultLivPart2() {
    long[] fische = Arrays.stream(fileReaderLiv.getString().split(","))
      .mapToLong(Long::parseLong)
      .toArray();

    Fish.fishes = new ArrayList<Fish>();
    for (Long fisch : fische) {
      Fish.fishes.add(new Fish(fisch));
    }

    Fish.pastDays(256);

    return "" + Fish.fishes.size();
  }

  @Override
  public String resultTillPart1() {
    long[] fische = Arrays.stream(fileReaderTill.getString().split(","))
      .mapToLong(Long::parseLong)
      .toArray();

    Fish.fishes = new ArrayList<Fish>();
    for (Long fisch : fische) {
      Fish.fishes.add(new Fish(fisch));
    }

   // Fish.pastDays(80);

    return "" + Fish.fishes.size();
  }

  @Override
  public String resultTillPart2() {
    long[] fische = Arrays.stream(fileReaderTill.getString().split(","))
      .mapToLong(Long::parseLong)
      .toArray();

    Fish.fishes = new ArrayList<Fish>();
    for (Long fisch : fische) {
      Fish.fishes.add(new Fish(fisch));
    }

    //Fish.pastDays(256);

    return "" + Fish.fishes.size();
  }
}
