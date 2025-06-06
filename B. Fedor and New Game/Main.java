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
        int m = in.nextInt();
        int k = in.nextInt();

        int arr[] = new int[m+1];

        for(int i = 0; i <= m; i++){
            arr[i] = in.nextInt();
        }
        long count = 0;
        for( int i = 0 ; i < m; i++){
            int xor = arr[i] ^ arr[m];
            if(Integer.bitCount(xor) <= k){
                count++;
            }
        }
        out.println(count);
        
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