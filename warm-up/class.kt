
// class Car(var isElectric: Boolean){ // primary constructor | by default, It is public
// class Car private constructor(var isElectric: Boolean){ // way#2
class Car constructor(val isElectric: Boolean){ // way#2
    // property must be initialized or be abstract.
    val id = 0;
        get() = field * Math.PI 2 // NOTE: A getter has trade-off with performance. Since, we compute if field is accessed.
    var brand = "unknown" // If I put semicolon at the end of the line here, the setter will not be called.
    var isOn = false
    var engineType: String = ""
        set(v) { if(v.length < 3) throw RuntimeException("too short brand name"); else field = v; println("value updated") }
    // var engineType: String = "electric"
    // init vs. constructor: init block is called after primary constructor
    // init vs. secondary constructor: init block is called after secondary constructor
    init { // initializer block
        engineType = if (isElectric) "electric" else "ICE"
        println("engineType in Init block: $engineType")
    }

    // [secondary constructor]
    // secondary constructor vs. primary constructor: secondary will be called after primary
    constructor() : this(true) { // delagation, shall call the primary
        println("Secondary constructor")
        println("isElectric: $isElectric")
    }

    fun engineSwitch() {
        isOn = !isOn
        if (isOn) {
            println("${if(isElectric) "zzzzzz" else "Broom"}")
        } 
    }
}

fun main() {
    // val c = Car()
    val c = Car(true)
    println(c) // Car@76ed5528
    println(c.id) // 0
    // c.brand = "ab" // Exception
    c.brand = "abc"
    println(c.brand) // abc
    println(c.engineType) // electric
    // c.isElectric = false // xxx error: val cannot be reassigned
    println(c.engineType) // ICE

    // calling secondary constructor
    // how to call secondary constructor? 
    println("Secondary constructor")
    val c2 = Car() // NOTE: We are not passing any argument here, so, secondary constructor will be called.
    println(c2.engineType) // electric

    println(c2.engineSwitch())
}