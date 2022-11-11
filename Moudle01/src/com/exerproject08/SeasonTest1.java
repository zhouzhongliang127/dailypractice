package com.exerproject08;

/**
 * @author zzl
 * @Description
 * @date 2021/10/7 - 12:32
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 season1 = Season1.SPRING;
        System.out.println(season1);
    }
}
enum Season1{

    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","冰天雪地");


    private final String seasonName;
    private final String seasonDesc;

    private Season1(String seasonName,String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
