package leetcode;

import 算法课程实践.树.TreeNode;

public class lc337_打家劫舍2 {

    public class Info{
        int robMaxValue;
        int unRobMaxValue;

        public Info(int robMaxValue, int unRobMaxValue){
            this.robMaxValue = robMaxValue;
            this.unRobMaxValue = unRobMaxValue;
        }
    }

    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Info res = process(root);
        return Math.max(res.robMaxValue, res.unRobMaxValue);
    }

    public Info process(TreeNode root){
        if(root == null){
            return new Info(0, 0);
        }
        Info left = process(root.left);
        Info right = process(root.right);
        int rob = left.unRobMaxValue + right.unRobMaxValue;
        int unRob = Math.max(left.robMaxValue, left.unRobMaxValue) + Math.max(right.robMaxValue, right.unRobMaxValue);
        return new Info(rob, unRob);
    }

}
