import groovy.time.TimeCategory

//FirstClass first = new FirstClass(1, "first")

Binding binder = new Binding()
binder.setProperty("id", 2)
binder.setProperty("str", "second")
FirstClass second = new FirstClass(binder.variables)

println(second.getProperty("str"))

str = "1"
println(str instanceof Integer)

intGlobal = 1 as Integer
def varLocal = 2
Integer intYear = "2015" as Integer

public methodOne() {
    println("\nmethodOne()")
    println("intGlobal = 1 as Integer: " + intGlobal)
    try {
        println(intYear)
    } catch (groovy.lang.MissingPropertyException e) {
        println("Can't see intYear: Integer intYear = \"2015\" as Integer")
    }
    try {
        println(varLocal)
    } catch (groovy.lang.MissingPropertyException e) {
        println("Can't see varLocal: def varLocal = 2\n")
    }
}
methodOne()

Integer autoReturn(Integer num) {
    num
}

test = autoReturn(10)
println(test)

// Lesson 2

int returnInt (Integer value) {
    return value
}

Integer returnInteger (Integer value) {
    return value
}

// returnInteger выполнится, returnInt - нет
//println(returnInt(null))
println(returnInteger(null))

//
BigDecimal bigDec1 = new BigDecimal(1.2)
BigDecimal bigDec2 = new BigDecimal(1.2)

println("\n.is vs .equals")
println(bigDec1.is(bigDec2))
println(bigDec1.equals(bigDec2))

println("\nmethods vs operators")
println(bigDec1.add(bigDec2) == bigDec1 + bigDec2)
println(bigDec1.multiply(bigDec2) == bigDec1 * bigDec2)
println(bigDec1.divide(bigDec2) == bigDec1 / bigDec2)

var = 'First'
var = 'f'
var = 10

println("\nDynamic typing:\n" + var)
println(var.getClass().getName())

feb = new Date().parse('yyyy/MM/dd', '2015/02/28')
jan = new Date().parse('yyyy/MM/dd', '2015/01/31')
println("\nDates\n" + feb)
println(jan)
println("subtraction: " + (feb - jan))
use (TimeCategory) {
    println("feb - 1 month + 1 day + 1 month: " + (feb - 1.month + 1.month + 1.day))
}

Closure divide = {a, b -> a / b}
Closure subtract = {a, b -> a - b}
Closure combo = {a, b, c -> subtract(divide(a, b), c)}
println("\nClosures")
println("a/b, a=6, b=3: " + divide(6,3))
println("a-b, a=7, b=2: " + subtract(7,2))
println("a/b-c, a=7, b=2, c=1.5: " + combo(7, 2, 1.5))