import java.util.HashSet;

public class contest11thjanQ2 {
    public int centeredSubarrays(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sumSubarrays=0;
            HashSet<Integer>st=new HashSet<>();
            for(int j=i;j<nums.length;j++){
                sumSubarrays+=nums[j];
                st.add(nums[j]);
                if(st.contains(sumSubarrays))count++;
                
            }
        }return count;
        
    }
    
}
