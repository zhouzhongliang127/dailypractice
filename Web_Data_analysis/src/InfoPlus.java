import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zzl
 * @Description
 * @date 2021/11/29 - 8:58
 */
public class InfoPlus {
    int freq;
    List<Integer> list = new ArrayList<>();
    //在各个文档中出现的次数列表
    List<Integer> tFreq;
    public InfoPlus(int filesAmount){
        //将单词再各个文档中出现的次数置为0
        Integer[] data = new Integer[filesAmount];
        Arrays.fill(data,new Integer(0));
        this.tFreq = Arrays.asList(data);
    }
    public InfoPlus(int freq, int index, int filesAmount){
        this.freq = freq;
        //将单词再各个文档中出现的次数置为0
        Integer[] data = new Integer[filesAmount];
        Arrays.fill(data,new Integer(0));
        this.tFreq = Arrays.asList(data);
        list.add(index);
        tFreq.set(index-1, 1);
    }
}
