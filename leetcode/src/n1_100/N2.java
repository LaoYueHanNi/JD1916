package n1_100;

/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807*/
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class N2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode head = new ListNode(0);// 定义头节点
		ListNode result = head;// 定义结果
		int x = 0;// 传递l1的值
		int y = 0;// 传递l2的值
		int num = 0;// 和
		int carry = 0;// 进位

		while (l1 != null || l2 != null) {
			// l1和l2有一个不为null就进入循环
			x = (l1 != null) ? l1.val : 0;
			y = (l2 != null) ? l2.val : 0;
			num = x + y + carry;
			carry = num / 10;
			result.next = new ListNode(num % 10);
			result = result.next;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry > 0) {
			result.next = new ListNode(carry);
		}
		return head.next;
	}
}
