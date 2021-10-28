import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DesignUndergroundSystem {
  Map<Integer, CustomerDetails> map = null;
  Map<StationPair, StationPairCountTimePair> avgMap = null;


  public DesignUndergroundSystem() {
    map = new HashMap<>();
    avgMap = new HashMap<>();

  }

  public void checkIn(int id, String stationName, int t) {
    if (map.containsKey(id)) {
      return;
    }
    map.put(id, new CustomerDetails(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    if (!map.containsKey(id)) {
      return;
    }
    CustomerDetails customerDetails = map.get(id);
    StationPair stationPair = new StationPair(customerDetails.stationName, stationName);
    int timeTaken = t - customerDetails.time;
    if (avgMap.containsKey(stationPair)) {
      StationPairCountTimePair stationPairCountTimePair = avgMap.get(stationPair);
      avgMap.put(stationPair, new StationPairCountTimePair(stationPairCountTimePair.totalCount + 1,
          stationPairCountTimePair.totalTime + timeTaken));
    } else {
      avgMap.put(stationPair, new StationPairCountTimePair(1,
          timeTaken));
    }
    map.remove(id);
  }

  public double getAverageTime(String startStation, String endStation) {
    StationPairCountTimePair stationPairCountTimePair = avgMap.get(new StationPair(startStation, endStation));
    return (double) (stationPairCountTimePair.totalTime / stationPairCountTimePair.totalCount);
  }

  public static void main(String args[]) {
    DesignUndergroundSystem undergroundSystem = new DesignUndergroundSystem();
    undergroundSystem.checkIn(10, "Leyton", 3);
    undergroundSystem.checkOut(10, "Paradise", 8); // Customer 10 "Leyton" -> "Paradise" in 8-3 = 5
    System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.00000, (5) / 1 = 5
    undergroundSystem.checkIn(5, "Leyton", 10);
    undergroundSystem.checkOut(5, "Paradise", 16); // Customer 5 "Leyton" -> "Paradise" in 16-10 = 6
    System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.50000, (5 + 6) / 2 = 5.5
    undergroundSystem.checkIn(2, "Leyton", 21);
    undergroundSystem.checkOut(2, "Paradise", 30); // Customer 2 "Leyton" -> "Paradise" in 30-21 = 9
    System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 6.66667, (5 + 6 + 9) / 3
    // = 6.66667
  }
}


class CustomerDetails {
  String stationName;
  int time;

  public CustomerDetails(
      String stationName, int time) {
    this.stationName = stationName;
    this.time = time;
  }

}


class StationPair {
  String startStation;
  String endStation;

  public StationPair(
      String startStation, String endStation) {
    this.startStation = startStation;
    this.endStation = endStation;
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StationPair that = (StationPair) o;
    return startStation.equals(that.startStation) &&
        endStation.equals(that.endStation);
  }

  @Override public int hashCode() {
    return Objects.hash(startStation, endStation);
  }
}


class StationPairCountTimePair {
  double totalCount;
  double totalTime;

  public StationPairCountTimePair(
      double totalCount, double totalTime) {
    this.totalCount = totalCount;
    this.totalTime = totalTime;
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StationPairCountTimePair that = (StationPairCountTimePair) o;
    return Double.compare(that.totalCount, totalCount) == 0 &&
        Double.compare(that.totalTime, totalTime) == 0;
  }

  @Override public int hashCode() {
    return Objects.hash(totalCount, totalTime);
  }
}
