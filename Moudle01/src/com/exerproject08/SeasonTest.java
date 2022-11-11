package com.exerproject08;

/**
 * @author zzl
 * @Description
 * @date 2021/10/7 - 12:18
 */
public class SeasonTest {
    public static void main(String[] args) {
        Season season = Season.WINTER;
        System.out.println(season);

    }
}

class Season{
    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName,String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final  Season SPRING = new Season("春天","春暖花开");
    public static final  Season SUMMER = new Season("夏天","夏日炎炎");
    public static final  Season AUTUMN = new Season("秋天","秋高气爽");
    public static final  Season WINTER = new Season("冬天","冰天雪地");

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
