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


class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int flag = 0;  //表示进位的数
        while(a != null || b != null){
            int x = (a==null) ? 0 : a.val;
            int y = (b==null) ? 0 :b.val;
            int tmp = x+y+flag;
            cur.next = new ListNode(tmp%10);
            cur = cur.next;
            flag = tmp/10;
            if (a != null)
                a = a.next;
            if (b != null)
                b = b.next;
        }
        if (flag > 0){
            cur.next = new ListNode(flag);
        }
        return res.next;
    }
}

public class Practice206{
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.add(list1,2);
        list1.add(list1,3);
        ListNode list2 = new ListNode(3);
        list2.add(list2,2);
        list2.add(list2,1);
        Plus plus = new Plus();
        ListNode res = plus.plusAB(list1,list2);
        while (res != null){
            System.out.print(res.val+"->");
            res = res.next;
        }
    }
}