package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GFG3 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String na[] = br.readLine().split(" ");
		int sum = Integer.parseInt(na[1]);
		String sna[] = br.readLine().split(" ");
		int a[] = new int[sna.length];
		for (int i = 0; i < sna.length; i++) {
			a[i] = Integer.parseInt(sna[i]);
		}
		for (int i = 0; i < a.length; i++) {

			for (int j = i + 1; j < a.length; j++) {

			}
		}
	}

}
