package 算法课程实践.树;

import java.util.*;

/**
 * @author zzl
 * @Description
 * @date 2022/8/31 - 12:03
 */
public class BTraversal {
    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order:");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while(!stack.isEmpty()){
                 head = stack.pop();
                System.out.print(head.val + ' ');
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void postOrderUnRecur1(Node head){
        System.out.println("post-order:");
        if(head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if(head.left != null){
                    stack1.push(head.left);
                }
                if(head.right != null){
                    stack1.push(head.right);
                }
            }
            while(!stack2.isEmpty()){
                System.out.print(stack2.pop().val + " ");
            }
            System.out.println();
        }
    }

    public static void inOrderUnRecur(Node head){
        System.out.println("in-order:");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                while(head != null){
                    stack.push(head);
                    head = head.left;
                }
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
    }

    public static void levelOrder(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(head);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }

    }

    public static int maxTreeWidth_1(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(head);
        Map<Node,Integer> map = new HashMap<>();
        map.put(head,1);
        int max = -1;

        int curLevel = 1;//记录当前层级
        int curLevelNodes = 0;//记录当前层级有多少个节点
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            // 获取当前节点的层级
            int curNodeLevel = map.get(cur);
            //判断是否是当前层节点
            if(curNodeLevel == curLevel){
                curLevelNodes++;
            }else{
                //这个else只有当遇到新层级节点的时候才会进入
                //所以最后一个元素弹出后curLevelNodes还需要和max比较一下
                max = Math.max(max, curLevelNodes);
                //到了新的一层，层数加一，节点数重新统计
                curLevelNodes = 1;
                curLevel++;
            }

            //核心思想部分，在孩子进入队列的时候根据父节点的层级确定好孩子的层级
            if(cur.left != null){
                queue.offer(cur.left);
                map.put(cur.left,curNodeLevel + 1);
            }
            if(cur.right != null){
                queue.offer(cur.right);
                map.put(cur.right, curNodeLevel + 1 );
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    public static int maxTreeWidth_2(Node head) {
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(head);
        int max = -1;
        while(!queue.isEmpty()){
            int n = queue.size();
            max = Math.max(max, n);
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return max;
    }
    public static int maxTreeWidth_3(Node head) {
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(head);
        int max = -1;
        Node curEnd = head;
        Node nextEnd = null;
        int curLevelNodes = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            curLevelNodes++;
            if(node.left != null){
                queue.offer(node.left);
                nextEnd = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                nextEnd = node.right;
            }
            if(node == curEnd){
                max = Math.max(max, curLevelNodes);
                curEnd = nextEnd;
                curLevelNodes = 0;
            }
        }
        return max;
    }

    public static int preValue = Integer.MIN_VALUE;

    /**
     * 功能描述: <br>
     * <是否平衡二叉树>
     * @param root 树的根节点
     * @Return: boolean
     * @Author: zzl
     * @Date: 2022/9/5 10:10
     */
    public static boolean isBST(Node root){
        if(root == null){
            return true;
        }

        boolean isLeftBst = isBST(root.left);
        if(!isLeftBst){
            return false;
        }
        if(root.val <= preValue){
            return false;
        }else{
            preValue = root.val;
        }
        //如果左子树是，那么去访问右子树，右子树是则返回true
        return isBST(root.right);
    }

    public static class ReturnData{
         int min;
         int max;
         boolean isBST;

         public ReturnData(int min, int max, boolean isBST){
             this.min = min;
             this.max = max;
             this.isBST = isBST;
         }
    }

    /**
     * 功能描述: <br>
     * <判断是否平衡二叉树——递归>
     * @param root
     * @Return: boolean
     * @Author: zzl
     * @Date: 2022/9/5 11:04
     */
    public static boolean isBST_Recur(Node root){
        return process_1(root).isBST;
    }

    public static ReturnData process_1(Node root) {
        if (root == null) {
            //对于空，也返回一个万能对象，可以避免后面多次判空操作
            return new ReturnData(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        ReturnData leftData = process_1(root.left);
        ReturnData rightData = process_1(root.right);


        int min = Math.min(leftData.min, rightData.min);
        min = Math.min(root.val, min);
        int max = Math.max(leftData.max, rightData.max);
        max = Math.max(root.val, max);

        //左右子树都为搜索二叉树 & 根.val大于左max小于左min
        boolean isBST = leftData.isBST && rightData.isBST && root.val > leftData.max && root.val < rightData.min;

        return new ReturnData(min, max, isBST);
    }


    //判平衡二叉树递归—优化后
    public boolean isValidBST(Node root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);//定义一个node的值得区间范围
    }
    public boolean isValidBST(Node node, long minVal, long maxVal) {
        if (node == null) {//空树也是一个搜索树
            return true;
        }
        if (node.val<=minVal||node.val>=maxVal) {//如果不在这个区间则返回false
            return false;
        }
        //递归遍历左右子树，左子树时修改上界为当前节点值，右子树时修改下界为当前节点值
        return isValidBST(node.left,minVal,node.val)&&isValidBST(node.right,node.val,maxVal);
    }


    public static boolean isCompleteTree(Node root) {
        if (root == null) {
            return true;
        }

        boolean leaf = false;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Node l = cur.left;
            Node r = cur.right;
            //如果是叶子节点且有孩子 || 如果有右孩子无左孩子
            if (
                    (leaf && (l != null || r != null))
                            ||
                    (l == null && r != null)
            ) {
                return false;
            }

            //这个节点正常，孩子入队
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }

            //判断后续是否都应是叶子
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static class ReturnType{
        int height;
        boolean isBalanced;

        public ReturnType(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static boolean isBalanced(Node root){
        return process(root).isBalanced;
    }

    public static ReturnType process(Node root){
        if(root == null){
            return new ReturnType(0,true);
        }

        ReturnType leftData = process(root.left);
        ReturnType rightData = process(root.right);

        //获得左右子树信息后，准备返回当前书的深度以及平衡性
        //当前树高度等于较大子树高度加一
        int height = Math.max(leftData.height,rightData.height) + 1;
        //判断当前树是否平衡
        boolean isBalanced =
                leftData.isBalanced & rightData.isBalanced
                & (Math.abs(leftData.height - rightData.height) <= 1);

        return new ReturnType(height, isBalanced);
    }

    public static Node getSuccessorNode(Node node){
        if(node == null){
            return null;
        }

        //右子树不空，必先去访问右子树，后继节点为右子树最左节点
        if(node.right != null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }else{
            //右子树为空，当前节点及子树已访问完，作为一个已访问完的子树可能在某个节点左边或右边
            Node parent = node.parent;
//            if(parent.left == node){
//                return parent;
//            }
            // 已访问子树在右，parent节点为根子树以访问完
            // 这是一个向上遍历的过程，如果一个节点的右子树是一颗完成遍历的子树，
            // 那么必然该节点为根子树也已经访问完，继续向上搜索，直到已完成遍历的子树是某个节点左孩子
            // 那么下一个要访问的介绍当前节点
            while(parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(Node root) {

        StringBuilder res = new StringBuilder("[");

        inOrderSerialize(root, res);
        // delete the latest ","
        res.delete(res.length() - 1,res.length());
        return res.append("]").toString();
    }

    public static void inOrderSerialize(Node root, StringBuilder res){
        if(root == null){
            res.append("null,");
            return;
        }
        res.append(root.val + ",");

        inOrderSerialize(root.left, res);
        inOrderSerialize(root.right, res);

    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        //如果当前节点为空，拼接“null,”后返回
        if(data == null){
            return null;
        }

        data = data.substring(1,data.length() - 1);//去除左右方括号

        //提取节点值存于queue中
        String[] nodeValues = data.split(",");
        Queue<String> queue = new ArrayDeque<>();
        for (String value : nodeValues) {
            queue.offer(value);
        }

        //按照先序的顺序创建节点
        Node head = reconPreOrder(queue);

        return head;
    }

    //按什么方式序列化的就按照什么方式再构建
    public static Node reconPreOrder(Queue<String> nodeQueue){
        String s = nodeQueue.poll();
        if(s.equals("null")){
            return null;
        }
        Node node = new Node(Integer.parseInt(s));
        node.left = reconPreOrder(nodeQueue);
        node.right = reconPreOrder(nodeQueue);

        return node;
    }


    public static void printAoTu(int level, int N, boolean flag){
        if(level > N ){
            return;
        }
        printAoTu(level + 1, N, true);
        System.out.println(flag ? "凹" : "凸");
        printAoTu(level + 1, N, false);
    }

    public static void main(String[] args) {
        // 构造二叉树
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
//        n4.left = n8;
//        levelOrder(root);
//        System.out.println(isBST(root));
//        System.out.println(maxTreeWidth_3(root));
        //double的MINVALUE指的是大于零的最小值,double，float都是这样[MINVALUE,MAXVALUE]都是大于0
//        System.out.println(Double.MIN_VALUE < Integer.MIN_VALUE);
//        System.out.println(isCompleteTree(root));
//        System.out.println(isBalanced(root));
//        System.out.println(getSuccessorNode(n5).val);
//        levelOrder(deserialize(serialize(root)));
        printAoTu(1, 3, true);
    }
}
