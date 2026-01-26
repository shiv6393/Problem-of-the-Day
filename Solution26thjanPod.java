public class Solution26thjanPod {
     public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int minDiff=Integer.MAX_VALUE;
        HashMap<Integer,List<List<Integer>>>absDiff=new HashMap<>();
        for(int i=1;i<n;i++){
            int diff=Math.abs(arr[i]-arr[i-1]);
            minDiff=Math.min(minDiff,diff);
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=1;i<n;i++){
             int diff=Math.abs(arr[i]-arr[i-1]);
             if(diff==minDiff){
                ans.add(Arrays.asList(arr[i-1],arr[i]));
             }
        }
        return ans;
    }
    
}
