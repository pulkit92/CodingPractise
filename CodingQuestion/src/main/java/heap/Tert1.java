package heap;

public class Tert1 {
  int solution(int[] A, int K) {
    int n = A.length;
    int best = 0;
    int count = 1;
    for (int i = 0; i < n - K - 1; i++) {
      if (A[i] == A[i + 1])
        count = count + 1;
      else
        count = 0;
      if (count > best)
        best = count;
    }
    int result = best + 1 + K;

    return result;
  }
  public static void main(String args[]){
    int[] A ={ 1,1, 3, 3, 3, 4, 5, 5, 5, 5};
    int K= 2;
    Tert1 tert1= new Tert1();
    System.out.println(tert1.solution(A,K));
  }
}
