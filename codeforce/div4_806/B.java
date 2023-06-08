package codeforce.div4_806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Map map;
        for (int i = 0; i < T; i++) {
            map  = new HashMap<>();
           int n = Integer.parseInt(br.readLine());
           int cnt = 0;
           String str = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = str.charAt(j);
                if(map.get(c) != null){
                    cnt++;
                }else{
                    cnt += 2;
                    map.put(c, 1);
                }
            }
            System.out.println(cnt);
        }
    }
}
