package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_185A {
    int mod = 1000000007;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextLong();

        /**
         * Ch� � s? h�nh tam gi�c c?n t�m trong t?ng row
         * l?n l??t l� 1, 2, 3, .... s
         * S? h�nh tam gi�c c�n l?i l� 0, 1, 2, ... (s-1)
         * V?y t?ng s? h�nh l� s^2 = 4^n
         */
        long x = modPow(2l, n);
        long ans = x * (x + 1) / 2;
        ans %= mod;
        out.println(ans);
    }

    long modPow(long base, long exp) {
        long rs = 1;
        while(exp > 0) {
            if((exp & 1) == 1) {
                rs = (rs * (base % mod)) % mod;
            }
            exp >>= 1;
            base = ((base % mod)* (base % mod)) % mod;
        }
        return rs;
    }
}
