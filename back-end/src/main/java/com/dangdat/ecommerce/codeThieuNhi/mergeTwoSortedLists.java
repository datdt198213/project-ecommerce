package com.dangdat.ecommerce.codeThieuNhi;

import lombok.val;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class mergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();

        while(list1.next != null && list2.next != null) {
            if(list1.val == list2.val) {
                result.next = list1;
                result.next = list2;
            } else if (list1.val < list2.val) {
                result.next = list2;
            } else {
                result.next = list1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode list1_1 = new ListNode(1);
        ListNode list1_2 = new ListNode(2);
        ListNode list1_3 = new ListNode(3);

        ListNode list2_1 = new ListNode(1);
        ListNode list2_2 = new ListNode(3);
        ListNode list2_3 = new ListNode(4);

        list2_1.next = list2_2;
        list2_2.next = list2_3;

        list1_1.next = list1_2;
        list1_2.next = list1_3;

        ListNode result = mergeTwoLists(list1_1, list2_2);

    }
}
