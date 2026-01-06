//Dfs method......1
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;
// public class MaxLevelSum {
//      HashMap<Integer,Integer>mpp=new HashMap<>();
//     public int maxLevelSum(TreeNode root) {
//         // if(root.left==null && root.right==null)return root.val;
//         helper(root,1);
//         int maxSum=Integer.MIN_VALUE;
//         int ans=0;

//         for(Map.Entry<Integer,Integer>entry:mpp.entrySet()){
//             if(entry.getValue()>maxSum){
//                 ans=entry.getKey();
//                 maxSum=entry.getValue();
//             }
//              System.out.println(entry.getKey());
//              System.out.println(entry.getValue());
//         }
//         return ans; 
//     }
//    private void helper(TreeNode root,int level ){
//     if(root==null)return;
//     if(mpp.containsKey(level)){
//         mpp.put(level,mpp.get(level)+root.val);

//     }
//     else mpp.put(level,root.val);
//     helper(root.left,level+1);
//     helper(root.right,level+1);
//    }
    
// }
//dfs method 2
// class Solution {
//     List<Integer> sums = new ArrayList<>();

//     public int maxLevelSum(TreeNode root) {
//         dfs(root, 0);

//         int maxSum = Integer.MIN_VALUE;
//         int level = 1;

//         for (int i = 0; i < sums.size(); i++) {
//             if (sums.get(i) > maxSum) {
//                 maxSum = sums.get(i);
//                 level = i + 1;
//             }
//         }
//         return level;
//     }

//     private void dfs(TreeNode node, int level) {
//         if (node == null) return;

//         if (level == sums.size()) {
//             sums.add(node.val);
//         } else {
//             sums.set(level, sums.get(level) + node.val);
//         }

//         dfs(node.left, level + 1);
//         dfs(node.right, level + 1);
//     }
// }
// BFS method

class MaxLevelSum {
    static class MaxPair{
        int maxSum=0;
        int level =0;
    }
    public int maxLevelSum(TreeNode root) {
        MaxPair pair=new MaxPair();
        pair.maxSum=root.val;
        pair.level=1;
        int level=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            int sum=0;
            level++;
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);

            }
            if(pair.maxSum<sum){
                pair.maxSum=sum;
                pair.level=level;
            }
        }
        return pair.level;
    }
}
