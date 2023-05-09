import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int order;
    int level;

    public Node(int order, int level){
        this.order = order;
        this.level = level;
    }
}

public class Main_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Integer[] levels = new Integer[N];
            int pt = 0;
            Queue<Node> printQueue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                levels[i] = Integer.parseInt(st.nextToken());
                printQueue.offer(new Node(i, levels[i]));
            }
            Arrays.sort(levels, Collections.reverseOrder());

            while(!printQueue.isEmpty()){
                Node curr = printQueue.poll();
                if(curr.level < levels[pt])
                    printQueue.offer(curr);
                else{
                    if(curr.order == M){
                        System.out.println(pt+1);
                        break;
                    }else{
                        pt++;
                    }

                }
            }
        }

    }
}
