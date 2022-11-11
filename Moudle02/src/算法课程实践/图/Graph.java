package 算法课程实践.图;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zzl
 * @Description
 * @date 2022/9/8 - 10:30
 */
public class Graph {

    //存图中所有节点，并建立图的节点编号和和节点的一个映射
    public HashMap<Integer, Node> nodes;

    //用set存边
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
