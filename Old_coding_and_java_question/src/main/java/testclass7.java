/*import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class testclass7 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Printing p = new Printing();
		p.solve(in, out);
		out.close();
	}
}

class x {
	public void solve(InputReader in, PrintWriter out) {
		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			int x = in.nextInt();
			int a[] = new int[x];
			for (int j = 0; j < x; j++) {

				int m = in.nextInt();
				a[j] = m;
			}
		}

	}

	static List<List<Integer>> printPairs(int arr[], int n, int sum) {
		// int count = 0;
		List<List<Integer>> b = new ArrayList<>();
		// Consider all possible pairs
		// and check their sums
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				List<Integer> a = new ArrayList<>();
				if (arr[i] + arr[j] == sum) {
					a.add(arr[i]);
					a.add(arr[j]);
					b.add(a);
				}
			}
		}
		return b;
	}

	static int myXOR(int x, int y) {
		return (x | y) & (~x | ~y);
	}
}

class InputReader {
	final InputStream is;
	final byte[] buf = new byte[1024];
	int pos;
	int size;

	public InputReader(InputStream is) {
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

}*/