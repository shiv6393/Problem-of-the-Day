import java.util.HashMap;

public class contest11thjanQ3 {
    String getstr(String s){
        StringBuilder str=new StringBuilder("");
           for(int j=0;j<s.length()-1;j++){
                int f=s.charAt(j);
                int l=s.charAt(j+1);
                if(l>f)str.append((l-f));
                else str.append((l+26 -f));
                
                } 
        return str.toString();
    }
    public long countPairs(String[] words) {
        HashMap<String,Integer>mpp=new HashMap<>();
        for(int i=0;i<words.length;i++){
            String str=getstr(words[i]);
            mpp.put(str,mpp.getOrDefault(str,0)+1);
            
        }
        long ans=0;
        for(int i=0;i<words.length;i++){
            String st=getstr(words[i]);
            if(mpp.containsKey(st)){
                int count=mpp.get(st);
                ans+=count-1;
                if(count==1)mpp.remove(st);
                else mpp.put(st,count-1);
            }
            
        }
        return ans;
    }
    
}
