package com.learnprogramming.sharedpreferences

import android.content.Context

class MyPre(context: Context) {
    val PREF1 = "mypref"
    val SCORE = "score"
    val pref = context.getSharedPreferences(PREF1,Context.MODE_PRIVATE)

    fun getScore():Int{
        var score = pref.getInt(SCORE,0)
        return score
    }

    fun setScore(score:Int){
        var editor = pref.edit()
        editor.putInt(SCORE,score)

        editor.apply()
    }
}