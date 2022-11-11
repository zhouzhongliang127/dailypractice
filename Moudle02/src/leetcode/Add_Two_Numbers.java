package leetcode;

/**
 * @author zzl
 * @Description
 * @date 2021/10/16 - 10:51
 */


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //声明工作指针，最好不要动原指针，方便定位
        ListNode p=l1,q=l2;
        ListNode l3 = new ListNode();
        ListNode s = l3;
        int flag = 0;//0 表示无进位
        int newVal = 0;
        while(l1 != null&&l2!= null){
            //计算该节点的值
            newVal = l1.val+l2.val+l3.val;
            //判断是否有进位
            if(newVal>=10){
                newVal = newVal - 10;
                flag=1;
            }
            //当原链表有后续或者加法有进位时l3创建新节点，并将初值赋值为进位值
            if(l1.next != null|| l2.next!=null||flag==1)
                l3.next = new ListNode(flag);
            //进位已确定，重置
            flag =0;
            l3.val = newVal;
            //处理完一个节点，后移
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        //处理不同长度的部分，同样的思路，别忘了处理进位
        while(l1 != null){
            newVal = l1.val+l3.val;
            if(newVal>=10){
                newVal = newVal - 10;
                flag=1;
            }
            l3.val = newVal;
            if(l1.next != null||flag==1)
                l3.next = new ListNode(flag);
            flag = 0;
            l1 =l1.next;
            l3 = l3.next;
        }
        while(l2!=null){
            newVal= l2.val+l3.val;
            if(newVal>=10){
                newVal = newVal - 10;
                flag=1;
            }
            l3.val = newVal;
            if(l2.next!=null||flag==1)
                l3.next = new ListNode(flag);
            flag = 0;
            l2 = l2.next;
            l3 = l3.next;
        }
        //原来的l3作为了工作指针，如果返回它的话会为空
        //所以用一个其他的变量将结果链表保存用于返回结果
        return s;
    }
    public String convert(String s, int numRows) {
        int n = s.length();
        int cols = 2*n/(2*numRows-2);
        if((n%(2*numRows-2))!=0) cols++;
        char[][] chars = new char[numRows][cols];
        int index=0;
        int row = 0,col = 0;
        while(index < n){
            for(int i =0;i<numRows-1;i++){
                while(col<numRows&&index < n){
                    chars[row++][col]=s.charAt(index++);
                }
                row--;
                while(row>1&&index < n){
                    chars[--row][++col] = s.charAt(index++);
                }
                col++;
            }
        }
        StringBuilder s1 = new StringBuilder();
        for(int i =0;i < numRows;i++){
            for(int j=0;j<cols;j++){
                if(chars[i][j]!=' ')
                    s1.append(chars[i][j]);
            }
        }
        return s1.toString();
    }
    }

public class Add_Two_Numbers {
//[9,9,9,9,9,9,9]
//[9,9,9,9]
    public static void main(String[] args) {
        int[] n1 = {9,9,9,9,9,9,9};
        int[] n2 = {9,9,9,9};
        ListNode p = new ListNode();
        ListNode q = new ListNode();
        ListNode l1=p,l2=q;
        for (int i = 0; i < n1.length; i++) {
            l1.val = n1[i];
            if(i<n1.length-1)
                l1.next = new ListNode();
            l1 = l1.next;
        }
        for (int i = 0; i < n2.length; i++) {
            l2.val = n2[i];
            if(i<n2.length-1)
                l2.next = new ListNode();
            l2 = l2.next;
        }
        Solution v= new Solution();
        ListNode l3 = v.addTwoNumbers(p,q);
        while ( l3!= null){
            System.out.print(l3.val+" ");
            l3 = l3.next;
        }

    }

}
