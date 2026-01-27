import java.util.ArrayList;
public class SolutionDfsGraph {
    private void dfsHelper(int n,ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>ans,boolean[]isVisited){
        for(int x:adj.get(n)){
            if(!isVisited[x]){
                ans.add(x);
                isVisited[x]=true;
                dfsHelper(x,adj,ans,isVisited);
            }
            
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n=adj.size();
        boolean isVisited[]=new boolean[n];
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(0);
        isVisited[0]=true;
        dfsHelper(0,adj,ans,isVisited);
        return ans;
        
    }
}
