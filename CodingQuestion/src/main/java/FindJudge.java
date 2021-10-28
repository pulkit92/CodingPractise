import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindJudge {
  public int findJudge(int N, int[][] trust) {
    int trustvotes[] = new int[N + 1];
    int noTrustVotes[] = new int[N + 1];

    for (int a[] : trust) {
      trustvotes[a[0]]++;
      noTrustVotes[a[1]]++;

    }
    for (int i = 1; i <= N; i++) {
      if (noTrustVotes[i] == N - 1 && trustvotes[i] == 0) {
        return i;
      }
    }
    return -1;

  }


  public static void main(String args[]) {
    int N = 2;
    int trust[][] = {{1, 2}};
    FindJudge findJudge = new FindJudge();
    System.out.println(findJudge.findJudge(N, trust));
    ;
  }

}
