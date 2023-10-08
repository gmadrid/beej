import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

enum class BoxLevel {
    One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Eleven, Twelve, Thirteen, Fourteen;

    fun Increment(): BoxLevel {
        return if (this.ordinal < values().lastIndex) {
            values()[this.ordinal + 1]
        } else {
            this // Return the current value if it's the last one
        }
    }

    fun TimeIncrement(): Duration {
        return when (this) {
            One -> 1.minutes
            Two -> 2.minutes
            Three -> 3.minutes
            Four -> 4.minutes
            Five -> 5.minutes
            Six -> 6.minutes
            Seven -> 7.minutes
            Eight -> 8.minutes
            Nine -> 9.minutes
            Ten -> 10.minutes
            Eleven -> 11.minutes
            Twelve -> 12.minutes
            Thirteen -> 13.minutes
            Fourteen -> 14.minutes
        }
    }
}
