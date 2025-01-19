/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/
//Rotate a Linkedlist by left TC - O(2n) SC - O(1)
class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        if(head==null || head.next==null) return head;
        int len=1;
        Node tail=head;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        if(k%len==0) return head;
        k=k%len;
        tail.next=head;
        Node newTail=head;
        int count=1;
        while(count<k){
            newTail=newTail.next;
            count++;
        }
        Node newHead=newTail.next;
        newTail.next=null;
        return newHead;
    }
}