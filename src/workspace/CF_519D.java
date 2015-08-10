package workspace;

import java.util.*;
import java.io.PrintWriter;

public class CF_519D {
    long []cul;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int []a = new int[26];
        for(int i = 0; i < 26; ++i) {
            a[i] = in.nextInt();
        }
        String s = in.next();
        char []cc = s.toCharArray();
        int n = cc.length;

        cul = new long[n];
        cul[0] = a[cc[0] - 'a'];
        for(int i = 1; i < n; ++i) {
            cul[i] = a[cc[i] - 'a'] * 1l + cul[i - 1];
        }

        /**
         * � t??ng: v� d? c� chu?i
         * .....a.....a....
         * |sum1|
         * |---sum2---|
         * th� s? c� 1 k?t qu? n?u sum2 - val(a) - sum1 (val(a) l� gi� tri c?a 'a')
         * V?y t?o map(sum, frequency) cho m?i ch? c�i
         * N?u g?p 1 ch? c�i 'a' c� sum_i ta t�m trong map coi c� key = sum_i - val(a)
         * ko? N?u c� th� th�m frequency v�o k?t qu?
         */

        Map<Long, Integer>[] map = new Map[26];
        for(int i = 0; i < 26; ++i)
            map[i] = new HashMap<Long, Integer>();

        long ans = 0;
        for(int i = 0; i < n; ++i) {
            int c = cc[i] - 'a';
            if(map[c].containsKey(cul[i] - a[c]))
                ans += map[c].get(cul[i] - a[c]) * 1l;
            // save this sum
            if(map[c].containsKey(cul[i]))
                map[c].put(cul[i], map[c].get(cul[i]) + 1);
            else
                map[c].put(cul[i], 1);
        }

        out.println(ans);
    }

    long rsq(int l, int r) {
        return cul[r] - cul[l - 1];
    }
}
