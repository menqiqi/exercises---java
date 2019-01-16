/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 :
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        //计算出链表的长度
        int len = 1;
        ListNode tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
            len++;
        }
        int loop = len - (k%len);
        //将这个单链表连成一个循环链表
        tmp.next = head;
        //隔断为单链表
        for(int i = 0; i < loop; i++){
            tmp = tmp.next;
        }
        ListNode node = tmp.next;
        tmp.next = null;
        return node;
    }
}


