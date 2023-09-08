public class XStack {
    StackNode top;
    public void push(int value)
    {
        if (top == null) {
            top = new StackNode(value);
        }
        else {
            StackNode temp = new StackNode(value);
            temp.previous = top;
            top = temp;
        }
    }
    public int pop()
    {
        if (top == null) {
            return -1;
        }
        else {
            int temp = top.value;
            top = top.previous;
            return temp;
        }
    }
    public int peek()
    {
        return -1;
    }

}

class StackNode {
    StackNode previous;
    int value;
    public StackNode(int val) {
        value = val;
        previous = null;
    }
}
