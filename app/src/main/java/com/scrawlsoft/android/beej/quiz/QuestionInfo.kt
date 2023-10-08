import java.time.LocalTime

data class QuestionInfo(
    val nextAskTime: LocalTime,
    val level: BoxLevel
)
