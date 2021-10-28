package array;

public class SearchRoatatedArray33 {

    public int search(int[] nums, int target) {
      int start=0;
      int end=nums.length-1;
      int pivot = findpivot(start, end, nums);
      if (start <= end) {

        if (nums[pivot] == target) {
          return pivot;
        } else if (target > nums[pivot]) {
          return search(nums, target, start, pivot - 1);
        } else {
          return search(nums, target, pivot + 1, end);
        }
      }
      return -1;
    }

    public int search(int nums[], int target, int start, int end) {
      int pivot = findpivot(start, end, nums);
      if (start < end) {

        if (nums[pivot] == target) {
          return pivot;
        } else if (nums[start] > nums[pivot]) {
          return search(nums, target, start, pivot - 1);
        } else {
          return search(nums, target, pivot + 1, end);
        }
      }
      return -1;
    }

    int findpivot(int start, int end, int nums[]) {
      if (start < end) {
        int mid = (start + end) / 2;
        if (nums[mid] > nums[mid + 1]) {
          return mid;
        } else if (nums[mid - 1] > nums[mid]) {
          return (mid);
        } else if (nums[start] < nums[mid - 1]) {
          return findpivot(mid + 1, end, nums);
        } else {
          return findpivot(start, mid - 1, nums);
        }

      }
      return -1;
    }

  public static void main(String args[]){
    SearchRoatatedArray33 s=new SearchRoatatedArray33();
    int a[]={4,5,6,7,0,1,2};
    s.search(a,3);
  }
}

