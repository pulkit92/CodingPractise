package array;

public class MedianOFTwoSortedArrays4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int a[] = new int[nums1.length + nums2.length];
    int k = 0;
    int i = 0;
    int j = 0;
    while (i < nums1.length && j < nums2.length && k < nums1.length + nums2.length) {
      if (nums1[i] == nums2[j]) {
        a[k++] = nums1[i];
        a[k++] = nums1[i];
        i++;
        j++;
      } else if (nums1[i] <= nums2[j]) {
        a[k] = nums1[i];
        k++;
        i++;
      } else {
        a[k] = nums2[j];
        k++;
        j++;
      }
    }

    while (i < nums1.length) {
      a[k] = nums1[i];
      k++;
      i++;
    }
    while (j < nums2.length) {
      a[k] = nums2[j];
      k++;
      j++;
    }
    if (k % 2 == 1) {
      return a[k / 2];
    } else {
      int pos = k / 2;
      double ans = ((double) a[pos - 1] + (double) a[pos]) / 2;
      return ans;
    }


  }


  public static void main(String args[]) {
    MedianOFTwoSortedArrays4 s = new MedianOFTwoSortedArrays4();
    int a[] = {1,1,1,1,1,1,1,1,1,1,4,4};
    int b[] = {1,3,4,4,4,4,4,4,4,4,4};
    System.out.println(s.findMedianSortedArrays(a, b));
  }
}
