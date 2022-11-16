package 算法课程实践.有序表与并查集;

import java.util.*;

/**
 * @author zzl
 * @Description
 * @date 2022/11/16 - 11:49
 */

class Element<V>{
    private V value;

    public Element(V value){
        this.value = value;
    }

}

public class UnionFindSet<V>{

    //元素与其包装后的元素的映射
    private HashMap<V, Element<V>> elementMap;
    //包装元素到其父节点的映射
    private HashMap<Element<V>, Element<V>> fatherMap;
    //集合大小, 标准元素所在集合->size
    private  HashMap<Element<V>, Integer> sizeMap;

    public UnionFindSet(List<V> list){
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for(V value : list){
            Element<V> element = new Element<>(value);
            elementMap.put(value, element);
            fatherMap.put(element, element);
            sizeMap.put(element, 1);
        }
    }

    /**
     * 给定一个元素，找到其所在集合的头
     * @param element
     * @return
     */
    public Element<V> findHead(Element<V> element){
        Deque<Element<V>> stack = new ArrayDeque<>();
        while(fatherMap.get(element) != element){
            stack.push(element);
            element = fatherMap.get(element);
        }

        //扁平化这个链，使其后续节点都指向头
        while(!stack.isEmpty()){
            fatherMap.put(stack.pop(), element);
        }
        return element;
    }

    /**
     * 判断两个元素是否在同一个集合中
     * @param a 元素 1
     * @param b 元素 2
     * @return true or false
     */
    public boolean isSameSet(V a, V b){
        if(elementMap.containsKey(a) && elementMap.containsKey(b)){
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }
        return false;
    }

    public void union(V a, V b){
        if(!elementMap.containsKey(a) && !elementMap.containsKey(b)){
            return;
        }
        Element<V> aF = findHead(elementMap.get(a));
        Element<V> bF = findHead(elementMap.get(b));
        if(aF != bF){
            Element<V> big = sizeMap.get(aF) > sizeMap.get(bF) ? aF : bF;
            Element<V> small = big == aF ? bF : aF;
            fatherMap.put(small, big);
            sizeMap.put(big, sizeMap.get(aF) + sizeMap.get(bF));
            sizeMap.remove(small);
        }
    }

    public static void main(String[] args) {
        String[] str = "q w e t a s df as".split(" ");
        List<String> list = Arrays.asList(str);
        UnionFindSet<String> unionFindSet = new UnionFindSet<>(list);
        System.out.println(unionFindSet.isSameSet("q", "w"));
        unionFindSet.union("q", "w");
        System.out.println(unionFindSet.isSameSet("q", "w"));
    }
}
