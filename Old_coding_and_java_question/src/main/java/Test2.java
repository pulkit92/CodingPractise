//0 1 1 2 3 5 8 13 21
public class Test2 {
	public static void main(String args[]) {
		System.out.println(sumoffibonaaci(3));
	}

	public static int sumoffibonaaci(int index) {
		int a = 0;
		int b = 1;
		int sum = 1;
		if (index == 0)
			return 0;
		if (index == 1)
			return 1;
		for (int i = 2; i < index; i++) {
			int c = a + b;
			sum = sum + c;
			a=b;
			b=c;

		}
		return sum;
	}
}
