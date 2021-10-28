package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumProfitInobSchedulingSwiggy {
  public static void main(String args[]) {
    List<Long> pickup = List.of(0L, 2L, 9L, 10L, 11L, 12L);
    List<Long> drop = List.of(5L, 9L, 11L, 11L, 14L, 17L);
    List<Integer> tip = List.of(1, 2, 3, 2, 2, 1);

    System.out.println( maximiseRevenue(pickup, drop, tip));
  }

  public static long maximiseRevenue(List<Long> pickup, List<Long> drop, List<Integer> tip) {
    int n = pickup.size();
    Job[] jobs = new Job[n];
    // Write your code here
    for (int i = 0; i < pickup.size(); i++) {
      jobs[i] = new Job(pickup.get(i), drop.get(i), drop.get(i) - pickup.get(i) + tip.get(i));
    }
    return scheduleApt(jobs);
  }
  private static long scheduleApt(Job[] jobs) {
    // Sort jobs according to finish time
    Arrays.sort(jobs, Comparator.comparingLong(a -> a.finish));
    // dp[i] stores the profit for jobs till jobs[i]
    // (including jobs[i])
    int n = jobs.length;
    long[] dp = new long[n];
    dp[0] = jobs[0].profit;
    for (int i=1; i<n; i++) {
      // Profit including the current job
      long profit = jobs[i].profit;
      int l = search(jobs, i);
      if (l != -1)
        profit += dp[l];
      // Store maximum of including and excluding
      dp[i] = Math.max(profit, dp[i-1]);
    }

    return dp[n-1];
  }

  private static int search(Job[] jobs, int index) {
    int start = 0, end = index - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (jobs[mid].finish <= jobs[index].start) {
        if (jobs[mid + 1].finish <= jobs[index].start)
          start = mid + 1;
        else
          return mid;
      }
      else
        end = mid - 1;
    }
    return -1;
  }

  static class Job {
    long start, finish, profit;

    Job(long start, long finish, long profit) {
      this.start = start;
      this.finish = finish;
      this.profit = profit;
    }
  }

}
