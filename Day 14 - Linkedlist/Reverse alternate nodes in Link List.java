class Solution
{
    public static void rearrange(Node odd)
    {
        Node even=null;
        while( odd.next!=null){
            Node temp=odd.next.next;
            odd.next.next=even;
            even=odd.next;
            odd.next=temp;
            if(temp!=null){
                odd=temp;
            }
        }
        odd.next=even;
    }
}