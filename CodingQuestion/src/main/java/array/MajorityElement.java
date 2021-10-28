package array;

public class MajorityElement {
  public int majorityElement(int[] nums) {
    int count = 0;
    Integer cand = null;
    for (int num : nums) {
      if (count == 0) {
        cand = num;
      }
      if (cand == num) {
        count++;
      } else {
        count--;
      }
    }
    return cand;
  }

  public static void main(String args[]) {
    MajorityElement majorityElement = new MajorityElement();
    int a[] = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7};
    System.out.println(majorityElement.majorityElement(a));
  }
}
