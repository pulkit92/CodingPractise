public class QuickSort {
  public static void main(String args[]) {
    int a[] = {10, 80, 30, 90, 40, 50, 70};
    QuickSort q = new QuickSort();
    q.quicksort(a, 0, a.length-1);
    for (int x : a) {
      System.out.print(x+" ");
    }
  }

  public void quicksort(int a[], int low, int high) {
    if (low < high) {
      int p = partition(a, low, high);
      quicksort(a, low, p - 1);
      quicksort(a, p + 1, high );
    }
  }

  public int partition(int a[], int low, int high) {

    int pivot = a[high];
    int i = low-1;
    for (int j = low; j < high; j++) {
      if (a[j] <= pivot) {
        i++;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
    }
    int temp = a[i + 1];
    a[i + 1] = a[high];
    a[high] = temp;
    return i + 1 ;
  }

}

