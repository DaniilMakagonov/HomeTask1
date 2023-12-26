fun main() {
    val cinema = Cinema()
    while (true) {
        println(
            """
            Choose one of these operations and input its name to execute it:
            buy: buy the ticket for one session
            return: return ticket for one session? if it possible
            hall: print the hall status with free and bought seats
            redact film description: redact film description if film exist
            redact session time: redact session time if session exist
            add film: add film to list of all films
            add session: add session yo list of all sessions
            exit: finish work with app
        """.trimIndent()
        )
        cinema.work(readln())
    }
}
