
import model.ListNode
import org.testng.annotations.Test

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var newHead = ListNode(0)
    var node: ListNode? = newHead
    var tl1 = l1
    var tl2 = l2
    while (tl1 != null && tl2 != null) {
        if (tl1.`val` < tl2.`val`) {
            node?.next = tl1
            tl1 = tl1.next
        } else {
            node?.next = tl2
            tl2 = tl2.next
        }
        node = node?.next
    }
    if (tl1 == null) {
        node?.next = tl2
    }
    if (tl2 == null) {
        node?.next = tl1
    }
    return newHead.next
}

// 递归解法
fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) {
        return l2
    }
    if (l2 == null) {
        return l1
    }
    if (l1.`val` < l2.`val`) {
        l1.next = mergeTwoLists2(l1.next, l2)
        return l1
    } else {
        l2.next = mergeTwoLists2(l1, l2.next)
        return l2
    }
}


@Test
fun _0021() {
    var head: ListNode? = ListNode(1)
    var tHead = head
    for (n in 2..5) {
        val node = ListNode(n)
        tHead?.next = node
        tHead = tHead?.next
    }
    var head2: ListNode? = ListNode(1)
//    tHead = head2
//    for (n in 2..5) {
//        val node = ListNode(n)
//        tHead?.next = node
//        tHead = tHead?.next
//    }
    mergeTwoLists2(head, head2)?.forEach()
}

