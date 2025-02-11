// Variables


fun main() {
    // Immutable variable (read-only)
    val name = "Salar"
    println("Hello, $name!")

    var age: Int = 30
    println("I am $age years old")
    age += 1
    println("I will be $age years old next year")

    // Type inference
    val city = "Rome"
    println("I live in $city")

    // Nullable variable
    var country: String? = "Italy"
    println("I am from $country")
    country = null
    println("I am from $country")

    val PI = 3.14159
    println("The value of PI is $PI")


    // Data Structures
    // // Arrays
    val numbers = arrayOf(1, 2, 3, 4, 5) // Mutable, fixed-size array
    println("The first number is ${numbers[0]}")
    // // Lists
    val names = listOf("Alice", "Bob", "Charlie") //  immutable, fixed-size list
    // names[0] = "David" // Error: Val cannot be reassigned (compilation error)
    println("The first name is ${names[0]}")
    // // Mutable Lists
    val mutableNames = mutableListOf("Alice", "Bob", "Charlie") // mutable, variable-size list
    // // Sets
    val uniqueNames = setOf("Alice", "Bob", "Charlie") // immutable, fixed-size set
    println("Alice is in the set: ${uniqueNames.contains("Alice")}")
    // // Maps
    val ages = mapOf("Alice" to 25, "Bob" to 30, "Charlie" to 35) // immutable, fixed-size map
    println("Alice is ${ages["Alice"]} years old")

}