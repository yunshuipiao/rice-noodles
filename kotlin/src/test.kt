
import model.ListNode
import org.testng.annotations.Test
import kotlin.test.assertEquals

@Test
fun _0001() {
    val result = twoSum(intArrayOf(0, 3, 4, 0), 0)
    assertEquals(0, result[0])
    assertEquals(3, result[1])
}

@Test
fun _0002() {
    val l1 = ListNode(2).apply {
        next = ListNode(4).apply {
            next = ListNode(3)
        }
    }
    val l2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }
    val result = addTwoNumbers(l1,l2)
    result?.forEach()
}