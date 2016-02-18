package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class CF_303A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();

        /**
         * � t??ng:
         * � N?u n ch?n th� ko c� ?�p �n v�
         * a_i + b_i = c_i mod n
         * -> sum(a_i) + sum(b_i) = sum(c_i) mod n
         * -> 2S = S mod n (S = 0 + 1 + ... + n-1)
         * -> S = 0 mod n
         * m�: n ch?n <=> S = n * (n - 1) / 2 s? ko th? chia h?t cho n
         * � N?u n l? th� x?p nh? sau
         * 0 1 ... n-1
         * 0 1 ... n-1
         * [h�ng cu?i t�nh sao c?ng dc]
         */
        if(n % 2 == 0) {
            out.println(-1);
        }
        else {
            print0toN(n, out);
            out.println();
            print0toN(n, out);
            out.println();

            for(int i = 0; i < n; ++i) {
                out.print((i * 2 % n) + " ");
            }
            out.println();
        }
    }

    void print0toN(int n, PrintWriter out) {
        for(int i = 0; i < n; ++i) {
            out.print(i + " ");
        }
    }
}
