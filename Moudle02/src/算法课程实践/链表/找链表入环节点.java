package 算法课程实践.链表;

/**
 * @author zzl
 * @Description
 * @date 2022/6/22 - 16:23
 */
public class 找链表入环节点 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while(slow != fast){
            if(fast == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        fast = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
