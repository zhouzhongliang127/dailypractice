package 算法课程实践.图;

import java.util.ArrayList;

/**
 * @author zzl
 * @Description
 * @date 2022/9/8 - 10:08
 */
public class Node {

    int value;

    //optional
    int in;//入度
    int out;//出度

    public ArrayList<Node> nexts;//该节点的指向的节点
    public ArrayList<Edge> edges;//属于该节点的边（往外指的边）

    public Node(int value) {
        this.value = value;
        //出入度初始化为0,,同时初始化nexts和edges
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
