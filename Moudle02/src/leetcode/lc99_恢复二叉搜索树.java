package leetcode;

import 算法课程实践.树.TreeNode;

public class lc99_恢复二叉搜索树 {

    TreeNode node1 = null;
    TreeNode node2 = null;
    TreeNode preNode = null;
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;

        //Morris 遍历
        while(cur != null){
            TreeNode mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }
            if(preNode != null && preNode.val >= cur.val){
                if(node1 == null){
                    node1 = preNode;
                }
                node2 = cur;
            }
            //与前一个节点比较完之后，pre后移到当前位置
            preNode = cur;
            cur = cur.right;
        }
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
