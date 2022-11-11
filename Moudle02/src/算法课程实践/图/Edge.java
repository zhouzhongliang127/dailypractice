package 算法课程实践.图;

/**
 * @author zzl
 * @Description
 * @date 2022/9/8 - 10:08
 */
public class Edge {

    int weight;
    int from;
    int to;

    public Edge(int weight, int from, int to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from.value;
        this.to = to.value;
    }
}
