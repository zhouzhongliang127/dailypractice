package 算法课程实践.图;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author zzl
 * @Description
 * @date 2022/9/9 - 14:16
 */
public class Kruskal {

    public class edgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public Set<Edge> primMST(Graph graph){

        //初始化一个优先级队列用来存当前生成树的边
        PriorityQueue<Edge> queue = new PriorityQueue<>(new edgeComparator());

        //初始化一个set存当前的生成树节点
        Set<Node> set = new HashSet<>();

        //结果
        Set<Edge> res = new HashSet<>();

        for(Node node : graph.nodes.values()){//避免森林的情况
            if(!set.contains(node)){
                //开始节点入set，开始节点的边入队
                set.add(node);
                for(Edge edge : node.edges){
                    queue.add(edge);
                }
                while(!queue.isEmpty()){
                    //取出当前生成树的最短出边和指向节点
                    Edge edge = queue.remove();
                    Node toNode = graph.nodes.get(edge.to);
                    if(!set.contains(toNode)){
                        //如果这条边没有指向当前生成树内的节点，代表不会成环，可以作为结果
                        set.add(toNode);//to的节点入生成树
                        res.add(edge);//该边入结果集
                        //toNode的不指向set内节点的出边入队
                        for(Edge nextEdge : toNode.edges){
                            if(!set.contains(graph.nodes.get(nextEdge.to))){
                                queue.add(nextEdge);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

}
