package 算法课程实践.链表;

/**
 * @author zzl
 * @Description
 * @date 2022/6/8 - 10:21
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while(p != null){
            //当前节点改变next指向时先保存p.next
            ListNode next = p.next;
            //然后将当前节点的next改为它的前一个元素
            p.next = pre;
            //指针后移
            pre = p;
            p = next;
        }
        return pre;
    }
}
