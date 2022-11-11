package 算法课程实践.图;

/**
 * @author zzl
 * @Description
 * @date 2022/9/10 - 17:59
 */
public class TireTree {
    public class TireNode{
        int pass;
        int end;
        TireNode[] nexts;//Hashmap<Char, Node>

        public TireNode(){
            //初始化26个指向下一层节点的指针
            nexts = new TireNode[26];
        }
    }

    public class Tire{
        private TireNode root;

        public Tire(){
            //初始化前缀树的根节点
            root = new TireNode();
        }

        //往前缀树中插入字符串
        public void insert(String str){

            if(str == null){
                return;
            }

            //初始化工作指针，且根节点的pass++
            TireNode node = root;
            node.pass++;

            int index = 0;//当前字符对应节点在nexts数组中的下标

            //遍历str的每个字符，存入前缀树
            for(char c : str.toCharArray()){
                index = c - 'a';
                //看是否存在字符对应的路径(或节点）
                if(node.nexts[index] == null){
                    node.nexts[index] = new TireNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            //遍历结束后node指向最后一个字符对应的节点
            node.end++;
        }

        public int search(String str){
            if(str == null){
                return root.end;
            }

            TireNode node = root;
            int index = 0;

            for(char c : str.toCharArray()){
                index = c - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }

            return node.end;
        }

        public void delete(String str){
            if(str == null){
                return;
            }
            //check isExists before delete
            if(search(str) == 0){
                return;
            }

            TireNode node = root;
            node.pass--;
            int index = 0;

            //字符对应节点的pass--,结束节点的end--

            //这里要注意，当一个节点的pass值为0时，代表没有字符会走到这，要将该节点释放
            //所以这里不要先去下一层节点，先判断下一层对应节点pass--后是否为0，是则释放空间，返回
            for(char c : str.toCharArray()){
                index = c - 'a';
                if(--node.nexts[index].pass == 0){
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
        public int prefixNumber(String prefix){

            if(prefix == null){
                return root.end;//空字符处理存疑，返回0？
            }

            TireNode node = root;
            int index = 0;

            for(char c : prefix.toCharArray()){
                index = c - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}
