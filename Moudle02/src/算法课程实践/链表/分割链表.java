package 算法课程实践.链表;

/**
 * @author zzl
 * @Description
 * @date 2022/6/8 - 11:28
 */
public class 分割链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode mH = null;
        ListNode mT = null;
        ListNode next = null;

        while(head != null){
            //可以直接用head，但是要记得抹除每一段的尾巴的next，下面这样子可以避免这种操作并且便于理解
            //可以理解为一个个摘下原有的节点
            next = head.next;
            head.next = null;
            if(head.val < x){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }
            }else
                if(head.val == x){
                    if(eH == null){
                        eH = head;
                        eT = head;
                    }else{
                        eT.next = head;
                        eT = head;
                    }
            } else {
                if(mH == null){
                    mH = head;
                    mT = head;
                }else{
                    mT.next = head;
                    mT = head;
                }
            }
            head = head.next;
        }
        //决定谁的尾巴去和大于区间连
        if(sT != null){
            sT.next = eH;
            // 小于区间有的话再看看有没有等于区间。
            // 没有等于区间的话就用小于区间的尾巴作为小于等于区间的尾巴
            eT = eT == null ? sT : eT;
        }
        //有小于等于区间的话连接上大于等于区间
        if(eT != null){
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }
}
