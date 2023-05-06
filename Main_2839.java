import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int div;
        int result, temp;
        for (div = (N/5); div >= 0; div--) {
            result = div;
            temp = N-(5*div);
            if(temp%3 != 0) continue;
            result += (temp/3);
            System.out.println(result);
            return;
        }
        System.out.println(-1);
    }
}
