package com.scrawlsoft.android.beej.quiz

import kotlin.random.Random
import kotlin.random.nextInt

class RandomBox constructor(private val ids: List<String>): Box {

    override val nextQuestion: String
        get() {
            val idx = Random(1).nextInt(0..ids.size);
            return ids[idx]
        }

    override fun responseCorrect(id: String, correct: Boolean) {
        // Nothing to do here.
    }
}