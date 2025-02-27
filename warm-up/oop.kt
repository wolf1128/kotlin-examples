// OOP Concepts



interface PersonalInfo {
    val name: String
    val age: Int
    fun info()
}

// Marking the class as open allows it to be inherited by other classes
open class Person(override val name: String, override val age: Int) : PersonalInfo {
    override fun info() {
        println("Hello, my name is $name and I am $age years old.")
    }
}

// INHERITANCE
class Student(name: String, age: Int, val sid: String) : Person(name, age) {
    fun studentInfo() {
        println("Hello, my name is $name and I am $age years old. My student ID is $sid.")
    }
}


abstract class Speed {
    abstract fun speed()
}

class Car(val brand: String, val model: String, val year: Int): Speed() { // Car with primary constructor
    // Member function
    fun carInfo() {
        println("This is a $year $brand $model.")
    }

    override fun speed() {
        println("This car is fast and go up to 300 km/s.")
    }
}


// Companion Object
class MathUtil {
    companion object {
        fun add(a: Int, b: Int): Int { // can be called without creating an instance of the class
            return a + b
        }
    }
}


// Nested / Inner classes
class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }

    inner class Inner { // features: can access members of the outer class.
        fun foo() = bar
    }
}

fun main() {
    val student = Student("Salar", 30, "123456")
    student.studentInfo()

    val car = Car("Toyota", "Corolla", 2020)
    car.carInfo()   
    car.speed()

    val sum = MathUtil.add(10, 20)
    println("Sum: $sum")

    val outer = Outer()
    val nested = Outer.Nested().foo()
    println("Nested: $nested")
}