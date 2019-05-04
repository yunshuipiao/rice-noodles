import model.ListNode

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