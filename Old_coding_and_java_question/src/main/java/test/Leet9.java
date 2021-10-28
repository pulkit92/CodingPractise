package test;

public class Leet9 {
	
		public boolean isPalindrome(int x) {
			int sum = 0;
			int p = 0;
			for (int i = x; i > 0; i = i / 10) {
				int r = i % 10;
				sum =  (int) ((r * Math.pow(10, p)) + sum);
				p++;
			}
			if (x == sum)
				return true;
			else
				return false;

		}
		public static void main(String args[]) {
			Leet9 l = new Leet9();
			int x = 321;
			System.out.println(l.isPalindrome(x));
			
		}
		
	}

