import java.time.LocalTime

data class Film(
    private val name: String,
    private val duration: LocalTime,
    private var description: String,
    private val sessions: MutableList<Session> = mutableListOf()
) {
    fun name() = name
    fun setDescription(newDescription: String) = run { description = newDescription }
    fun addSession(session: Session) = run { sessions.add(session) }
}