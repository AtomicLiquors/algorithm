package codeforce.div3_874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Boolean> map;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            int lpt = 0;
            int rpt = 1;
            String melody = br.readLine();
            int cnt = 0;
            for (; rpt < N; rpt++ ) {
                int key =
                        (melody.charAt(lpt) - '0')
                        +
                        (melody.charAt(rpt)-'0') * 100;
                if(map.get(key) == null){
                    cnt++;
                    map.put(key, Boolean.TRUE);
                }
                lpt++;
            }
            System.out.println(cnt);
        }



    }
}
