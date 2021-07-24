package com.krishna.app.linkedList;

public class MyLinkedList {
    ListNode head;

    public void addToLast(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) temp = temp.next;
                temp.next = node;
        }
    }
    void printList()
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
