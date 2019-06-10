
import model.ListNode
import model.toListNode
import org.testng.annotations.Test

/**
 *
 */
fun swapPairs(head: ListNode?): ListNode? {
    val newHead = ListNode(0)
    newHead.next = head
    var temp: ListNode? = newHead
    while (temp?.next != null && temp.next?.next != null) {
        val node1 = temp.next
        temp.next = temp.next?.next
        node1?.next = temp.next?.next
        temp.next?.next = node1

        temp = temp.next?.next
    }
    return newHead.next
}

/**
 * 递归方法
 */
fun swapPairs2(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    val temp = head.next
    head.next = swapPairs2(head.next?.next) // important
    temp?.next = head
    return temp
}



@Test
fun _0024() {
    val node = arrayListOf(1, 2, 3, 4).toListNode()
    swapPairs2(node)?.forEach()
}

