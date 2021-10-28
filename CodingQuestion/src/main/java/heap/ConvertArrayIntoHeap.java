package heap;

public class ConvertArrayIntoHeap {

  public static void main(String[] args) {
    int a[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
    ConvertArrayIntoHeap c = new ConvertArrayIntoHeap();
    c.convert(a);
    for (int i : a) {
      System.out.println(i);
    }
  }

  public void convert(int a[]) {

    int nonLeafyPos = (a.length / 2) - 1;
    for (int i = nonLeafyPos; i >= 0; i--) {
      heafify(i, a);
    }

  }

  public void heafify(int i, int a[]) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (a.length < left || a.length < right) {
      return;
    }
    int max = a[i];
    if (max >= a[left] && max >= a[right]) {
      return;
    }
    if (a[left] > a[right]) {
      swap(a, i, left);
      heafify(left, a);
    } else {
      swap(a, i, right);
      heafify(right, a);
    }
  }

  void swap(int a[], int i, int pos) {
    int temp = a[i];
    a[i] = a[pos];
    a[pos] = temp;
  }
}
