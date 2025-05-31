import java.io.*;
import java.util.*;

public class Main {
    static FastReader in;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        boolean isOnlineJudge = System.getProperty("ONLINE_JUDGE") != null;

        if (!isOnlineJudge) {
            in = new FastReader(new FileInputStream("input.txt"));
            out = new PrintWriter(new FileOutputStream("output.txt"));
        } else {
            in = new FastReader(System.in);
            out = new PrintWriter(System.out);
        }

        int t = 1;
        // t = in.nextInt(); // Uncomment if multiple test cases
        while (t-- > 0) {
            solve();
        }

        out.flush();
        out.close();
    }

    static void solve() {
        int n = in.nextInt();
        if (n < 3) {
            out.println("0");
            return;
        }
        long[] a= new long[n];
        for ( int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        long totalSum = 0;

        for (long num : a) {
            totalSum += num;
        }

        if (totalSum % 3 != 0) {
            out.println("0");
            return;
        }

        long target = totalSum / 3;
        long[] suffixCount = new long[n];
        long suffixSum = 0;

        // Step 1: Count suffixes from right to left
        for (int i = n - 1; i >= 0; i--) {
            suffixSum += a[i];
            if (suffixSum == target) {
                suffixCount[i] = 1;
            }
        }

        // Step 2: Make suffixCount cumulative from right to left
        for (int i = n - 2; i >= 0; i--) {
            suffixCount[i] += suffixCount[i + 1];
        }

        long result = 0;
        long prefixSum = 0;

        // Step 3: Count valid i using prefix sum and suffixCount
        for (int i = 0; i < n - 2; i++) {
            prefixSum += a[i];
            if (prefixSum == target) {
                result += suffixCount[i + 2]; // j must be ≥ i+2
            }
        }
        out.println(result);

        
    }

    // ----------- Fast Input Class --------------
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}
