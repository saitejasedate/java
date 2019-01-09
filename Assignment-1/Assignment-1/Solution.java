import java.util.Scanner;
class AddLargeNumbers {
    
    public static LinkedList numberToDigits(String number) {
        LinkedList ll = new LinkedList();
        String[] str = number.split("");
    	for (int i = 0; i < str.length; i++) {
            ll.pushRight(Integer.parseInt(str[i]));
        }
        return ll;
    }

    public static String digitsToNumber(LinkedList list) {
        String str = "";
        Node temp = list.getHead();
        while (temp.getNext() != null) {
            str += temp.getData();
            temp = temp.getNext();
        }
        // System.out.println(str);
        return str+temp.getData();
        // return null;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        // System.out.println(list1);
        // System.out.println(list2);
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        LinkedList ll = new LinkedList();
        Node temp1 = list1.getHead();
        Node temp2 = list2.getHead();
        while (temp1 != null && temp2 != null) {
            s1.push(temp1.getData());
            s2.push(temp2.getData());
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }
        while (!s1.isEmpty() && !s2.isEmpty()) {
            String sum = "";
            int carry = 0;
            sum += carry + s1.pop() + s2.pop();
            System.out.println(s1.pop());
            if (sum.length() == 2) {
                String[] str = sum.split("");
                carry = Integer.parseInt(str[0]);
            }
        }
        return ll;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
