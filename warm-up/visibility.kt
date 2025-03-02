// Visibility Modifiers

class Student {
    public var name: String = "John"
    public var age: Int = 20
    public var rollNo: Int = 101

    private var address: String = "unknown"
    private var MADScore: Int = 0

    protected var firstName: String = "John"
    protected var lastName: String = "Doe"

    internal var email: String = "email@example.com" // accessible within the same module (set of files compiled together)

    fun fullName(): String {
        return "$firstName $lastName"
    }

    fun getMADScore(): Int {
        return MADScore
    }
}

fun main (args: Array<String>) {
    val s = Student()
    println(s.name) // public property
    // println(s.firstName) // protected property is not accessible
    // println(s.MADScore) // private property is not accessible
    println(s.email) // internal property is accessible
}