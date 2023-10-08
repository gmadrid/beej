interface Question<Q, A> {
    val id: String
    val question: Q
    fun checkAnswer(answer: A): Boolean
}
