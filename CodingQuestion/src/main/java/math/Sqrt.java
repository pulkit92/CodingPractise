package math;

public class Sqrt {
    public static void main(String  args[]){
        Sqrt sqrt=new Sqrt();
        System.out.println(sqrt.mySqrt(4));
    }
    public boolean mySqrt(int x) {
        if (x < 2) return true;

        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num ==x)return true;
            else if (num < x) left = pivot + 1;
            else right =pivot-1;
        }

        return false;
    }
}
