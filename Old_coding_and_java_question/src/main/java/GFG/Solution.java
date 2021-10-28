package GFG;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

	/*
	 * Complete the 'waysToChooseSum' function below.
	 *
	 * The function is expected to return a LONG_INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. LONG_INTEGER a
	 *  2. LONG_INTEGER b
	 */

	public static List<Long> waysToChooseSum(long a, long b) {
		Map<Long,Long> map=new HashMap<>();
		for (long i=a;i<=b;i++)
		{
			long x=getSum(i);
			if(map.containsKey(x)){
				long value=map.get(x);
				map.put(x, value+1);
			}
			else
				map.put(x, 1L);

		}
		Map<Long, Long> map1 = new TreeMap<>(Collections.reverseOrder());
		for (Map.Entry<Long, Long> entry : map.entrySet()) {
			long key=entry.getKey();
			long value=entry.getValue();
			if(map1.containsKey(value)){
				long value1=map1.get(value);
				map1.put(value, value1+1);}
			else{    map1.put(value, 1L);
			}

		}
		List<Long> ab=new ArrayList<>();
		Map.Entry<Long, Long> entry = map.entrySet().iterator().next();
		long key = entry.getKey();
		long value = entry.getValue();
		ab.add(key);
		ab.add(value);
		return ab;



	}








	static long getSum(long n) {
		long sum = 0;

		while (n != 0) {
			sum = sum + n % 10;
			n = n / 10;
		}

		return sum;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		long a = Long.parseLong(bufferedReader.readLine().trim());

		long b = Long.parseLong(bufferedReader.readLine().trim());

		List<Long> result = Result.waysToChooseSum(a, b);

		bufferedWriter.write(
				result.stream()
						.map(Object::toString)
						.collect(joining("\n"))
						+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}
}
