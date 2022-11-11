package 算法课程实践.链表;

import java.util.HashMap;

/**
 * @author zzl
 * @Description
 * @date 2022/6/22 - 15:01
 */
public class 复制带随机指针的链表 {

    public Node copyRandomList1(Node head) {
        Node p = head;
        HashMap<Node,Node> map = new HashMap<>();
        while(p != null){
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while(p != null){
            Node curSubNode = map.get(p);
            curSubNode.next = map.get(p.next);
            curSubNode.random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        //构建1 -> 1` -> 2 -> 2`
        while(cur != null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        //构建完成。开始赋值copyNode的random指针
        cur = head;
        Node copyNode = null;
        while(cur != null){
            copyNode = cur.next;
            copyNode.random = cur.random == null ? null : cur.random.next;
            cur = copyNode.next;
        }
        //分离两个链表
        cur = head;
        copyNode = cur.next;
        Node copyHead = copyNode;
        while(cur != null){
            cur.next = cur.next.next;
            copyNode.next = copyNode.next == null ? null : copyNode.next.next;
            cur = cur.next;
            copyNode = copyNode.next;
        }
        return copyHead;
    }

}
