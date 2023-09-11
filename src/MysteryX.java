class MysteryX {
    DoubleNode front;
    DoubleNode back;
    public MysteryX() {

    }
    public void insertFront(int value) {
        if (front != null) { //list already exists
            front.next = new DoubleNode(value, false);
            front = front.next;
            back.previous = front;
        }
        else { //no current list
            front = new DoubleNode(value, true);
            back = front;
        }
    }

    public void insertRear(int value) {
        if (back != null) { //list already exists
            back.previous = new DoubleNode(value, false);
            back = back.previous;
            front.next = back;
        }
        else { //no current list
            back = new DoubleNode(value, true);
            front = back;
        }
    }
    public int deleteFront() {
        if (front == null) {
            return -1;
        }
        int temp;
        if (front.next == front) {
            temp = front.value;
            front = null;
            back = null;
        }
        else {
            temp = front.value;
            front.next.previous = front.previous;
            front.previous.next = front.next;
            front = front.previous;
        }
        return temp;
    }

    public int deleteRear() {
        if (back == null) {
            return -1;
        }
        int temp;
        if (back.previous == back) {
            temp = back.value;
            front = null;
            back = null;
        }
        else {
            temp = back.value;
            back.next.previous = back.previous;
            back.previous.next = back.next;
            back = back.previous;
        }
        return temp;
    }

    public int getFront() {
        if (front == null) {
            return -1;
        }
       return front.value;
    }

    public int getRear() {
        if (back == null) {
            return -1;
        }
       return back.value;
    }

    class DoubleNode {
        DoubleNode previous,next;
        int value;
        public DoubleNode(int val, boolean newStruct) {
            value = val;
            if (newStruct) {
                next = back;
                previous = front;
            }
            else {
                next = this;
                previous = this;
            }
        }
    }
}

