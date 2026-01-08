// 1458. Max Dot Product of Two Subsequences
import java.util.Arrays;
public class Pod8jan26 {
     private int helper(int i,int j,int[]n1,int[]n2 ,int[][]dp){
        if(i==n1.length || j==n2.length){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j]!=Integer.MIN_VALUE)return dp[i][j];
        int skip=Math.max(helper(i,j+1,n1,n2,dp),helper(i+1,j,n1,n2,dp));
        int take=n1[i]*n2[j]+Math.max(0,helper(i+1,j+1,n1,n2,dp));
        return dp[i][j]=Math.max(skip,take);
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][]dp=new int[nums1.length+1][nums2.length+1];
        for(int[]x:dp){
            Arrays.fill(x,Integer.MIN_VALUE);
        }
        return helper(0,0,nums1,nums2,dp);
        
    }
    
}
class Solution {
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][]dp=new int[nums1.length+1][nums2.length+1];
        for(int i=0;i<nums2.length;i++){
            dp[nums1.length][i]=Integer.MIN_VALUE;
        }
        for(int i=0;i<nums1.length;i++){
           dp[i][nums2.length]=Integer.MIN_VALUE;
        }
        for(int i=nums1.length-1;i>=0;i--){
            for(int j=nums2.length-1;j>=0;j--){
                int skip=Math.max(dp[i][j+1],dp[i+1][j]);
                int take=nums1[i]*nums2[j]+Math.max(dp[i+1][j+1],0);
                int maxProd=(Math.max(skip,take));
                dp[i][j]=maxProd;
            }
        }
        return dp[0][0];
        
    }
}

