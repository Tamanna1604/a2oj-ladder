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
         int n = in.nextInt(); // 0s
        int m = in.nextInt(); // 1s

        // Invalid case
        if (m < n - 1 || m > 2 * (n + 1)) {
            out.println("-1");
            return;
        }
        int f0=1;

        StringBuilder sb = new StringBuilder();
       while (n > 0 || m > 0) {
            if (m > n) {
                if (m >= 2) {
                    sb.append("11");
                    m -= 2;
                } else {
                    sb.append("1");
                    m--;
                }
                if (n > 0) {
                    sb.append("0");
                    n--;
                }
            } else if (n > m) {
                sb.append("0");
                n--;
                if (m > 0) {
                    sb.append("1");
                    m--;
                }
            } else { // m == n
                if (m > 0) {
                    sb.append("10");
                    m--;
                    n--;
                }
            }
        }
    
        out.println(sb);
        
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
    

