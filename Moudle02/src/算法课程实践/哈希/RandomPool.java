package 算法课程实践.哈希;

import java.util.HashMap;

/**
 * @author zzl
 * @Description 实现一个结构，可以以O(1)的时间复杂度随机返回一个之前添加的元素
 * @date 2022/11/3 - 14:48
 */
public class RandomPool<K> {

    private HashMap<K, Integer> keyIndexMap;//元素到下标的映射
    private HashMap<Integer, K> indexKeyMap;//下标到元素的映射
    private int size;//记录此时的元素个数

    public RandomPool(){
        keyIndexMap = new HashMap<>();
        indexKeyMap = new HashMap<>();
        this.size = 0;
    }


    /**
     * 插入元素
     * @param key
     */
    public void insert(K key){
        if(!keyIndexMap.containsKey(key)){
            keyIndexMap.put(key, size);
            indexKeyMap.put(size, key);
            this.size++;
        }
    }

    /**
     * 删除元素
     */
    public void delete(K key){
        //删除逻辑：先确定有，然后将最后一个元素‘填充’到该位置，
        //具体操作是将最后一个key->index的index改成当前要删的元素的index，然后删除keyIndexMap中的当前元素
        //然后将index->key的该元素的index所对应的key改成最后一个元素的key，然后删除indexKeyMap的最后一个元素
        if(keyIndexMap.containsKey(key)){
            size--;
            int index = keyIndexMap.get(key);
            K lastKey = indexKeyMap.get(size);
            keyIndexMap.put(lastKey, index);
            keyIndexMap.remove(key);
            indexKeyMap.put(index, lastKey);
            indexKeyMap.remove(size);

        }
    }

    public K getRandom(){
        if(size == 0) return null;

        int index =(int)(Math.random() * size);// 0 ~ size - 1

        return indexKeyMap.get(index);
    }

    public static void main(String[] args){
        RandomPool<String> str = new RandomPool<>();
        str.insert("zhang");
        str.insert("xue");
        str.insert("jia");
        str.insert("you");
        System.out.println(str.getRandom());
        str.delete("zhang");
        System.out.println(str.getRandom());
        System.out.println(str.getRandom());
        System.out.println(str.getRandom());
        System.out.println(str.getRandom());
        System.out.println(str.getRandom());
        System.out.println(str.getRandom());
    }
}
