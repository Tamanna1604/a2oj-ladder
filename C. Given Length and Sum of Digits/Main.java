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
    int m = in.nextInt();
    int s = in.nextInt();
    if (m == 1 && s == 0) {
    System.out.println("0 0");
    return;
}

    if ((s == 0 && m > 1) || s > 9 * m) {
        System.out.println("-1 -1");
        return;
    }

        // Build smallest number
    int sum = s;
    StringBuilder smallest = new StringBuilder();
    for (int i = 0; i < m; i++) {
        for (int d = (i == 0 ? 1 : 0); d <= 9; d++) {
            int rem = sum - d;
            if (rem >= 0 && rem <= 9 * (m - i - 1)) {
                smallest.append(d);
                sum -= d;
                break;
            }
        }
    }

    // Build largest number
    sum = s;
    StringBuilder largest = new StringBuilder();
    for (int i = 0; i < m; i++) {
        for (int d = 9; d >= (i == 0 ? 1 : 0); d--) {
            int rem = sum - d;
            if (rem >= 0 && rem <= 9 * (m - i - 1)) {
                largest.append(d);
                sum -= d;
                break;
            }
        }
    }
    out.println(smallest + " " + largest);
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