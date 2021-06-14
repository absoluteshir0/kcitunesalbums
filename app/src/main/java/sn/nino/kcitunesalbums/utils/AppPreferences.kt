package sn.nino.kcitunesalbums.utils

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "KCiTunesAlbums"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    // list of app specific preferences
    private val IS_FIRST_RUN_PREF = Pair("is_first_run", true)
    private val IS_FROM_SESSION = Pair("is_from_session", false)

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var firstRun: Boolean
        // custom getter to get a preference of a desired type, with a predefined default value
        get() = preferences.getBoolean(IS_FIRST_RUN_PREF.first, IS_FIRST_RUN_PREF.second)

        // custom setter to save a preference back to preferences file
        set(value) = preferences.edit {
            it.putBoolean(IS_FIRST_RUN_PREF.first, value)
        }

    var fromSession: Boolean
        get() = preferences.getBoolean(IS_FROM_SESSION.first, IS_FROM_SESSION.second)

        set(value) = preferences.edit {
            it.putBoolean(IS_FROM_SESSION.first, value)
        }
}