import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_tree_1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] tree = new ArrayList[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if(idx == -1) {
                root = i;
                continue;
            }
            if(tree[idx] == null) tree[idx] = new ArrayList<>();
            tree[idx].add(i);
        }

        int removed = Integer.parseInt(br.readLine());
        if(removed == root){
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(root);
        int curr;
        int result = 0;
        while(!q.isEmpty()){
            curr = q.poll();
            int cnt = 0;
            if(tree[curr]!=null){
                for (int i = 0; i < tree[curr].size(); i++) {
                    int next = tree[curr].get(i);
                    if(next==removed) continue;
                    q.offer(next);
                    cnt++;
                }
            }

            if(cnt==0) result++;
        }

        System.out.println(result);
    }
}
