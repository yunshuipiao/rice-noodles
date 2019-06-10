package model

class ListNode(var `val`: Int) {

    var next: ListNode? = null

    fun forEach(f: ((String) -> Unit) = ::print) {
        f("${this.`val`}")
        var node: ListNode? = this.next
        while (node != null) {
            f(" --> ${node.`val`}")
            node = node.next
        }
        println()
    }

}

fun ArrayList<Int>.toListNode(): ListNode? {
    val head: ListNode? = ListNode(0)

    var temp = head
    this.forEach {
        val node: ListNode? = ListNode(it)
        temp?.next = node
        temp = temp?.next
    }
    return head?.next
}

