import model.ListNode
import org.testng.annotations.Test

/**
 * 哨兵的作用
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var head: ListNode = ListNode(-1)
    var tNode: ListNode? = head
    var sum = 0

    var tl1 = l1
    var tl2 = l2
    while (tl1 != null || tl2 != null) {
        sum /= 10
        tl1?.let {
            sum += it.`val`
            tl1 = it.next
        }
        tl2?.let {
            sum += it.`val`
            tl2 = it.next
        }
        tNode?.next = ListNode(sum % 10)
        tNode = tNode?.next
    }
    if (sum >= 10) {
        tNode?.next = ListNode(1)
    }
    return head.next
}

@Test
fun _0002() {
    val l1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }
    val l2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }
    val result = addTwoNumbers(l1,l2)
    result?.forEach()
}
