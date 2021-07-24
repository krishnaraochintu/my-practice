package com.krishna.app.linkedList;

public class MergeSortedLinkedList {

    public ListNode mergeTwoListsWithDummyNode(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0); /* a dummy first node to hang the result on */
        ListNode tail = dummyNode; //tail points to the last result node
        while(true) {
            if(l1 == null) {
                tail.next = l2;
                break;
            }
            if(l2 == null) {
                tail.next = l1;
                break;
            }
            if(l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        return dummyNode.next;
    }

    public ListNode mergeTwoListsWithRecursive(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoListsWithRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsWithRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        MyLinkedList listOne = new MyLinkedList();
        MyLinkedList listTwo = new MyLinkedList();
        listOne.addToLast(new ListNode(5));
        listOne.addToLast(new ListNode(10));
        listOne.addToLast(new ListNode(15));

        listTwo.addToLast(new ListNode(2));
        listTwo.addToLast(new ListNode(3));
        listTwo.addToLast(new ListNode(20));

        MergeSortedLinkedList mergeSortedLinkedList = new MergeSortedLinkedList();
        mergeSortedLinkedList.mergeTwoListsWithRecursive(listOne.head, listTwo.head);
    }
}
