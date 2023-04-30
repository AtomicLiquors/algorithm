import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_tree_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parents = new int[N+1];
        int[] length = new int[N+1];
        List<Integer>[] adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        parents[1] = -1;
        StringTokenizer st;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
            length[from]++;
            length[to]++;
        }



        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        int curr;
        while(!q.isEmpty()){
            curr = q.poll();
            for (int i = 0; i < length[curr]; i++) {
                int target = adjList[curr].get(i);
                if(parents[target] == 0){
                    parents[target] = curr;
                    q.offer(target);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);


    }
}
