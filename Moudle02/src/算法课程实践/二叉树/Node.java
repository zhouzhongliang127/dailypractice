package 算法课程实践.二叉树;

/**
 * @author zzl
 * @Description 二叉树节点
 * @date 2022/8/31 - 12:01
 */
public class Node {
     int val;
     Node left;
     Node right;
     Node parent;

    public Node(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
