package sn.nino.kcitunesalbums.ui.main

import android.annotation.SuppressLint
import android.app.Activity
import sn.nino.kcitunesalbums.db.AppDatabase
import sn.nino.kcitunesalbums.db.Session
import sn.nino.kcitunesalbums.ui.StartActivity
import sn.nino.kcitunesalbums.utils.AppPreferences
import sn.nino.kcitunesalbums.utils.LoadActivity
import java.text.SimpleDateFormat
import java.util.*

class MainPresenter(private val activity: Activity): MainContract.Presenter {
    @SuppressLint("SimpleDateFormat")
    override fun loadSession() {
        val db = AppDatabase.getInstance(activity)
        var activityClass: Class<*>? = null
        val session: Session?

        // set a default value for lastviewed activity
        // if app runs for the first time
        // here StartActivity is set as the default value
        if (AppPreferences.firstRun){
            val date = SimpleDateFormat("MMM dd, yyyy hh:mm a").format(Date())
            val defaultSession = Session(0, date, "sn.nino.kcitunesalbums.ui.StartActivity", null)
            db.sessionDao().addSession(defaultSession)
            session = defaultSession
            activityClass = StartActivity::class.java
        } else {
            // fetch the last viewed activity
            // saved in Room DB
            // when the app was closed
            session = db.sessionDao().getLastSession()
            val lastViewedActivity = db.sessionDao().getLastSession().lastViewedActivity;
            activityClass= if (lastViewedActivity!!.isNotEmpty()){
                AppPreferences.firstRun = false
                try {
                    Class.forName(lastViewedActivity)
                } catch (ex: ClassNotFoundException) {
                    StartActivity::class.java
                }

            } else{
                AppPreferences.firstRun = true
                StartActivity::class.java
            }
        }

        AppPreferences.fromSession = !session.lastViewedAlbum.isNullOrEmpty()
        LoadActivity.goTo(activity, activityClass, session)

    }




}