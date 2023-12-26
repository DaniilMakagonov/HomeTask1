import java.time.LocalDateTime
import kotlin.system.exitProcess

class Cinema {
    private val films = mutableListOf<Film>()
    private val sessions = mutableListOf<Session>()

    fun work(command: String) {
        try {
            when (command) {
                "buy" -> {
                    val session = getSession(sessions)
                    val line = readln().toInt()
                    val row = readln().toInt()
                    session?.auditorium?.buy(line, row)
                    if (session == null)
                        println("There is no this session in cinema")
                }

                "return" -> {
                    val session = getSession(sessions)
                    val line = readln().toInt()
                    val row = readln().toInt()
                    if (session != null && session.start > LocalDateTime.now())
                        session.auditorium.cancel(line, row)
                    if (session == null)
                        println("There is no this session in cinema")
                }

                "hall" -> {
                    val session = getSession(sessions)
                    session?.auditorium?.print()
                    if (session == null)
                        println("There is no this session in cinema")
                }

                "redact film description" -> {
                    val filmName = readln()
                    val newDescription = readln()
                    var film: Film? = null
                    for (i in 0..<films.size) {
                        if (films[i].name() == filmName) {
                            films[i].setDescription(newDescription)
                            film = films[i]
                            break
                        }
                    }
                    if (film == null)
                        println("There is no this film in cinema")
                    else {
                        for (session in sessions)
                            if (session.film.name() == filmName)
                                session.film.setDescription(newDescription)
                    }
                }

                "redact session time" -> {
                    val session = getSession(sessions)
                    println("New date and time:")
                    val newDate = getLocalDateTime()
                    session?.start = newDate
                    if (session == null)
                        println("There is no this session in cinema")
                }

                "exit" -> exitProcess(0)

                "add film" -> {
                    print("Film: ")
                    val filmName = readln()
                    print("Description: ")
                    val description = readln()
                    println("Duration: ")
                    val duration = getLocalTime()
                    films.add(Film(filmName, duration, description))
                }

                "add session" -> {
                    print("Film: ")
                    val filmName = readln()
                    println("Date and time: ")
                    val start = getLocalDateTime()
                    var film: Film? = null
                    for (i in 0..<films.size) {
                        if (films[i].name() == filmName) {
                            film = films[i]
                            break
                        }
                    }
                    if (film == null)
                        println("There is no this film in cinema")
                    else {
                        val session = Session(film, start)
                        film.addSession(session)
                    }
                }

                else -> println("incorrect command")
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }
}