package 算法课程实践.链表;

/**
 * @author zzl
 * @Description
 * @date 2022/6/8 - 10:24
 */
public class 找链表公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
