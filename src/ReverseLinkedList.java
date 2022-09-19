public class ReverseLinkedList {
    static class ListNode{
        char val;
        ListNode next;

        ListNode(char value){
            val = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode('A');
        ListNode b = new ListNode('B');
        ListNode c = new ListNode('C');
        ListNode d = new ListNode('D');

        a.next = b;
        b.next = c;
        c.next = d;

        //A -> B -> C -> D -> NULL

        //N -> A -> B -> C -> D -> NULL
        //P    C    N

        ListNode current = a;
        ListNode previous = null;

        while(current != null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        while(previous != null){
            System.out.print(previous.val+(previous.next != null ? " " : ""));
            previous = previous.next;
        }
    }
}
