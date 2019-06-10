import model.ListNode
import model.toListNode
import org.testng.annotations.Test
import java.util.*

/**
 * 典型的归并排序的应用
 */
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) {
        return null
    }
    return mergeKLists(lists, 0, lists.size - 1)
}

fun mergeKLists(list: Array<ListNode?>, left: Int, right: Int): ListNode? {
    if (left == right) {
        return list[left]
    }
    val mid = left + (right - left) / 2
    val node1 = mergeKLists(list, left, mid)
    val node2 = mergeKLists(list, mid + 1, right)
    return mergeTwoLists(node1, node2)
}

/**
 * 使用优先队列，最小堆实现
 */
fun mergeKLists2(lists: Array<ListNode?>): ListNode? {
    val newHead = ListNode(0)
    var temp: ListNode? = newHead

    val p = PriorityQueue<ListNode>(Comparator<ListNode> { o1, o2 ->
        when {
            o1.`val` < o2.`val` -> -1
            o1.`val` == o2.`val` -> 0
            else -> 1
        }
    })
    lists.forEach {
        if (it != null) {
            p.add(it)
        }
    }
    while (p.isNotEmpty()) {
        val node = p.poll()
        temp?.next = node
        temp = temp?.next

        if (node.next != null) {
            p.add(node.next)
        }
    }
    return newHead.next
}


@Test
fun _0023() {
    val node1 = arrayListOf(1, 4, 5).toListNode()
    val node2 = arrayListOf(3, 3, 4).toListNode()
    val node3 = arrayListOf(2, 6).toListNode()
    val lists = arrayOf(node1, node2, null)
    mergeKLists2(lists)?.forEach()
}

