import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String cmdStr = br.readLine();
            int N = Integer.parseInt(br.readLine());


            Deque<Integer> dq = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine(), "[],");
            for (int i = 0; i < N; i++) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }

            boolean reversed = false;
            boolean error = false;

            for (int i = 0; i < cmdStr.length(); i++) {
                char cmd = cmdStr.charAt(i);
                if(cmd=='R'){
                    reversed = !reversed;
                }else if (cmd=='D'){
                    try {
                        if(reversed) dq.removeLast();
                        else dq.removeFirst();
                    }catch (Exception e){
                        error = true;
                        break;
                    }
                }
            }
            if(error) System.out.println("error");
            else {
                int[] result = new int[dq.size()];
                int idx = 0;
                if(reversed){
                    while (!dq.isEmpty()){
                        result[idx] = dq.pollLast();
                        idx++;
                    }
                }else{
                    while (!dq.isEmpty()){
                        result[idx] = dq.pollFirst();
                        idx++;
                    }
                }
                System.out.println(Arrays.toString(result).replace(" ",""));
            }
        }


    }
}
