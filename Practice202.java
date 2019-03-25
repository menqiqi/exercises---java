class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    void add(ListNode node, int key){
        ListNode newNode = new ListNode(key);
        if (node == null){
            node = newNode;
            return;
        }
        ListNode cur = node;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
    }
}

class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead == null || pHead.next == null)
        {
            return pHead;
        }
        ListNode cur = pHead;
        ListNode Shead = new ListNode(-1);
        ListNode Bhead = new ListNode(-1);
        ListNode Stmp = Shead;
        ListNode Btmp = Bhead;
        while(cur != null){
            if(cur.val < x){
                Stmp.next = new ListNode(cur.val);
                Stmp = Stmp.next;
            }else{
                Btmp.next = new ListNode(cur.val);
                Btmp = Btmp.next;
            }
            cur = cur.next;
        }
        cur = Shead;
        while(cur.next != null && cur.next.val != -1){
            cur = cur.next;
        }
        cur.next = Bhead.next;
        return Shead.next;
    }
}


public class Practice202 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.add(listNode,5);
        listNode.add(listNode,6);
        listNode.add(listNode,1);
        listNode.add(listNode,10);
        listNode.add(listNode,32);
        listNode.add(listNode,4);
        print(listNode);
        System.out.println();

        Partition partition = new Partition();
        ListNode res = partition.partition(listNode,6);
        print(res);
    }

    private static void print(ListNode node){
        while (node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
    }
}
