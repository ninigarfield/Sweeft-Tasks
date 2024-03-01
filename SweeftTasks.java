import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}

public class Main
{
    public static int evaluateExpression(String expression) {
        int result = 0, num = 0;
        char op = '+';

        for (int i = 0; i < expression.length(); i++)
        {
            if (Character.isDigit(expression.charAt(i)))
                num = num * 10 + (expression.charAt(i) - '0');

            if (!Character.isDigit(expression.charAt(i)) || i == expression.length() - 1)
            {
                if (op == '+')
                    result += num;
                else
                    result -= num;

                op = expression.charAt(i);
                num = 0;
            }
        }

        return result;
    }

    public static int numOfHappyStrings(List<String> strings) {
        int count = 0;

        for (String s : strings)
        {
            for (int i = 1; i < s.length(); i++)
            {
                if (s.charAt(i - 1) == s.charAt(i))
                {
                    count++;
                    break;
                }
            }
        }

        return strings.size() - count;
    }
    
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? "->" : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static int[] findIntersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1)
            set1.add(num);

        for (int num : nums2)
            if (set1.contains(num))
                set2.add(num);

        int[] result = new int[set2.size()];
        int i = 0;
        for (int num : set2)
            result[i++] = num;

        return result;
    }

    public static boolean isValidSequence(int[] array, int[] sequence) {
        int a = 0, s = 0;

        while (a < array.length && s < sequence.length)
        {
            if (sequence[s] == array[a])
                s++;
            a++;
        }

        return s == sequence.length;
    }

    public static void main(String[] args) {
        String expression = "5+20-8+5";

        int result1 = evaluateExpression(expression);
        System.out.println("Result of the expression: " + result1);



        List<String> stringList = List.of("abbcc", "abc", "abcabc", "cabcbb");

        int result2 = numOfHappyStrings(stringList);
        System.out.println("Number of happy strings: " + result2);



        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Head: ");
        printList(head);

        ListNode reverse = reverseList(head);

        System.out.print("Result: ");
        printList(reverse);



        int[] nums1 = {1, 2, 3, 3, 4, 5};
        int[] nums2 = {3, 4, 4, 5, 6, 7};

        int[] result4 = findIntersection(nums1, nums2);

        System.out.print("Result: [ ");
        for (int i = 0; i < result4.length; i++) {
            System.out.print(result4[i] + " ");
        }
        System.out.println("]");



        int[] array = { 5, 1, 22, 25, 6, -1, 8, 10 };
        int[] sequence = { 1, 6, -1, 10 };

        boolean result6 = isValidSequence(array, sequence);
        System.out.println("Is valid sequence: " + result6);
    }
}