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

