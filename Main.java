import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

4 2 7 1 2 4 9
0 0 0 1 1 0 1

1 2 7 4 2 4 9
1 0 0 0 1 0 1

1 2 2 4 7 4 9
1 0 1 0 0 0 1

1 2 2 4 9 4 7
1 0 1 0 1 0 0

1 2 2 4 4 9 7
1 0 1 0 0 1 0

1 2 2 4 4 7 9
1 0 1 0 0 0 1
= possible

as long as there's a b[i] != b[j], it's always possible

4 2 7 1 2 4 9
0 0 0 0 0 0 1

9 2 7 1 2 4 4
1 0 0 0 0 0 0

1 2 7 1 2 9 4
0 0 0 0 0 1 0

 */

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			int[] b = fs.readArray(n);
			boolean different = false;
			for (int i = 1; i < n; i++) {
				if (b[i] != b[i-1]) {
					different = true;
					break;
				}
			}
			if (different || isSorted(a)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		out.close();
	}
	
	static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i-1]) {
				return false;
			}
		}
		return true;
	}
		
	static final Random rnd = new Random();
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
