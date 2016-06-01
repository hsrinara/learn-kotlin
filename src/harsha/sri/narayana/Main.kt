package harsha.sri.narayana

class MutablePerson(var name: String, var age: Int) {
}

class ImmutablePerson(val name: String, val age: Int) {
    fun isEligibleToVote(): Boolean {
        return age >= 18
    }
}

fun ImmutablePerson.isTeenager(): Boolean {
    return age in 13..19
}

fun String.isCatLike(): Boolean {
    return contains("cat")
}

fun isNumberEven(num: Int): Boolean = num % 2 == 0

// Playing with kotlin - mostly based on these koans.
// http://code.tutsplus.com/tutorials/an-introduction-to-kotlin--cms-24051
fun main(args: Array<String>) {

    // mutable class, fields
    var bob = MutablePerson(name = "Bob", age = 40);
    println("Hello " + bob.name + ", your age is " + bob.age)
    bob.age = 41
    println("Hello " + bob.name + ", your age is now " + bob.age)

    // immutable class
    val alice = ImmutablePerson(name = "Alice", age = 40) // alice is immutable
    println("Hello " + alice.name + ", your age is " + alice.age)

    // methods
    if (alice.isEligibleToVote()) {
        println(alice.name + " is eligbile to vote")
    } else {
        println(alice.name + " is NOT eligbile to vote")
    }

    // class extensions
    println("Alice is a teenager = " + alice.isTeenager())


    // jdk class extensions - nobody will abuse this feature.
    println("is foo bar lar cat, cat like? " + "foo bar lar cat".isCatLike())
    println("is foo bar lar, cat like? " + "foo bar lar".isCatLike())

    // single line functionss
    println("1 is even " + isNumberEven(1))
    println("2 is even " + isNumberEven(2))

    // inline lambda - lovely syntax. And checkout the intellij highlighting. Good stuff.
    println(apply(3, 4, { x, y -> x + y }))

    // extract lambda
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val multiply: (Int, Int) -> Int = { x, y -> x * y }
    println("3 + 4 is " + apply(3, 4, sum))
    println("3 * 4 is " + apply(3, 4, multiply))


    // oh so good. extension function + generics. Statically compiled unlike groovy.
    println(arrayOf(1, 2, 3, 4).map { it * 2 })

    // if statements are expressions
    println("Alice is " + if(alice.isTeenager()) "" else " NOT " + " a teenager")

    // switch statements are also expressions.
    println("Alice is " + when {
        alice.isTeenager() -> ""
        else -> " NOT " +
                " a teenager"
    })
}

fun apply(x: Int, y: Int, f: (Int, Int) -> Int): Int {
    return f(x, y)
}
