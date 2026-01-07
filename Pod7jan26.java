// 1339. Maximum Product of Splitted Binary Tree
public class Pod7jan26 {
    private long totalSum(TreeNode root){
        if(root==null)return 0;
        long leftSum=totalSum(root.left);
        long rightSum=totalSum(root.right);
        return leftSum+rightSum+root.val;
    }
    private  long[]maxProd=new long[1];
    private static int modulo =1000000007;
    public int maxProduct(TreeNode root) {
        long total=totalSum(root);
        helper(root,total);
        return(int) (maxProd[0]%modulo);     
    }
    long helper(TreeNode root,long total){
        if(root==null)return 0;
        long left=helper(root.left,total);
        long right=helper(root.right,total);
        maxProd[0]=Math.max(Math.max(left*(total-left),right*(total-right)),maxProd[0]);
        return left+right+root.val;
    }
} 

