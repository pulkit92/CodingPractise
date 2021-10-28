package test;

public class SearchElements {

  public int findOccurence(int a[], int target) {

    int first = findFirstOccurence(a, 0, a.length - 1, target);
    if (first == -1) {
      return 0;
    }
    int last = findLastOccurence(a, 0, a.length - 1, target);
    return last - first + 1;
  }

  private int findFirstOccurence(int a[], int start, int end, int target) {
    while (end >= start) {
      int mid = (start + end) / 2;
      if (mid == 0 || a[mid - 1] < target && target == a[mid]) {
        return mid;
      }
      if (target > a[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  private int findLastOccurence(int a[], int start, int end, int target) {
    while (end >= start) {
      int mid = (start + end) / 2;
      if (mid == a.length - 1 || a[mid + 1] > target && target == a[mid]) {
        return mid;
      }
      if (target < a[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }



  public static void main(String args[]) {
    int a[] = {5, 5, 5, 5, 5, 5};
    int target = 5;
    SearchElements elements = new SearchElements();
    System.out.println(elements.findOccurence(a, target));
  }
}
