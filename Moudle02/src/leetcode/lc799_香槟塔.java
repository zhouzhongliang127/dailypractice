package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc799_香槟塔 {

    public static double champagneTower(int poured, int query_row, int query_glass) {

        double[] row = new double[]{ poured };
        for (double v : row) {
            System.out.print(v + "\t");
        }
        System.out.println();

        for(int i = 1; i <= query_row; i++){

            double[] nextRow = new double[i + 1];

            // 通过上方杯子的酒的体积计算下方的体积，因为上方只有0 ~ i - 1号酒杯，所以这里j < i
            // 虽然本层的杯子是0 ~ i，但是上方每一个酒杯如果溢出都会溢出到下标对应的酒杯和下标加一的酒杯
            for(int j = 0; j < i; j++){

                double volume = row[j];

                if(volume > 1){
                    nextRow[j] += (volume - 1) / 2;
                    nextRow[j + 1] += (volume - 1) / 2;
                }
            }
            row = nextRow;
            for (double v : row) {
                System.out.print(v + "\t");
            }
            System.out.println();
        }

        return row[query_glass] < 1 ? row[query_glass] : 1;
    }

    public static void main(String[] args) {
        System.out.println(champagneTower(25, 6, 1));
        List<Integer> row = new ArrayList<>();
    }
}
