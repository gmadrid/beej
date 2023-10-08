enum class Suit {
    SPADES, HEARTS, DIAMONDS, CLUBS;

    override fun toString(): String = when (this) {
        SPADES -> "♠"
        HEARTS -> "♥"
        DIAMONDS -> "♦"
        CLUBS -> "♣"
    }
}

enum class Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

    override fun toString(): String = when (this) {
        TWO -> "2"
        THREE -> "3"
        FOUR -> "4"
        FIVE -> "5"
        SIX -> "6"
        SEVEN -> "7"
        EIGHT -> "8"
        NINE -> "9"
        TEN -> "10"
        JACK -> "J"
        QUEEN -> "Q"
        KING -> "K"
        ACE -> "A"
    }
}

class Card(private val value: Int) {
    init {
        require(value in 0..51) { "Invalid card value. Must be between 0 and 51." }
    }

    val suit: Suit
        get() = Suit.values()[value / 13]

    val rank: Rank
        get() = Rank.values()[value % 13]

    override fun toString(): String = "${rank}${suit}"
}
