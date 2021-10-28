import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

public class NumberFormationCars {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReadery in = new InputReadery(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Printingx p = new Printingx();
		p.solve(in, out);
		out.close();
	}
}

class Printingx {
	public void solve(InputReadery in, PrintWriter out) {
		int N = in.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {

			int x = in.nextInt();
			a[i] = x;
		}
		int z = in.nextInt();
		int list[] = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = a[i];
		}
		System.out.println(solution(list,z));
		
	}

	int solution(int A[], int k) 
	{ 
	    // seiz of the vector 
	    // which does is constant 
	     int N = A.length; 
	  
	    // bases cases 
	    if (N < k || N < 1 || k < 1) 
	        return 0; 
	    if (N == k) 
	        return 1; 
	  
	    // Prepare arrays for recursion 
	    int v1[] = new int[N];	
	    int v2[] = new int[N];	
	    int v3[] = new int[N];	
	  
	    // initiate separately for k = 1 
	    // intiate the last element 
	    v2[N - 1] = 1; 
	    v3[A[N - 1] - 1] = 1; 
	  
	    // initiate all other elements of k = 1 
	    for (int i = N - 2; i >= 0; i--) { 
	  
	        // initialize the front element 
	        // to vector v2 
	        v2[i] = v2[i + 1]; 
	  
	        // if element v[a[i]-1] is 0 
	        // then increment it in vector v2 
	        if (v3[A[i] - 1] == 0) { 
	            v2[i]++; 
	            v3[A[i] - 1] = 1; 
	        } 
	    } 
	  
	    // iterate for all possible values of K 
	    for (int j = 1; j < k; j++) { 
	  
	        // fill the vectors with 0 
	        Arrays.fill(v3, 0);
	  
	        // fill(v1.begin(), v1.end(), 0) 
	        // the last must be 0 as from last no unique 
	        // subarray can be formed 
	        v1[N - 1] = 0; 
	  
	        // Iterate for all index from which unique 
	        // subsequences can be formed 
	        for (int i = N - 2; i >= 0; i--) { 
	  
	            // add the number of subsequence formed 
	            // from the next index 
	            v1[i] = v1[i + 1]; 
	  
	            // start with combinations on the 
	            // next index 
	            v1[i] = v1[i] + v2[i + 1]; 
	  
	            // Remove the elements which have 
	            // already been counted 
	            v1[i] = v1[i] - v3[A[i] - 1]; 
	  
	            // Update the number used 
	            v3[A[i] - 1] = v2[i + 1]; 
	        } 
	  
	        // prepare the next iteration 
	        // by filling v2 in v1 
	        v2 = v1; 
	    } 
	  
	    // last answer is stored in v1 
	    return v1[0]; 
	} 
	  
}

class InputReadery {
	final InputStream is;
	final byte[] buf = new byte[1024];
	int pos;
	int size;

	public InputReadery(InputStream is) {
		this.is = is;
	}

	public int nextInt() {
		int c = read();
		while (isWhitespace(c))
			c = read();
		int sign = 1;
		if (c == '-') {
			sign = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res = res * 10 + c - '0';
			c = read();
		} while (!isWhitespace(c));
		return res * sign;
	}

	public String next() {
		int c = read();
		while (isWhitespace(c))
			c = read();
		StringBuilder sb = new StringBuilder();
		do {
			sb.append((char) c);
			c = read();
		} while (!isWhitespace(c));
		return sb.toString();
	}

	int read() {
		if (size == -1)
			throw new InputMismatchException();
		if (pos >= size) {
			pos = 0;
			try {
				size = is.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (size <= 0)
				return -1;
		}
		return buf[pos++] & 255;
	}

	static boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

}