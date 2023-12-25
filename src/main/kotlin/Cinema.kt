import java.time.LocalDateTime

class Cinema {
    val films = mutableListOf<Film>()
    val sessions = mutableListOf<Session>()

    fun addFilm(film: Film) = run { films.add(film) }
    fun addSession(session: Session) = run { sessions.add(session) }

    fun work(command: String) {
        try {
            when (command) {
                "buy" -> {
                    val filmName = readln()
                    val filmTime = getLocalDateTime()
                    val line = readln().toInt()
                    val row = readln().toInt()
                    for (session in sessions) {
                        if (session.film.name() == filmName && session.start == filmTime && session.start <= LocalDateTime.now()) {
                            session.auditorium.buy(line, row)
                            return;
                        }
                    }
                }
                "return" -> {
                    val filmName = readln()
                    val filmTime = getLocalDateTime()
                    val line = readln().toInt()
                    val row = readln().toInt()
                    for (session in sessions) {
                        if (session.film.name() == filmName && session.start == filmTime && session.start <= LocalDateTime.now()) {
                            session.auditorium.buy(line, row)
                            return;
                        }
                    }
                }
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }
}