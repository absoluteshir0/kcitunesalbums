package sn.nino.kcitunesalbums

import android.app.Application
import sn.nino.kcitunesalbums.utils.AppPreferences

// Application class
// initialize SharedPreferences Globally
// throughout the project
class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()
        AppPreferences.init(this)
    }
}