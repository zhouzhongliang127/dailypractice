package leetcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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

    public static Node stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        Node root = new Node(Integer.parseInt(item));
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new Node(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new Node(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(Node root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            Node root = stringToTreeNode(line);

            Node ret = connect(root);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}
