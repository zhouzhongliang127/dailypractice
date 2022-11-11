package 算法课程实践.链表;

/**
 * @author zzl
 * @Description
 * @date 2022/6/8 - 10:25
 */
public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //使用快慢指针找链表中点
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;//slow指针最后会指向中点或者两个中点节点前一个
        }


        //找到中点之后将后半段链表反转
        ListNode pre = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        //注意，当链表为偶数个节点的时候，后半段链表会比前半段多一个节点，不影响结果，只对比其他的就行

        //这时候pre指向后半段链表此时的头结点，对比两段链表(多出来的不用对比)
        while(head != null && pre != null){
            if(head.val != pre.val){
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
}
