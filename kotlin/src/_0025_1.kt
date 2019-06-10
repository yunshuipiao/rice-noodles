import model.ListNode
import model.toListNode
import org.testng.annotations.Test

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    var curr = head
    var tHead = head
    var count = 0
    while (curr != null && count != k) {
        curr = curr.next
        count += 1
    }
    if (count == k) {
        curr = reverseKGroup(curr, k)
        while (count > 0) {
            val tmp = tHead?.next
            tHead?.next = curr
            curr = tHead
            tHead = tmp
            count -= 1
        }
        tHead = curr
    }
    return tHead
}

fun reverseKGroup2(head: ListNode?, k: Int): ListNode? {
    val dummy: ListNode? = ListNode(0)
    dummy?.next = head

    var tHead = head
    var prev = dummy
    var tail = dummy
    var cur: ListNode?= null
    var n = 0
    while (true) {
        n = k
        while (n > 0 && tail != null) {
            tail = tail.next
            n -= 1
        }
        if (tail == null) {
            break
        }
        tHead = prev?.next
        while (prev?.next != tail) {
            cur = prev?.next
            prev?.next = cur?.next
            cur?.next =  tail.next
            tail.next = cur
        }
        tail = tHead
        prev = tHead
    }
    return dummy?.next
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
    val node = arrayListOf(1, 2, 3, 4, 5).toListNode()
    reverseKGroup2(node, 2)?.forEach()
}

