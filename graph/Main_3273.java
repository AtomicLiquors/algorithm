package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if(input[i] + input[j] == X){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
