import java.time.LocalDateTime
import java.time.LocalTime

fun getLocalDateTime(): LocalDateTime {
    print("Year: ")
    val year = readln().toInt()
    print("Month: ")
    val month = readln().toInt()
    print("Day of month: ")
    val dayOfMonth = readln().toInt()
    print("Hours: ")
    val hour = readln().toInt()
    print("Minutes: ")
    val minutes = readln().toInt()
    return LocalDateTime.of(year, month, dayOfMonth, hour, minutes)
}

fun getLocalTime(): LocalTime {
    print("Hours: ")
    val hour = readln().toInt()
    print("Minutes: ")
    val minutes = readln().toInt()
    return LocalTime.of(hour, minutes)
}

fun getSession(sessions: MutableList<Session>): Session? {
    print("Film: ")
    val filmName = readln()
    val filmTime = getLocalDateTime()
    for (session in sessions) {
        if (session.film.name() == filmName && session.start == filmTime && session.start <= LocalDateTime.now()) {
            return session
        }
    }
    return null
}