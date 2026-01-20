 import  java.util.*;
 public class Solution20thjanPod {
     public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums.get(i)==2){
                ans[i]=-1;
                continue;}
            for(int j=0;j<32;j++){
                if((nums.get(i) & (1<<j))!=0){
                    continue;
                    }
                else {
                    ans[i]=nums.get(i) ^(1<<j-1);
                    break;
                }
            }
        }
        return ans;
        
    }
    
}
