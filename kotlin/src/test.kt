import org.testng.annotations.Test
import kotlin.test.assertEquals

@Test
fun _0001() {
    val result = twoSum(intArrayOf(0, 3, 4, 0), 0)
    assertEquals(0, result[0])
    assertEquals(3, result[1])
}