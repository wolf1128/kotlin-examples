
class AmphibiousCar(var propellers: Int): Car(true) { // NOTE: Inheritance is not anymore a good paradigm. It may break the equality testing for example. 
    override fun equals(other: Any?): Boolean {
        if (this === other) return true;
        if (other === null) return false;
        if (!(other is AmphibiousCar)) return false;
        val otherACar = other as AmphibiousCar; // safe casting

        // what makes two cars equal
        return this.id == otherACar.id && this.propellers == otherACar.propellers
    }
}

open class Car constructor(val isElectric: Boolean) { // In Kotlin, classes are final by default and cannot be inherited. Using open keyword to allow inheritance
    val id = 0;
    var brand = "unknown"
    var isOn = false
    var engineType: String = ""
        set(v) { if(v.length < 3) throw RuntimeException("too short brand name"); else field = v; println("value updated") }
    init {
        engineType = if (isElectric) "electric" else "ICE"
        println("engineType in Init block: $engineType")
    }

    constructor() : this(true) {
        println("Secondary constructor")
        println("isElectric: $isElectric")
    }

    fun engineSwitch() {
        isOn = !isOn
        if (isOn) {
            println("${if(isElectric) "zzzzzz" else "Broom"}")
        } 
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true;
        if (other === null) return false;
        if (!(other is Car)) return false;
        val otherCar = other as Car; // safe casting

        // what makes two cars equal
        return this.id == otherCar.id
    }
}


fun main (args: Array<String>) {
    // try#1
    // val c = Car()
    // val cc = Car()

    // // Equality Testing
    // println(c==cc) // reflexive  -> true
    // println(cc==c) // symme...   -> true
    // println(cc==c) // ...tric    -> true

    // try#2
    val c = Car()
    val cc = AmphibiousCar(2)

    // Equality Testing (not working anymore)
    // Everytime we inherit, we need to duplicate the equals method. It means putting it again in the inherited class (amphibiousCar in this case)
    println(c==cc) // reflexive -> true
    println(cc==c) // symme...  -> false (broke)
    println(cc==c) // ...tric   -> false (broke)
    // reason of broke: if (!(other is AmphibiousCar)) return false; | It means the other car is specific and not equal to the AmphibiousCar
    // SOLUTION: It depends on the development platform. For example, in Android world, we need to access to JVM classes.
    // if (this.javaClass != other.javaClass) return false; -> We need to put this in both Car and AmphibiousCar classes.
    // but, if we change the target platform to JS, we do not have access to Java classes anymore and the code will break!
}