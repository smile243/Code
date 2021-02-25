package com.company;

/**
 * 链表表示两数和
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int push=0;
        //头指针
        ListNode pre = new ListNode(0);
        //当前操作指针
        ListNode cur = pre;
        while(null!=l1||null!=l2){
           int x=l1==null?0:l1.val;
           int y=l2==null?0:l2.val;
           int sum=x+y+push;
           push=sum/10;
           sum=sum%10;
           cur.next=new ListNode(sum);
           cur=cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        //最后正好多出一位的情况
        if(push == 1) {
            cur.next = new ListNode(push);
        }
        return pre.next;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        ListNode l1=new ListNode();
        l1=new ListNode(3,l1);
        l1=new ListNode(4,l1);
        l1=new ListNode(5,l1);
        l1=new ListNode(3,l1);
        l1=new ListNode(4,l1);
        ListNode l2=new ListNode();
        l2=new ListNode(1,l2);
        l2=new ListNode(2,l2);
        l2=new ListNode(3,l2);
        ListNode result=s.addTwoNumbers(l1,l2);
        StringBuilder sb=new StringBuilder();
        while (null!=result.next){
            sb.append(result.val);
            result=result.next;
        }
        System.out.println(sb.toString());
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
