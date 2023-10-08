class SimpleBlackjackCounter : Counter {
    override var count: Int = 0

    override fun adjustCount(card: Card) {
        when (card.rank) {
            Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX -> count++
            Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE -> count--
            else -> {} // Do nothing for other cards
        }
    }
}
