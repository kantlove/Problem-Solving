package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class NextPermutation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int []next = nextPermutation(a);
        while(next != null) {
            out.println(arrString(next));
            next = nextPermutation(next);
        }
    }

    /**
     * � t??ng: ?i t�m k l?n nh?t sao cho a[k] < a[k + 1]
     * khi ?�, ?o?n [k+1 : n-1] l� gi?m d?n. C� ngh? l�
     * ?o?n [k+1 : n-1] ?� l� l?n nh?t r?i, ko c�n thay ??i dc g� trong
     * ?o?n n�y n?a. Do ?� t�m r sao cho a[r] > a[k] (r ph?i xa k nh?t).
     * Swap a[k] & a[r], reverse ?o?n [k+1 : n-1] ?? dc ?o?n t?ng d?n.
     * ?�y ch�nh l� ho�n v? k? ti?p. N?u ko t�m dc k, ?�y ?� l� ho�n v? cu?i c�ng.
     */
    int[] nextPermutation(int []a) {
        int k = -1, n = a.length;
        // find the largest k such that a[k] < a[k + 1]
        for(int i = 0; i < n - 1; ++i) {
            if(a[i] < a[i + 1])
                k = i;
        }
        if(k == -1) return null; // this is the last permutation
        // find the largest r such that a[k] < a[r]
        int r = k + 1;
        for(int i = k + 1; i < n; ++i) {
            if(a[i] > a[k])
                r = i;
        }

        swap(a, k, r);
        reverse(a, k + 1, n - 1);
        return a;
    }

    void swap(int []a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    void reverse(int []a, int l, int r) {
        for(int i = 0; i < r - l; ++i) {
            swap(a, l + i, r - i);
        }
    }

    String arrString(int []a) {
        String s = "";
        for(int x : a)
            s += x + " ";
        return s;
    }
}
