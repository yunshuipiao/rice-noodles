
import model.ListNode
import org.testng.annotations.Test

/**
 * 借助一个新的头结点，来省去判断当删除的结点为头结点的情况
 *
 * 找到要删除结点的前一个结点
 */
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val newHead: ListNode? = ListNode(0)
    var first = newHead
    var second = newHead
    newHead?.next = head
    for (index in 0..n) {
        first = first?.next
    }
    while (first != null) {
        first = first.next
        second = second?.next
    }
    second?.next = second?.next?.next
    return newHead?.next
}

@Test
fun _0019() {
    var head: ListNode? = ListNode(1)
    var tHead = head
    for (n in 2..5) {
        val node = ListNode(n)
        tHead?.next = node
        tHead = tHead?.next
    }
    arrayListOf(head).forEach {
        removeNthFromEnd(head, 2)?.forEach()
    }
}

