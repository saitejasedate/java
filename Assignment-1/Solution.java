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
        return str+temp.getData();
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        if (list1.size() < list2.size()) {
            LinkedList k = new LinkedList();
            k = list1;
            list1 = list2;
            list2 = k;
        }
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        LinkedList ll = new LinkedList();
        Node temp1 = list1.getHead();
        Node temp2 = list2.getHead();
        while (temp1 != null) {
            s1.push(temp1.getData());
            temp1 = temp1.getNext();
        }
        while (temp2 != null) {   
            s2.push(temp2.getData());
            temp2 = temp2.getNext();
        }
        int carry = 0;
        int sum = 0;
        while (!s2.isEmpty() && !s1.isEmpty()) {
            String str = "";
            sum = carry + s2.pop() + s1.pop();
            str+=sum;
            String[] arr = str.split("");
            if (str.length() == 2) {
                carry = Integer.parseInt(arr[0]);
                ll.pushLeft(Integer.parseInt(arr[1]));
            }
            else {
                ll.pushLeft(sum);
            }
        }
        while (!s1.isEmpty()) {
            sum += carry ;
            ll.pushLeft(sum);
        }

        if (carry!=0) {
            ll.pushLeft(carry);
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
