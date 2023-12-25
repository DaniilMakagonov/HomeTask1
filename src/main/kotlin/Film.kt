import java.time.LocalTime

data class Film(
    private val name: String,
    private val duration: LocalTime,
    private var description: String,
    private val sessions: MutableList<Session> = mutableListOf()
) {
    fun name() = name
    fun description() = description
    fun setDescription(newDescription: String) = run { description = newDescription }
}