class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        Node prev=null;
        Node curr=head;
        Node temp;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}