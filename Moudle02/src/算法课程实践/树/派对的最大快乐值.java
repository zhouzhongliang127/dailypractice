package 算法课程实践.树;

import java.util.ArrayList;
import java.util.List;

public class 派对的最大快乐值 {

    public static class Employee{
        public int happy;//当前员工可以带来的快乐值
        List<Employee> subordinates;//其直系子员工

        public Employee(int happy) {
            this.happy = happy;
            subordinates = new ArrayList<>();
        }
    }

    public static class Info{
        int presenceMaxHappy;
        int absenceMaxHappy;
        public Info(int presenceMaxHappy, int absenceMaxHappy){
            this.presenceMaxHappy = presenceMaxHappy;
            this.absenceMaxHappy = absenceMaxHappy;
        }
    }

    public static int getMaxHappy(Employee boss){
        if(boss == null){
            return 0;
        }
        Info res = process(boss);
        return Math.max(res.presenceMaxHappy, res.absenceMaxHappy);
    }

    //核心是根据孩子的信息确定自己的信息
    //当前子树的最大快乐值分为两个，分别是当前员工参加的最大快乐值和当前员工不参加的最大快乐值
    public static Info process(Employee e){
        if(e.subordinates.isEmpty()){
            return new Info(e.happy, 0);
        }
        int presence = e.happy;
        int absence = 0;
        for (Employee subordinate : e.subordinates) {
            Info info = process(subordinate);
            presence += info.absenceMaxHappy;
            absence += Math.max(info.presenceMaxHappy, info.absenceMaxHappy);
        }
        return new Info(presence, absence);
    }

    public static void main(String[] args) {
        Employee head1 = new Employee(1);

        Employee head2 = new Employee(10);
        Employee head3 = new Employee(10);
        Employee head4 = new Employee(10);

        Employee head5 = new Employee(1);
        Employee head6 = new Employee(1);
        Employee head7 = new Employee(1);
        Employee head8 = new Employee(1);
        Employee head9 = new Employee(1);
        Employee head10 = new Employee(1);

        head1.subordinates.add(head2);
        head1.subordinates.add(head3);
        head1.subordinates.add(head4);

        head2.subordinates.add(head5);
        head2.subordinates.add(head6);
        head3.subordinates.add(head7);
        head3.subordinates.add(head8);
        head4.subordinates.add(head9);
        head4.subordinates.add(head10);

        System.out.println(getMaxHappy(head1));
    }



}
