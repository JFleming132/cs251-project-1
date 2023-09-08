public class SumTwoNumbers {
    public class Node {
        int key;
        Node previous,next;
        public Node() {

        }
    }

    public Node num1_list;
    public Node num2_list;

    public Node add(String num1, String num2) {
        Node adder1;
        Node adder2;
        Node returnList;
        Node head = null;
        int currentDigit;
        int numIndex;
        for(numIndex = 0; numIndex < num1.length(); numIndex++) {
            currentDigit = Character.getNumericValue(num1.charAt(numIndex));
            if (numIndex == 0) {
                num1_list = new Node();
                head = num1_list;
                head.key = currentDigit;
                head.next = null;
                head.previous = null;
            }
            else {
                head.next = new Node();
                head.next.previous = head;
                head = head.next;
                head.key = currentDigit;
                head.next = null;
            }
        }
        for(numIndex = 0; numIndex < num2.length(); numIndex++) {
            currentDigit = Character.getNumericValue(num2.charAt(numIndex));
            if (numIndex == 0) {
                num2_list = new Node();
                head = num2_list;
                head.key = currentDigit;
                head.next = null;
                head.previous = null;
            }
            else {
                head.next = new Node();
                head.next.previous = head;
                head = head.next;
                head.key = currentDigit;
                head.next = null;
            }
        }
        adder1 = num1_list;
        adder2 = num2_list;
        while(adder1.next != null) {
            adder1 = adder1.next;
        }
        while(adder2.next != null) {
            adder2 = adder2.next;
        }
        returnList = new Node();
        returnList.key = 0;
        int adder1Digit, adder2Digit;
        currentDigit = 0;
        while(true) {
            if (adder1 != null) {
                adder1Digit = adder1.key;
                adder1 = adder1.previous;
            }
            else {
                adder1Digit = 0;
            }
            if (adder2 != null) {
                adder2Digit = adder2.key;
                adder2 = adder2.previous;
            }
            else {
                adder2Digit = 0;
            }
            currentDigit = adder1Digit + adder2Digit + currentDigit;
            returnList.key = currentDigit % 10;
            currentDigit = currentDigit / 10;
            if ((currentDigit == 0) && (adder1 == null) && (adder2 == null)) {
                break;
            }
            returnList.previous = new Node();
            returnList.previous.next = returnList;
            returnList = returnList.previous;
        }
        Node unlinker = returnList;
        while(unlinker != null) {
            if (unlinker.previous != null) {
                unlinker.previous = null;
            }
            unlinker = unlinker.next;
        }
        return returnList;
    }
}
