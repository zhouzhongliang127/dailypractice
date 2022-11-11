package com.exerproject03;

import java.util.Scanner;
import java.util.Vector;

/**
 * @author zzl
 * @Description
 * @date 2021/9/30 - 16:21
 */
public class ScoreTest {
    public static void main(String[] args) {
        Vector v = new Vector();
        int max = 0;
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while(scanner.hasNext()){
            if(!scanner.hasNextInt()){
                scanner.next();
                continue;
            }

            int score = scanner.nextInt();
            if(score < 0) break;
            v.addElement(score);
            if(score > max) max = score;
        }
        for (int i = 0; i < v.size(); i++) {
            System.out.print(i+1+"号学生成绩为：");
            int score = (int) v.elementAt(i);
            if (max-score <=10) System.out.println("A");
            else if(max - score <= 20) System.out.println("B");
            else  if(max - score <= 30) System.out.println("C");
            else System.out.println("D");
        }
    }
}
