/**
 *
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 *
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */

import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        //将原链表分为两个集合
        //小于x的集合和大于等于x的集合
        ArrayList<Integer> l1=new ArrayList<>();  //动态整型数组
        ArrayList<Integer> l2=new ArrayList<>();
        ListNode cur=pHead;
        while(cur!=null)
        {
            if(cur.val<x)
                l1.add(cur.val);  //小的元素方l1集合
            else
                l2.add(cur.val);  //大的元素方l2集合
            cur=cur.next;
        }
        l1.addAll(l2);//把集合l2的元素添加在集合l1后面
        //将链表中数据按照集合l1顺序进行替换
        pHead.val=l1.get(0);
        cur=pHead.next;
        for(int i=1;i<l1.size();i++)
        {
            cur.val=l1.get(i);
            cur=cur.next;
        }
        return pHead;
    }
}

