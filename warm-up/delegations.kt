import kotlin.properties.Delegates

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

class User {
    var name: String by Delegates.observable("<no name>") { 
        prop, old, new -> println("$prop has changed from $old to $new")
     }
}

class Math {
    var max: Int by Delegates.vetoable(0) { prop, old, new ->  // 0 is the initial value
        // new > old // enough to be polite or...
        if (new > old) true else throw IllegalArgumentException("New value must be greater than old value")        
    }
}

class CustomDelegate {
    var p: String by MyCustomDelegate()
}

class MyCustomDelegate {
    operator fun getValue(thisRef: Any?, property: Any?): String {
        // comput the value
        return "$thisRef, thank you for delegating '${property?.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: Any?, value: String) {
        // store the value
        println("$value has been assigned to '${property?.name}' in $thisRef.")
    }
}

fun main(args: Array<String>) {
    println("Lazy Delegation: ")
    println(lazyValue) // computed! Hello
    println(lazyValue) // Hello

    println("Obseravle Delegation: ")
    val user = User()
    user.name = "first" // <no name> -> first
    user.name = "second" // first -> second

    println("Vetoable Delegation: ")
    val math = Math()
    println(math) // 0
    math.max = 10
    println(math.max)
    math.max = 5 // Run-time exception: IllegalArgumentException: New value must be greater than old value

    println("Custom Delegation: ")
    val c = CustomDelegate()    
    println(c.p) // CustomDelegate@6d03e736, thank you for delegating 'p' to me!
}