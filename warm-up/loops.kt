fun main(args: Array<String>) {
    println("Example 1:")
    val data = intArrayOf(1, 2, 4, 8, 16, 32, 64);

    for (item in data)
        println("Item: ${item}")

    println("Example 2:")
    val names = listOf("Alice", "Bob", "Charlie", "David", "Eve", "Frank");

    for (index in names.indices)
        println("Corresponding ${index} name: ${names[index]}")

    println("Example 3:")
    var i = 1

    while (i <= 10) {
        println("Value of i: $i")
        i++
    }


    println("Example 4:")
    var j = 1

    do {
        println("Value of j: $j")
        j++
    } while (j <= 5)
    

    println("Example 5:")
    for (i in 5 downTo 1) // 5 to 1
        println("Value of i: $i")

    println("Example 6:")
    for (i in 1 until 6) // 1 to 5
        println("Value of i: $i")

    println("Example 7:")
    for (i in 1..3)
        for (j in 1..3)
            println("i: $i, j: $j")

}



