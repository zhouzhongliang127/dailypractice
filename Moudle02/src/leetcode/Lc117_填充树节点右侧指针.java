package leetcode;


import 算法课程实践.树.TreeNode;
import 算法课程实践.树.TreeUtils;

import java.io.IOException;

/**
 * @author zzl
 * @Description
 * @date 2022/9/29 - 11:12
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class Lc117_填充树节点右侧指针 {



    public static Node connect(Node root) {
        if(root == null){
            return root;
        }

        if(root.left == null && root.right == null){
            return root;
        }
        //找到当前节点的next中第一个有孩子的节点
        Node p = root.next;
        while( p != null){
            if(p.left != null || p.right != null){
                break;
            }
            p = p.next;
        }
        if(root.left != null){
            if(root.right != null){
                root.left.next = root.right;
                if(p != null){
                    root.right.next = p.left != null ? p.left : p.right;
                }
            }else{
                if(p != null){
                    root.left.next = p.left != null ? p.left :p.right;
                }
            }
        }else{
            if(p != null){
                root.right.next = p.left != null ? p.left :p.right;
            }
        }

        connect(root.left);
        connect(root.right);
        return root;
    }
    public static void main(String[] args) throws IOException {
        TreeNode treeNode = TreeUtils.stringToTreeNode("[1,2,3,4,5]");
    }
}
