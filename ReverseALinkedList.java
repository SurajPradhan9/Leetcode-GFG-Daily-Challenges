class Solution {
    Node reverseList(Node head) {
        // code here
        
        //optimal (Recursive) TC - O(n) SC - O(1) (Recursive stack space O(n))
        if(head==null || head.next==null){
            return head;
        }
        Node newHead=reverseList(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
        
        // //Optimal (Itterative) TC - O(n) SC - O(1)
        // Node prev=null;
        // Node temp=head;
        // while(temp!=null){
        //     Node front=temp.next;
        //     temp.next=prev;
        //     prev=temp;
        //     temp=front;
        // }
        // return prev;
        
        // //Bruteforce TC - O(2n) SC - O(n)
        // Stack<Integer> st=new Stack<>();
        // Node temp=head;
        // while(temp!=null){
        //     st.push(temp.data);
        //     temp=temp.next;
        // }
        // temp=head;
        // while(temp!=null){
        //     temp.data=st.pop();
        //     temp=temp.next;
        // }
        // return head;
    }
}