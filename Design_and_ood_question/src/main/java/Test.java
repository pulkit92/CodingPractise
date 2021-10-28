import java.util.HashMap;
import java.util.Map;

public class Test {
  public static void main(String args[]) {
    double x = 3.0;
    StationPairCountTimePair stationPairCountTimePair = new StationPairCountTimePair(x ,2.0);
    Map<StationPairCountTimePair, Integer> map = new HashMap<>();
    map.put(stationPairCountTimePair, 3);
    stationPairCountTimePair.totalCount=4.0;
    System.out.println(map.containsKey(x));
    System.out.println(map.containsKey(4.0));

  }
}
