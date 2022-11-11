package 算法课程实践.图;

import java.util.*;

/**
 * @author zzl
 * @Description
 * @date 2022/9/8 - 11:00
 */
public class 图的遍历 {
    public static void bfs(Node node){
        if(node == null){
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        HashSet<Node> set = new HashSet<>();//用来判重，访问过的入set不再入队
        queue.offer(node);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            //访问完当前节点之后，将当前节点所指向的未访问节点入队
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    queue.offer(next);
                    set.add(next);
                }
            }

        }
    }

    public static void dfs(Node node){
        if(node == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();

        //开始节点入栈，入set， 访问
        stack.push(node);
        set.add(node);

        System.out.println(node.value);

        while(!stack.isEmpty()){
            //栈不空，弹出一个节点，去访问他的第一个未被访问的孩子
            Node cur = stack.pop();
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    //如果当前节点间未被访问，先把cur(上一步的节点）压入栈，再把当前节点入set入栈
                    //然后跳出cur的next遍历，准备往深处走
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);

                    System.out.println(next.value);

                    break;
                }
            }

        }
    }

    public static List<Node> TopologySort(Graph graph){

        Queue<Node> zeroInQueue = new ArrayDeque<>();
        Map<Node, Integer> map = new HashMap<>();// <node,in>

        //初始化入度为0的队列和节点map
        for(Node node : graph.nodes.values()){
            map.put(node, node.in);
            if(node.in == 0){
                zeroInQueue.offer(node);
            }
        }

        //开始拓扑排序
        List<Node> result = new ArrayList<>();
        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            for(Node node : cur.nexts){
                map.put(node, map.get(node) - 1);
                if(map.get(node) == 0){
                    zeroInQueue.offer(node);
                }
            }
        }
        return result;
    }
}
