 package test;

import java.io.*;

public class kadaneAlgo {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String na[] = br.readLine().split(" ");
		int sum=Integer.MIN_VALUE;
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < na.length; i++) {
			sum=sum+Integer.parseInt(na[i]);
			if(sum>max)
			{
				max=sum;
			}
		}
		System.out.println(max);
	}
}
