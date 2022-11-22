package 算法课程实践.树;

public class 二叉树中节点的最大距离lc543 {
    static class ReturnData{
        int depth;
        int maxDistance;
        public ReturnData(int depth, int maxDistance){
            this.depth = depth;
            this.maxDistance = maxDistance;
        }
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        ReturnData res = process(root);
        return res.maxDistance;
    }

    public static ReturnData process(TreeNode root){
        if(root == null){
            return new ReturnData(0, 0);
        }
        ReturnData left = process(root.left);
        ReturnData right = process(root.right);
        int maxDistance = Math.max(left.maxDistance, right.maxDistance);
        maxDistance = Math.max(maxDistance, left.depth + right.depth);
        int depth = Math.max(left.depth , right.depth) + 1;
        return new ReturnData(depth, maxDistance);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.stringToTreeNode("[1,2,3,4,5]");
        System.out.println(diameterOfBinaryTree(root));
    }
}
