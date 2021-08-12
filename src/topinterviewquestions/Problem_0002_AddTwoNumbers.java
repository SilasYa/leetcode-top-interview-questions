package topinterviewquestions;

public class Problem_0002_AddTwoNumbers {

	// 不要提交这个类描述
	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int value) {
			this.val = value;
		}
	}

	public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		int ca = 0;
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		ListNode c1 = head1;
		ListNode c2 = head2;
		ListNode node = null;
		ListNode pre = null;
		while (c1 != null || c2 != null) {
			n1 = c1 != null ? c1.val : 0;
			n2 = c2 != null ? c2.val : 0;
			n = n1 + n2 + ca;
			pre = node;
			node = new ListNode(n % 10);
			node.next = pre;
			ca = n / 10;
			c1 = c1 != null ? c1.next : null;
			c2 = c2 != null ? c2.next : null;
		}
		if (ca == 1) {
			pre = node;
			node = new ListNode(1);
			node.next = pre;
		}
		return reverseList(node);
	}

	public static ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}


	// 上面的有点复杂
	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode head = null, tail = null;
			int carry = 0;
			while (l1 != null || l2 != null) {
				int n1 = l1 != null ? l1.val : 0;
				int n2 = l2 != null ? l2.val : 0;
				int sum = n1 + n2 + carry;
				if (head == null) {
					head = tail = new ListNode(sum % 10);
				} else {
					tail.next = new ListNode(sum % 10);
					tail = tail.next;
				}
				carry = sum / 10;
				if (l1 != null) {
					l1 = l1.next;
				}
				if (l2 != null) {
					l2 = l2.next;
				}
			}
			if (carry > 0) {
				tail.next = new ListNode(carry);
			}
			return head;
		}
	}

//	作者：LeetCode-Solution
//	链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode-solution/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。.

}
