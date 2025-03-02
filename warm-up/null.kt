

fun main (args: Array<String>) {
    println("Example 1:")
    var x: String? = "Custom String"
    x = null
    println("x: $x")
    val len: Int? = x?.length
    println("Length: $len")
    var b: String? = "Another String"
    b = null
    var c: String = b ?: "Default String" // Elvis operator
    println("c: $c")
    // val len2: Int = b!!.length // Non-null assertion operator
}