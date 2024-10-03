package com.priyanshi.LinkedList;

public class InterviewQuestions {

    // Cycle questions
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) { // fast.next != null means that fast itself should not be at the last index
            fast = fast.next.next; // move ahead by 2
            slow = slow.next; // move ahead by 1
            if (fast == slow) {
                return true; // cycle is present
            }
        }

        return false; // cycle is not present
    }

    // find length of the cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) { // fast.next != null means that fast itself should not be at the last index
            fast = fast.next.next; // move ahead by 2
            slow = slow.next; // move ahead by 1
            if (fast == slow) {
                // calculate the length if cycle is present
                ListNode temp = slow;
                int length = 0;

                do {
                    temp = temp.next;
                    length +=1;
                } while (temp != slow);

                return length;
            }
        }

        return 0; // cycle is not present
    }

    public ListNode detectCycle(ListNode head) {
        int length = 0;

        // find the cycle
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) { // fast.next != null means that fast itself should not be at the last index
            fast = fast.next.next; // move ahead by 2
            slow = slow.next; // move ahead by 1
            if (fast == slow) {
                length = lengthCycle(slow); // cycle is present
                break;
            }
        }

        if (length == 0) { // no cycle is present
            return null;
        }

        // now, you have a cycle and you need to find the start node
        ListNode f = head; // first ptr
        ListNode s = head; // second ptr

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both f and s forward and they will meet at the cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }

        return s;
    }

    // Happy Number
    // https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        // if the number is not a happy number, the loop will keep on running, how to stop it?
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow); // move 1 step ahead
            fast = findSquare(findSquare(fast)); // move 2 steps ahead
        } while (slow != fast);

        if (slow == 1) {
            return true; // happy number
        }
        return false;
    }

    private int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10; // last digit
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }

    // Middle of LL
    // https://leetcode.com/problems/middle-of-the-linked-list/description/
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s; // while the fast pointer reaches the end, slow pointer is reaches the middle
    }

    // https://leetcode.com/problems/reverse-linked-list/submissions/
    // Google, Apple, Amazon, Microsoft
    public ListNode reverseList(ListNode head) {

        // Check if the list is empty or has only one element
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers for previous, current, and next nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = curr.next;

        // Traverse the list and reverse pointers
        while (curr != null) {
            curr.next = prev; // Reverse the pointer of the current node to point to the previous node
            prev = curr; // Move the pointer
            curr = nextNode; // Move the pointer
            if (nextNode != null) {
                nextNode = nextNode.next; // Move the pointer
            }
        }
        // Now, the 'curr' node is pointing to 'null'
        // and 'prev' is pointing to the new first node (which was the last node of the original list)
        return prev;
    }

    // Google, Microsoft, Facebook
    // https://leetcode.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode curr = head;
        ListNode prev = null;

        for(int i = 0; curr != null && i < left - 1; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode last = prev;
        ListNode newEnd = curr;

        // reverse between left and right
        ListNode nextNode = curr.next;
        for (int i = 0; curr != null && i < right - left + 1; i++) { // no. of elements in sub list = right - left + 1
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            nextNode = nextNode.next;
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = curr;
        return head;
    }

    // Palindrome LL
    // Google, Microsoft, FB, LinkedIn, Amazon, Apple
    // https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode rereverseHead = headSecond;

        // Compare the first and second half
        while (head != null && headSecond != null) {
            if (head.val == headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);

        if (head == null || headSecond == null) {
            return true;
        }
        return false;
    }
}

 class ListNode {
     int val;
     ListNode next;

     public ListNode() {

     }

     ListNode(int x) {
         val = x;
         next = null;
     }
 }
