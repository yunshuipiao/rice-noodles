import model.ListNode
import model.toListNode
import org.testng.annotations.Test

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (k == 1) {
        return head
    }
    val newHead = ListNode(0)
    return newHead.next
}

fun reverse(head: ListNode?): ListNode? {
    val newHead = ListNode(0)
    var temp: ListNode? = head
    while (temp != null) {
        val node = temp
        temp = temp.next
        node.next = newHead.next
        newHead.next = node
    }
    return newHead.next
}

fun reverse2(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    val newHead = reverse2(head.next)
    head.next?.next = head
    head.next = null
    return newHead
}


@Test
fun _0025() {
    val node = arrayListOf(1).toListNode()
    reverseKGroup(node, 2)?.forEach()
}

