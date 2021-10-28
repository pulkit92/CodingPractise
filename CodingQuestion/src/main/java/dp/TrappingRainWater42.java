package dp;

public class TrappingRainWater42 {
  public static void main(String args[]) {
    TrappingRainWater42 t = new TrappingRainWater42();
    int a[]={0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(t.trap(a));
  }

  public int trap(int[] height) {
    int right[] = rightHeight(height);
    int leftmax = 0;
    int sum = 0;
    for (int i = 0; i < height.length; i++) {
      if (leftmax > height[i] && right[i] > height[i]) {
        sum = sum + Math.abs(height[i] - Math.min(leftmax, right[i]));
      }
      if (height[i] > leftmax) {
        leftmax = height[i];
      }
    }
    return sum;
  }

  public int[] rightHeight(int a[]) {
    int m[] = new int[a.length];
    int max = 0;
    for (int i = m.length - 1; i >= 0; i--) {
      if (max > a[i]) {
        m[i] = max;
      }

      if (a[i] > max) {
        max = a[i];
      }

    }
    return m;
  }
}
