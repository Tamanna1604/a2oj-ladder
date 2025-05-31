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
        Pair[] exams = new Pair[n];
        for (int i = 0; i < n; i++) {
            int a = in.nextInt(); // scheduled date (recorded)
            int b = in.nextInt(); // early date (actual)
            exams[i] = new Pair(a, b);
        }

        // Sort by scheduled date ai (recorded)
        Arrays.sort(exams, (p1, p2) -> {
            if (p1.a != p2.a)
                return Integer.compare(p1.a, p2.a);
            else
                return Integer.compare(p1.b, p2.b);
        });

        int lastDay = -1; // last actual exam taken date
        for (Pair exam : exams) {
            if (exam.b >= lastDay) {
                lastDay = exam.b;
            } else {
                lastDay = exam.a;
            }
        }

        out.println(lastDay);
    }
    static class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b= b;
        }
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
