
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
           i = 1;
           int prev_val = 0;
           while (prev_val != current.val) {
               if (i % k == 0) { //every kth element
                   current.next = current.next.next; //remove next in list (iteration starts at tail and loops)
               }
               i++; //increment index
               prev_val = current.val; //bookmark previous value
               current = current.next; //advance list worker
           }
           return prev_val;
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