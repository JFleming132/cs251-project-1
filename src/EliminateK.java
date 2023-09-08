
public class EliminateK {

    public int computeSurvivor(int n,int k)
    {
       if (n > 0) {
           int i;
           IntListNode head = new IntListNode(1);
           IntListNode current = head;
           for (i = 2; i <= n; i++) {
               current.next = new IntListNode(i);
               current = current.next;
           }
           current.next = head;

           while (current.next != current) {
               for (i = 1; i < k; i++) {
                   current = current.next;
               }
               current.next = current.next.next;
           }
           return current.val;
       }
       else {
           return 0;
       }
    }
}

class IntListNode {
    int val;
    IntListNode next;

    public IntListNode(int v) {
        val = v;
    }
}