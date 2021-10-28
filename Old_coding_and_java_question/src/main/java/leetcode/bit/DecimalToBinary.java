package leetcode.bit;

public class DecimalToBinary {
	public static void main(String arg[]) {
		int dec = 17;
		System.out.println(decToBin(dec));
	}

	public static String decToBin(int dec) {
		StringBuffer sb = new StringBuffer();
		for (int i = 32; i >= 0; i--) {
			int x = dec >> i;
			if ((x & 1) > 0)
				sb.append("1");
			else
				sb.append("0");

		}
		return sb.toString();
	}
}
