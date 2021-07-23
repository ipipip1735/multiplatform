import org.apache.maven.artifact.versioning.ComparableVersion
import kotlin.test.Test

/**
 * Created by Administrator on 2021/7/12.
 */
class JvmTest {
    @Test
    fun testGo() {
        println("9999")
        val c: ComparableVersion = ComparableVersion("dd")
        println("c = ${c}")

    }
}