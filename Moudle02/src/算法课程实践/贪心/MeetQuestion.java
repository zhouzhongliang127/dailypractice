package 算法课程实践.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zzl
 * @Description
 * @date 2022/9/11 - 10:35
 */
public class MeetQuestion {
    public class Program{

        int startTime;
        int endTime;

        public Program(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        public class ProgramComparator implements Comparator<Program>{

            @Override
            public int compare(Program o1, Program o2) {
                return o1.endTime - o2.endTime;
            }
        }

        public int bestArrange(Program[] programs, int timePoint){
            Arrays.sort(programs,new ProgramComparator());
            int count = 0;
            for(Program p : programs){
                if(p.startTime >= timePoint){
                    count++;
                    timePoint = p.endTime;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println('a' - 'b');

    }

}
