package sum;

import java.util.Arrays;

public class Solution {
    //failed

    public static void main(String[] args) {
        System.out.println(
        checkSubarraySum(new int[]{1, 0, 1, 0,1}, 4)
        );
    }
    public static boolean checkSubarraySum(int[] nums, int k) {

        int len = nums.length;
        int[] sums = new int[len];
        sums[0] = nums[0];
        for(int i = 1; i < len; i++){
            sums[i] = nums[i] + sums[i-1];

            if(sums[i] % k == 0 ) return true;
        };


        int Lpt = 1;
        while(Lpt < len - 2){
            for(int Rpt = Lpt + 2; Rpt < len; Rpt++){
                sums[Rpt] -= sums[Lpt];

                System.out.println(Arrays.toString(sums));
                if(sums[Rpt] % k == 0) return true;
            }
            Lpt++;
        }

        return false;
    }
}