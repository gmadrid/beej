package com.scrawlsoft.android.beej.quiz

import BoxLevel
import Question
import QuestionInfo
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.time.LocalTime


class LeitnerBox

/*
    Has a BoxLevel enum which has elements for values from One to Fourteen
    - has an Increment method that maps each element to the next one except for the last one that is mapped to itself
    - has a TimeIncrement method that maps each element to a Duration of 1 minute

    Has a QuestionInfo struct:
    - has a 'next ask time' which may be null if the question has never been asked.
    - has a CardLevel

    Has LeitnerBox
    - Implements Box
    - Has an internal map from Id of String type to QuestionInfo
    - AddCard method that take an id and a CardInfo adding it to the map possibly overwriting an existing value



    - Internally, associates every id
 */

typealias WorkingSet = Map<String, QuestionInfo>

fun getIdsFromWorkingSet(workingSet: WorkingSet): Set<String> {
    return workingSet.keys
}

fun <Q, A> getIdsFromQuestions(questions: List<Question<Q, A>>): Set<String> {
    return questions.map { it.id }.toSet()
}

fun getIdsWithBoxLevelOne(ids: Set<String>, workingSet: WorkingSet): Set<String> {
    return ids.filter { id ->
        workingSet[id]?.level == BoxLevel.One
    }.toSet()
}

fun getMissingIdsFromWorkingSet(ids: Set<String>, workingSet: WorkingSet, count: Int): Set<String> {
    return (ids - workingSet.keys).shuffled().take(count).toSet()
}

fun getIdsWithPastAskTime(workingSet: WorkingSet): Set<String> {
    val now = LocalTime.now()
    return workingSet.filter { (_, info) ->
        info.nextAskTime.isBefore(now)
    }.keys
}

fun persistWorkingSet(context: Context, workingSet: WorkingSet) {
    val sharedPreferences = context.getSharedPreferences("working_set_prefs", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()

    val gson = Gson()
    val workingSetJson = gson.toJson(workingSet)

    editor.putString("workingSet", workingSetJson).apply()
}

fun retrieveWorkingSet(context: Context): WorkingSet? {
    val sharedPreferences = context.getSharedPreferences("working_set_prefs", Context.MODE_PRIVATE)
    val workingSetJson = sharedPreferences.getString("workingSet", null) ?: return null

    val gson = Gson()
    val type = object : TypeToken<Map<String, QuestionInfo>>() {}.type
    return gson.fromJson(workingSetJson, type)
}
