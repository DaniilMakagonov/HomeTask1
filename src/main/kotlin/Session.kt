import java.time.LocalDateTime

data class Session(val film: Film, var start: LocalDateTime, val auditorium: Auditorium = Auditorium())