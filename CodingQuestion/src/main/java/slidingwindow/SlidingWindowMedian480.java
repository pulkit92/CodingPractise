package slidingwindow;

import java.util.Comparator;
import java.util.TreeSet;

public class SlidingWindowMedian480 {
  public static void main(String args[]) {
    SlidingWindowMedian480 slidingWindowMedian480 = new SlidingWindowMedian480();
    int nums[] = {1, 4, 2, 3};
    int k = 4;
    double a[] = (slidingWindowMedian480.medianSlidingWindow(nums, k));
    for (double x : a) {
      System.out.println(x);
    }
  }

  public double[] medianSlidingWindow(int[] nums, int k) {
    double out[] = new double[nums.length - k + 1];
    Comparator<Integer> comparator = new Comparator<>() {
      public int compare(Integer a, Integer b) {
        if (nums[a] != nums[b]) {
          return Integer.compare(nums[a], nums[b]);
        } else {
          return a - b;
        }
      }
    };
    TreeSet<Integer> asend = new TreeSet<>(comparator);
    TreeSet<Integer> desend = new TreeSet<>(comparator.reversed());
    for (int i = 0; i < k; i++) {
      desend.add(i);
    }
    balance(asend, desend);

    out[0] = getMedian(nums, asend, desend, k);
    int r = 1;
    for (int i = k; i < nums.length; i++) {
      if (!asend.remove(i - k)) {
        desend.remove(i - k);
      }
      asend.add(i);
      desend.add(asend.pollFirst());

      balance(asend, desend);
      out[r++] = getMedian(nums, asend, desend, k);
    }
    return out;
  }

  private void balance(TreeSet asend, TreeSet desend) {
    while (desend.size() > asend.size()) {
      asend.add(desend.pollFirst());
    }

  }

  private double getMedian(int nums[], TreeSet<Integer> ascend, TreeSet<Integer> desend, int k) {
    if (k % 2 == 0) {
      double x = (double) ((double)(nums[ascend.first()] + (double)nums[desend.first()]) / 2);
      return x;
    } else {
      return nums[ascend.first()];
    }
  }
}
