import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DesignALeaderBoard2 {
  Map<Integer, Integer> map = null;
  TreeMap<Integer, Integer> sortedMap;

  public DesignALeaderBoard2() {
    map = new HashMap<>();
    sortedMap = new TreeMap<>(Comparator.reverseOrder());
  }

  public void addScore(int playerId, int score) {
    if (!map.containsKey(playerId)) {
      map.put(playerId, score);
      sortedMap.put(score, sortedMap.getOrDefault(score, 0) + 1);
    } else {
      int oldScore = map.get(playerId);
      int newScore = oldScore + score;
      map.put(playerId, newScore);
      if (sortedMap.get(oldScore) == 1) {
        sortedMap.remove(oldScore);
      } else {
        sortedMap.put(oldScore, sortedMap.get(oldScore) - 1);
      }
      sortedMap.put(newScore, sortedMap.getOrDefault(newScore, 0) + 1);

    }
}

  public int top(int K) {

    Set<Integer> set = sortedMap.keySet();
    int count = 0;
    int sum = 0;
    for (int i : set) {
      for (int j = 0; j < sortedMap.get(i); j++) {
        sum = sum + i;
        count++;
        if (count == K) {
          break;
        }
      }
      if (count == K) {
        break;
      }
    }
    return sum;

  }

  public void reset(int playerId) {
    int score = map.get(playerId);
    if (sortedMap.get(score) == 1) {
      sortedMap.remove(score);
    }
    else {
      sortedMap.put(score,sortedMap.get(score)-1);
    }
    map.remove(playerId);

  }
  public static void main(String args[]) {
    DesignALeaderBoard2 leaderboard = new DesignALeaderBoard2();
    leaderboard.addScore(1, 73);   // leaderboard = [[1,73]];
    leaderboard.addScore(2, 56);   // leaderboard = [[1,73],[2,56]];
    leaderboard.addScore(3, 39);   // leaderboard = [[1,73],[2,56],[3,39]];
    leaderboard.addScore(4, 51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
    leaderboard.addScore(5, 4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
    System.out.println(leaderboard.top(1));           // returns 73;
    leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
    leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
    leaderboard.addScore(2, 51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
    System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
  }
}
