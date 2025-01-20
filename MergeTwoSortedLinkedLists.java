class Solution {
    // Brute force approach
    public Node mergeTwoListsBruteforce(Node head1, Node head2) {
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp1 = head1;
        Node temp2 = head2;
        
        while (temp1 != null) {
            arr.add(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            arr.add(temp2.data);
            temp2 = temp2.next;
        }
        
        Collections.sort(arr);
        
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        for (int val : arr) {
            temp.next = new Node(val);
            temp = temp.next;
        }
        
        return dummyNode.next;
    }

    // Optimal approach using merging
    public Node mergeTwoListsOptimal(Node head1, Node head2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        Node temp1 = head1;
        Node temp2 = head2;
        
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1 == null && temp2 != null) {
            temp.next = temp2;
        } else if (temp2 == null && temp1 != null) {
            temp.next = temp1;
        }

        return dummyNode.next;
    }
}
