package test;

import java.util.HashMap;
import java.util.Map;
//not done
public class Leet12 {
	public static void main(String args[]) {
		Leet12 l = new Leet12();
		int x = 12;
		l.intToRoman(x);
	}

	public String intToRoman(int num) {
		boolean b = false;
		Map<Integer, String> m = new HashMap<>();
		m.put(1, "I");
		m.put(5, "V");
		m.put(10, "X");
		m.put(50, "L");
		m.put(100, "C");
		m.put(500, "D");
		m.put(1000, "M");

		String na = String.valueOf(num);
		if (na.contains("4") || na.contains("9")) {
			b = true;
		}
		String sna[] = na.split("");
		int l = sna.length;
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < sna.length; i++) {
			
			int y=(int) (Integer.parseInt(sna[i])*Math.pow(10, l-1));
			sb.append(m.get(y));
			l--;
		}
		return sb.toString();

	}
}
