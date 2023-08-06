package codeforce.div3_888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] colors = new int[n];
            boolean[] visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                colors[i] = Integer.parseInt(st.nextToken());
            }

            int lpt = 0;
            int rpt = n-1;
            int firstValue = colors[lpt];
            int lastValue = colors[rpt];

            if(k==1){
                System.out.println("YES");
                continue;
            }else if(n==1){
                System.out.println("NO");
                continue;
            }

            boolean flag = false;
            if(firstValue == lastValue){
                int count = 1;
                for (int i = 1; i < n; i++) {
                    if(colors[i] == firstValue){
                        count++;
                        if(count >= k){
                            flag = true;
                            break;
                        }
                    }

                }
                System.out.println( (flag?"YES":"NO") );
            }else{
                flag = true;
                for (int i = 0; i < k-1; i++) {
                    lpt++;
                    if (lpt >= n) {
                        flag = false;
                        break;
                    }
                    while (colors[lpt] != firstValue) {
                        lpt++;
                        if (lpt >= n) {
                            flag = false;
                            break;
                        }
                    }
                }
                for (int i = 0; i < k-1; i++) {
                    rpt--;
                    if (rpt <= lpt){
                        flag = false;
                        break;
                    }

                    while (colors[rpt] != lastValue) {
                        rpt--;
                        if (rpt <= lpt) {
                            flag = false;
                            break;
                        }
                    }
                }
                System.out.println( (flag?"YES":"NO") );
            }



        }
    }
}
