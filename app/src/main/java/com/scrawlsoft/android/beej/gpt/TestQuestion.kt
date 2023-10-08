class TestQuestion(private val value: Int) : Question<String, Int> {
    override val id: String = "TestQuestion-$value"
    override val question: String = "Question $value"

    override fun checkAnswer(answer: Int): Boolean = answer == value
}

fun generateTestQuestions(num: Int): List<TestQuestion> {
    return (1..num).map { TestQuestion(it) }
}
