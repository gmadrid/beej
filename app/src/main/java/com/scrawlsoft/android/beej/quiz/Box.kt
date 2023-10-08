package com.scrawlsoft.android.beej.quiz

interface Box {
    val nextQuestion: String

    fun responseCorrect(id: String, correct: Boolean)
}