package practice;

/**
 * @author zzl
 * @date 2021/9/26 - 18:11
 */
 class Student{
     int number;
     int state;
     int score;

/**
 * 功能描述: <br>
 * <遍历传入的Student数组的值>
 * @param stu Student类型的数组
 * @Return: void
 * @Author: zzl
 * @Date: 2021/9/26 20:13
 */
       public void print(Student[] stu){
         for (Student student : stu) {
             System.out.println("学号 = "+student.number +" score:"+ student.score+" state: "+student.state );
         }
     }
}

public class StudentTset {
    public static void main(String[] args) {
        //声明了一个Student类型的数组，但数组中的每一个stu[i]尚未实例化，即未分配空间
        Student[] stu = new Student[20];
        for (int i = 0; i < 20; i++) {
            stu[i] = new Student();//实例化
            stu[i].number = i+1;
            stu[i].state = (int) ((Math.random()*10)%4+1);
            stu[i].score =  (int) ((Math.random()*101));

        }

        Student temp;
        for (int i = 0; i < stu.length-1; i++) {
            for (int j = 1; j < stu.length-i; j++) {
                if(stu[j].score > stu[j-1].score)
                {
                    temp = stu[j];
                    stu[j] = stu[j-1];
                    stu[j-1] = temp;
                }
            }
        }
        stu[0].print(stu);
    }
}

