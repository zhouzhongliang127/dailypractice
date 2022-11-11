import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;


public class Exercise_04 {
    static public double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }

    public static void creatInvertedIndex(String filePath){
        Map<String,InfoPlus> map = new HashMap<>();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File file = new File("document");
            bw = new BufferedWriter(new FileWriter("document//indexFilePlus.txt"));
            File[] subFiles = file.listFiles();
            //统计该文件夹下有多少个文件，如果有其他文件需要用循环来计数
            int filesAmount = subFiles.length;
            //记录当前遍历到的文件下标
            int fileIndex = 0;
            //遍历该文件夹下文件
            for (File subFile : subFiles) {
                if(subFile.isFile()){
                    fileIndex++;
                    br = new BufferedReader(new FileReader(subFile));
                    String contentLine ;
                    //如果一行过长，可以提前拆分成多行
                    while ((contentLine = br.readLine()) != null) {
                        contentLine = contentLine.toLowerCase();
                        // 读取每一行，并输出
//                        System.out.println(contentLine);
                        String[] lineWords = contentLine.split(" ");
                        for (String lineWord : lineWords) {
                            if(lineWord.endsWith(".")){
                                lineWord = lineWord.substring(0,lineWord.length()-1);
                            }
                            //存储word
                            if(!map.containsKey(lineWord)){
                                map.put(lineWord,new InfoPlus(1, fileIndex, filesAmount));
                            }else {
                                InfoPlus temp = map.get(lineWord);
                                //如果该单词不是第一次遇到
                                int tf = temp.tFreq.get(fileIndex-1) + 1;
                                temp.tFreq.set(fileIndex - 1, tf);
                                //是否在当前文档记录过该单词
                                if (!temp.list.contains(fileIndex)) {
                                    temp.freq++;
                                    temp.list.add(fileIndex);
                                }
                            }
                        }
                    }
                }
            }
            //遍历map,写入文件
            Set<String> keywords = map.keySet();
            for (String keyword : keywords) {
                StringBuilder str = new StringBuilder();
                str.append(keyword+" ");
                str.append(map.get(keyword).freq+" ");
                List<Integer> list = map.get(keyword).list;
                List<Integer> tFreq = map.get(keyword).tFreq;
                for (Integer position : list) {
                    str.append(position+" "+tFreq.get(position - 1)+" ");
                }
                System.out.println(str);
                bw.write(str.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void search(String[] strs){
        BufferedReader br = null;
        Map<String,InfoPlus> map = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader("document//indexFilePlus.txt"));
            String line;
            while ((line = br.readLine()) != null){
                String[] lineWords = line.split(" ");
                InfoPlus temp = new InfoPlus(3);
                temp.freq = Integer.parseInt(lineWords[1]);
                for (int i = 2; i < lineWords.length;) {
                    int fileIndex = Integer.parseInt(lineWords[i++]);
                    temp.list.add(fileIndex);
                    temp.tFreq.set(fileIndex - 1, Integer.parseInt(lineWords[i++]));
                }
                map.put(lineWords[0],temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        double[] w = new double[strs.length];
        List<Score> sList = new ArrayList<>(3);
        Score[] scores = new Score[3];
        for (int i = 1; i <= 3; i++) {
            scores[i-1] = new Score();
            for (int j = 0; j < strs.length; j++) {
                InfoPlus tempInfo = map.get(strs[j]);
                int tf = tempInfo.tFreq.get(i-1);
                int df = tempInfo.freq;
                w[j] = log(1 + tf, 10) + log((double)1 / df, 10);
//                System.out.println("w["+j+"] ="+ w[j]);
                scores[i-1].score += w[j] * tf;
            }
            sList.add(new Score("d"+i, scores[i-1].score));
        }
        Collections.sort(sList);
        for (Score score : sList) {
            System.out.println(score.fileName+":"+score.score);
        }

    }

    @Test
    public void test1(){

        creatInvertedIndex("document");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("please enter  words:");
            String str = sc.nextLine();
            str = str.toLowerCase();
            if (str.endsWith(".")) {
                str = str.substring(0, str.length() - 1);
            }
            String[] strs = str.split(" ");
            search(strs);
        }
    }
}
