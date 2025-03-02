
// overloading 
class AddOperation {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun add(a: Int, b: Int, c: Int): Int {
        return a + b + c
    }

    fun add(a: Int, b: Int, c: Int, d: Int): Int {
        return a + b + c + d
    }
}

class Vector2D(val x: Int, val y: Int) {
    operator fun plus(other: Vector2D): Vector2D { // built-in Kotlin operator overloading
        return Vector2D(x + other.x, y + other.y) // Explnation: In Kotlin, when you overload operators like +, you typically return a new instance of the class to ensure immutability. 
                                                  // This means that the original objects remain unchanged, and a new object representing the result of the operation is created. 
                                                  // This is a common practice in functional programming and helps avoid side effects.
    }
}

fun main (args: Array<String>) {
    val addOperation = AddOperation()
    println(addOperation.add(1, 2)) // 3
    println(addOperation.add(1, 2, 3)) // 6
    println(addOperation.add(1, 2, 3, 4)) // 10

    val res = Vector2D(1, 2) + Vector2D(2, 3) // -> Vector2D(3, 5) 
    println(res) 
}