import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author mthai
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		CF_443B solver = new CF_443B();
		solver.solve(1, in, out);
		out.close();
	}
}

class CF_443B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        char []a = in.next().toCharArray();
        int n = a.length;
        int k = in.nextInt();

        int ans = 0;
        for(int i = n - 1; i >= 0; --i) {
            int len = k + (n - i);
            if((len & 1) == 0) {
                if(check(a, n, len, i))
                    ans = len;
            }
        }

        int max = 0;
        for(int len = 2; len <= n; len += 2) {
            for(int i = 0; i + len - 1 < n; ++i) {
                if(check(a, n, len, i))
                    max = len;
            }
        }

        out.println(Math.max(max, ans));
    }

    boolean check(char []a, int n, int len, int i) {
        for(int j = i; j < i + len/2; ++j) {
            char l = (j >= n) ? '?' : a[j];
            char r = (j + len/2 >= n) ? '?' : a[j + len/2];
            if(l != r && l != '?' && r != '?')
                return false;
        }
        return true;
    }
}

