import java.util.ArrayList;
import java.util.List;

/**
 * @author zzl
 * @Description
 * @date 2021/11/22 - 8:33
 */
public class Info{
    int freq;
    List<Integer> list = new ArrayList<>();
    public Info(){}
    public Info(int freq, int index){
        this.freq = freq;
        list.add(index);
    }
}