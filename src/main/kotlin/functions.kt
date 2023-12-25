import java.time.LocalDateTime

fun getLocalDateTime(): LocalDateTime {
    print("Year: ")
    val year = readln().toInt()
    println()
    print("Month: ")
    val month = readln().toInt()
    println()
    print("Day of month: ")
    val dayOfMonth = readln().toInt()
    println()
    print("Hours: ")
    val hour = readln().toInt()
    println()
    print("Minutes: ")
    val minutes = readln().toInt()
    println()
    return LocalDateTime.of(year, month, dayOfMonth, hour, minutes)
}