import model.ListNode
import model.toListNode
import org.testng.annotations.Test

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


@Test
fun _0023() {
    val node1 = arrayListOf(1, 4, 5).toListNode()
    val node2 = arrayListOf(1, 3, 4).toListNode()
    val node3 = arrayListOf(2, 6).toListNode()
    val lists = arrayOf(node1, node2, node3)
    mergeKLists(lists)?.forEach()
}

