package workspace;

import java.util.Scanner;
import java.io.PrintWriter;

public class BinarySearchInCircleArray {
    /**
     * Binary search for sorted circular array
     */
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int []a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        while(m-- > 0) {
            out.println(binSearch(a, in.nextInt()));
        }
    }

    /**
     * Trong cycle array (hay rotated array) th� s? c� 2 ?o?n t?ng d?n
     * ?i?u quan tr?ng l� t�m coi ta ?ang ? trong ?o?n t?ng d?n n�o.
     * C�n l?i th� x�t tr??ng h?p kh� ??n gi?n.
     * Note: ch?y t?t v?i duplicate
     */
    int binSearch(int []a, int target) {
        int n = a.length, low = 0, hi = n - 1;
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(a[mid] == target)
                return mid;
            if(a[mid] < target) {
                if(a[mid] < a[hi]) { // t�m xem ?ang ? ?o?n t?ng d?n n�o
                    if(a[hi] < target)
                        hi = mid - 1;
                    else
                        low = mid + 1;
                }
                else
                    low = mid + 1;
            }
            else {
                if(a[mid] < a[hi]) // t�m xem ?ang ? ?o?n t?ng d?n n�o
                    hi = mid - 1;
                else {
                    if(a[low] <= target)
                        hi = mid - 1;
                    else
                        low = mid + 1;
                }
            }
        }
        return -1;
    }
}
