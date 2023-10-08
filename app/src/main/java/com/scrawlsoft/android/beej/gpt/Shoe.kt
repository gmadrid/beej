import kotlin.random.Random

class Shoe(private val numberOfDecks: Int) {
    private val fullDeck: List<Card> = List(52) { Card(it) }
    private var cards: MutableList<Card> = initialCards()

    fun shuffle() {
        cards.shuffle(Random)
    }

    fun deal(): Card? {
        return if (cards.isNotEmpty()) {
            cards.removeAt(0)
        } else {
            null
        }
    }

    fun reset() {
        cards = initialCards()
    }

    private fun initialCards() = (1..numberOfDecks).flatMap { fullDeck }.toMutableList()
}
