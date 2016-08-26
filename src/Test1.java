import java.io.*;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(in, out);
        out.close();
    }

    static class TaskA {

        int[] a;

        public void solve(InputReader scan, PrintWriter out) {
            int city=scan.nextInt();
            a=new int[city+1];
            for (int i = 1; i < a.length; i++) {
                a[i]=scan.nextInt();
            }
            int count=scan.nextInt();
            for (int i = 0; i < count; i++) {
                change(scan.nextInt());
            }
            int total=0;
            for (int i = 0; i < a.length; i++) {
                total+=a[i];
            }
            out.println(total);
        }

        public void change(int x){
            int val=0;
            for(int i=x-1;i>0;i--){
                ++val;
                if(a[i]>val) a[i]=val;
            }
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}