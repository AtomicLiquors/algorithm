import java.util.*;
import java.io.*;

public class Main_B {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        int Limit = (int)Math.sqrt(N);
        for(int i = 2; i <= N; i++){
            while(N%i == 0){
                System.out.println(i);
                N /= i;
            }
        }
    }
}