import java.text.SimpleDateFormat
import java.util.Date


fun currentTime(cutomString: String, f: (String) -> String) {
    val dateFormat = SimpleDateFormat("HH:mm:ss")
    val currentTime = dateFormat.format(Date())
    println("${f(cutomString)} $currentTime")
}

fun buildString(builderAction: StringBuilder.() -> Unit): String { // StringBuilder.() is a receiver type declaration for a lambda function or an extension function
    val sb = StringBuilder()
    sb.builderAction() // pay attention to the argument type of the lambda function
    return sb.toString()
}

data class Person(val name: String, val age: Int)


fun main(args: Array<String>) {
    println("Example 1:")
    currentTime("Current time: ") { customString: String ->
        "$customString"
    }

    println("Example 2:")
    // a higher order function that takes two functions as parameters
    fun performanceOperations(x: Int, y: Int, operation1: (Int, Int) -> Int, operation2: (Int) -> Int): Int {
        val result1 = operation1(x, y)
        return operation2(result1)
    }

    val result = performanceOperations(2, 3, { a, b -> a + b }, { it -> it * it * 2 })
    println("Result: $result")

    println("Example 3:")
    val result2 = buildString {
        append("Hello, ")
        append("World!")
    }
    println(result2)

    println("Example 4:")
    val people = listOf(
        Person("Alessandro", 30),
        Person("John", 25),
        Person("Jane", 22),
        Person("Chiara", 28)
    )

    val namesOfAdults = people.filter { it.age >= 25 }.map { it.name }
    println("Names of adults: $namesOfAdults")

    val groupByAge = people.groupBy { it.age }
    println("Group by age: $groupByAge")


    println("Example 5:")
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("Even numbers: $evenNumbers")

    val squaredNumbers = numbers.map { it * it }
    println("Squared numbers: $squaredNumbers")

    val sum = numbers.reduce { acc, i -> acc + i }
    println("Sum: $sum")

}