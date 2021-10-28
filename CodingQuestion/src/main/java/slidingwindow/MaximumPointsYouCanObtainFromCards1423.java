package slidingwindow;

public class MaximumPointsYouCanObtainFromCards1423 {
  public static void main(String args[]) {
    MaximumPointsYouCanObtainFromCards1423 m = new MaximumPointsYouCanObtainFromCards1423();
    int a[] = {1, 2, 3, 4, 5, 6, 1};
    int k = 3;
    System.out.println(m.maxScore(a,k));
  }

  public int maxScore(int[] cardPoints, int k) {
    int total = 0;
    for (int i : cardPoints) {
      total = total + i;
    }
    if (k == cardPoints.length) {
      return total;
    }

    int sumSoFar = 0;
    int sub_array_length=0;
    int sub_array_sum=Integer.MAX_VALUE;
    int x=0;

    for (int i = 0; i < cardPoints.length; i++) {
      sumSoFar = sumSoFar + cardPoints[i];
      sub_array_length = i-x+1;
      if(sub_array_length==cardPoints.length-k){
       sub_array_sum= Math.min(sumSoFar,sub_array_sum);
        sumSoFar=sumSoFar-cardPoints[x++];
      }
    }
    return total-sub_array_sum;
  }
}
