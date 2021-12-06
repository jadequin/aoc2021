package days.d06;

import java.util.ArrayList;

class Fish {
  static ArrayList<Fish> fishes = new ArrayList();
  long status;

  Fish(long status) {
    this.status = status;    
  }

  Fish nextDay() {
    Fish resultFish = null;

    this.status--;
    if (this.status < 0) {
      resultFish = new Fish(8);
      this.status = 6;
    }
    return resultFish;
  }

  static void pastDays(long days){
    for(long i = 0; i < days; i++) {
      ArrayList<Fish> dailyFishes = new ArrayList();

      for(Fish fish : fishes) {
        Fish resultFish = fish.nextDay();
        if (resultFish != null) {
          dailyFishes.add(resultFish);
        }
      }
      Fish.fishes.addAll(dailyFishes);
    }
  }
  
}