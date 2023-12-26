class Auditorium {
    class Seat {
        private var isBooked: Boolean = false
        fun bookedStatus() = isBooked
        fun buy() = run { isBooked = true }
        fun cancel() = run { isBooked = false }
    }

    private val hall: MutableList<MutableList<Seat>> = mutableListOf()

    init {
        for (i in 0..23) {
            hall.add(mutableListOf())
            for (j in 1..24)
                hall[i].add(Seat())
        }
    }

    fun buy(line: Int, row: Int) {
        if (!hall[line][row].bookedStatus()) {
            hall[line][row].buy()
        } else {
            throw Exception("Seat has already bought")
        }
    }

    fun cancel(line: Int, row: Int) {
        if (hall[line][row].bookedStatus()) {
            hall[line][row].cancel()
        } else {
            throw Exception("Seat has not bought")
        }
    }

    fun print() {
        for (line in hall) {
            for (seat in line) {
                print(if (seat.bookedStatus()) "x" else ".")
            }
            println()
        }
    }

}