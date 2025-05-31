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
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.a-a.a);
        
        int n = in.nextInt();

         for(int i = 0; i< n; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            Pair pair= new Pair(a,b);
            pq.offer(pair);

         }
         int prev =pq.peek().b;
         for(int i = 0; i< n; i++){
            Pair curr = pq.poll();
            int a = curr.a;
            int b = curr.b;
            if(b > prev){
                b = prev;
            }
            else{
                prev = a;
            }
        }
        out.print(prev);
    }
    class Pair{
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
