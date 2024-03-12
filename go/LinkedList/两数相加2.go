package LinkedList

/**
 * Definition for singly-linked list.
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	head := &ListNode{Val: 0}
	num1, num2 := 0, 0
	carry := 0
	// define work Point
	current := head
	for l1 != nil || l2 != nil || carry != 0 {
		// l1 or l2 maybe nil
		if l1 == nil {
			num1 = 0
		} else {
			num1 = l1.Val
			l1 = l1.Next
		}
		if l2 == nil {
			num2 = 0
		} else {
			num2 = l2.Val
			l2 = l2.Next
		}
		l := &ListNode{(num1 + num2 + carry) % 10, nil}
		carry = (num1 + num2 + carry) / 10

		// post insert
		current.Next = l
		current = l
	}
	return head.Next
}
