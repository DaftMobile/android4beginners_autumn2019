package android4beginners1

// główny konstruktor (primary constructor) z domyślnym parametrem
class Person(val name: String, var age: Int, var job: Job? = null) {

    fun birthday() {
        age += 1
    }

    fun isOfAge() = age >= 18

    fun timeTravel(years: Int) {
        age += years
    }

    fun income() = job?.salary ?: 0
}

data class Job(val salary: Int)

fun Person.isEmployed(): Boolean = job != null

fun main(args: Array<String>) {
    var a: Int = 8
    var b: String = "Hallo"
    var c: Boolean = true
    b = "World"
    val d = 10

    val iosDev: Person = Person("Michał", 28, Job(1000))
    val androidDev: Person = Person("Konrad", 26, Job(1000))

    // sprawdzenie równości obiektów (Java .equals)
    println(iosDev.job == androidDev.job)

    // gettery i settery zamienione na property
    val point = Point(5f, 5f)
    point.x += 100f
    println(point)
}
