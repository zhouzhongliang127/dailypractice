package 算法课程实践.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MorrisTraversal {


    /**
     * Morris遍历
     * @param root
     * @return
     */
    public void morris(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode cur = root;
        while(cur != null){

            TreeNode mostRight = cur.left;//左树最右节点初始为左孩子

            //如果有左孩子
            if(mostRight != null){
                //找到左树最右节点
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right != cur){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }
            //没有左孩子
            cur = cur.right;
        }

    }

    /**
     * Morris 先序遍历
     * @param root
     * @return
     */
    public static List<Integer> morris_preorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        TreeNode cur = root;
        while(cur != null){

            TreeNode mostRight = cur.left;//左树最右节点初始为左孩子

            //如果有左孩子
            if(mostRight != null){
                //找到左树最右节点
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right != cur){
                    //有左孩子的节点第一次的时候访问
                    res.add(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }else{
                //没有左孩子的节点直接访问
                res.add(cur.val);
            }
            //没有左孩子
            cur = cur.right;

        }
        return res;
    }

    /**
     * Morris 中序遍历
     * @param root
     * @return
     */
    public static List<Integer> morris_inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        TreeNode cur = root;
        while(cur != null){

            TreeNode mostRight = cur.left;//左树最右节点初始为左孩子

            //如果有左孩子
            if(mostRight != null){
                //找到左树最右节点
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right != cur){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                }
            }
            //没有左孩子
            res.add(cur.val);
            cur = cur.right;

        }
        return res;
    }

    /**
     * Morris 后序遍历
     * @param root
     * @return
     */
    public static List<Integer> morris_postorder(TreeNode root){
        if(root == null){
            return null;
        }
        //LinkedList实现了List和Deque，当用List类型的变量指向LinkedList的对象时只能使用List中声明的方法，对Deque同理
        //Deque<Integer> res = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        LinkedList<Integer> list;

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
                    //后序遍历需要在这里（第二次来到某个节点），逆序收集左树的有边界
                    TreeNode node = cur.left;
                    //list暂存逆序收集的右边界
                    list = new LinkedList<>();
                    while(node != null){
                        list.addFirst(node.val);
                        node = node.right;
                    }
                    //右边界内部逆序，不同右边界直接按正常顺序
                    res.addAll(list);
                }
            }
            cur = cur.right;
        }
        cur = root;
        list = new LinkedList<>();
        while(cur != null){
            list.addFirst(cur.val);
            cur = cur.right;
        }
        res.addAll(list);

        return res;
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtils.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        System.out.println("morris-preorder:");
        System.out.println(morris_preorder(root));
        BTraversal.preOrderUnRecur(root);
        System.out.println("morris-inorder:");
        System.out.println(morris_inorder(root));
        BTraversal.inOrderUnRecur(root);
        System.out.println("morris-postorder:");
        System.out.println(morris_postorder(root));
        BTraversal.postOrderUnRecur1(root);

    }
}
