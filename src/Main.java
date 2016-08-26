import java.io.*;
import java.util.*;

public class Main {
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


        private int V;   // No. of vertices
        private LinkedList<Integer> adj[]; // Adjacency List
        Boolean[] visited;

        public void solve(InputReader scan, PrintWriter out) {
            V=scan.nextInt();
            visited=new Boolean[V+1];
            adj = new LinkedList[V+1];
            for (int i=0; i<V+1; ++i)
                adj[i] = new LinkedList();
            int edge=scan.nextInt();
            for (int i = 0; i < edge; i++) {
                addEdge(scan.nextInt(),scan.nextInt());
            }

            Stack<Integer> stack=new Stack<>();
            topologicalSortUtil(1,visited,stack);
            out.println(stack);
        }

        void addEdge(int v,int w) { adj[v].add(w); }

        void topologicalSortUtil(int v, Boolean visited[],Stack stack)
        {
            // Mark the current node as visited.
            visited[v] = true;
            Integer i;

            // Recur for all the vertices adjacent to this vertex
            for (Integer integer : adj[v]) {
                i = integer;
                if (!visited[i])
                    topologicalSortUtil(i, visited, stack);
            }

            // Push current vertex to stack which stores result
            stack.push(v);
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