fun main() {
    println("Welcome to the Kotlin Calculator!")
    println("Made by TrickyLoop")

    var programIsRunning = true

    while (programIsRunning) {

        var num1 = 0.0
        var num2 = 0.0
        var operation: Char = ' '

        while (true) {
            try {
                print("Enter 1st number: ")
                num1 = readln().toDouble()
            }
            catch (e: NumberFormatException) {
                println("Please enter a valid number")
                continue
            }
            break
        }

        while (true) {
            print("Enter the operation (+, -, *, /): ")
            operation = readln().single()

            when (operation) {
                '+', '-', '*', '/' -> break
                else -> {
                    println("Invalid operation")
                    continue
                }
            }
        }

        while (true) {
            try {
                print("Enter 2nd number: ")
                num2 = readln().toDouble()
                if (operation == '/' && num2 == 0.0) {
                    throw ArithmeticException()
                }
            }
            catch (e: ArithmeticException) {
                println("Division by zero error. You can't divide by zero")
                continue
            }
            catch (e: NumberFormatException) {
                println("Please enter a valid number")
                continue
            }
            break
        }

        when (operation) {
            '+' -> println("Result: ${add(num1, num2)}")
            '-' -> println("Result: ${subtract(num1, num2)}")
            '*' -> println("Result: ${multiply(num1, num2)}")
            '/' -> println("Result: ${divide(num1, num2)}")
        }

        print("Do you want to use it again? (y/n): ")
        val shouldExecuteAgain = readln().single()

        if (shouldExecuteAgain == 'n') {
            programIsRunning = false
        }
        else {
            continue
        }
    }
}

fun add(x: Double, y: Double): Double {
    return x + y
}

fun subtract(x: Double, y: Double): Double {
    return x - y
}

fun multiply(x: Double, y: Double): Double {
    return x * y
}

fun divide(x: Double, y: Double): Double {
    return x / y
}