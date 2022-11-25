package 算法课程实践.树;



public class DistanceBetweenTwoTreeNode {

    public int getDistance(TreeNode root, int p, int q){
        if(root == null || p == q) {
            return 0;
        }

        int res = process(root, 0, p, q);
        return res;

    }

    public int process(TreeNode root, int depth, int p, int q){
        if(root == null){
            return 0;
        }

        int left = process(root.left, depth + 1, p, q);
        int right = process(root.right, depth + 1, p, q);

        if(root.val == p || root.val == q){
            //情况一：当前节点是p or q，此时检查孩子是否有另一个，没有则返回当前深度，有则返回深度差作为结果
            int anotherDepth = left == 0 ? right : left;
            return anotherDepth == 0 ? depth : anotherDepth - depth;
        }else if(left != 0 && right != 0){
            //情况二：p，q在当前节点两边，此时计算两边深度差之和作为结果返回
            return left + right - depth * 2;
        }else {
            //这里是一种复合情况，首先是一边有值返回，可能是结果，也可能是p或者q的深度，直接返回不为0的值
            //如果都为0，则也能正常返回0
            return left != 0 ? left : right;
        }
    }

    public static void main(String[] args) {

        TreeNode root1 = TreeUtils.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode root2 = TreeUtils.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode root3 = TreeUtils.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        DistanceBetweenTwoTreeNode v= new DistanceBetweenTwoTreeNode();
        System.out.println(v.getDistance(root1, 5, 0));
        System.out.println(v.getDistance(root2, 5, 7));
        System.out.println(v.getDistance(root2, 5, 5));
    }

}
