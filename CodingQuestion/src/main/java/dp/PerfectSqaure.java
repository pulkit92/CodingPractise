package dp;

public class PerfectSqaure {
  int minCount=Integer.MAX_VALUE;
  public int numSquares(int n) {
    findPerfectSquare( n,0);
    return minCount;

  }
  public void findPerfectSquare(int n,int count){
    for(int i=1;i<=n;i++){
      if(i*i==n){
        minCount=Math.min(minCount,count+1);
        return;
      }
      if(i*i<n){
        findPerfectSquare( n-i*i, count+1);
      }
    }
  }
  public static void main(String args[]){
    PerfectSqaure perfectSqaure=new PerfectSqaure();
    System.out.println(perfectSqaure.numSquares(55));
  }
}
