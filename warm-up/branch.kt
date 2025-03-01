

fun main (args: Array<String>) {
    // branch examples
    println("Example 1:")
    val x = 10
    val y = 20
    val max = if (x > y) x else y
    println("Max: $max")


    println("Example 2:")
    val number = 10
    val result = when {
        number < 0 -> "Negative"
        number == 0 -> "Zero"
        number > 0 -> "Positive"
        else -> "Invalid number" // else is mandatory
    }
    println("Result: $result")
}
