package codeforce.div3_888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            boolean[] oddOrEven = new boolean[N];
            PriorityQueue<Integer> pqOdd = new PriorityQueue<>();
            PriorityQueue<Integer> pqEven = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int curr;
            for (int j = 0; j < N; j++) {
                curr = Integer.parseInt(st.nextToken());
                if(curr % 2 == 0) {
                    oddOrEven[j] = true;
                    pqEven.offer(curr);
                }else{
                    pqOdd.offer(curr);
                }
            }
            int prev = 0;
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                if(oddOrEven[j])
                    curr = pqEven.poll();
                else
                    curr = pqOdd.poll();

                if (prev > curr){
                    flag = false;
                    break;
                }
                prev = curr;
            }
            System.out.println( (flag?"YES":"NO") );
        }
    }
}
