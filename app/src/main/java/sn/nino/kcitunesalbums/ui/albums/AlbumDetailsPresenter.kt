package sn.nino.kcitunesalbums.ui.albums

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sn.nino.kcitunesalbums.api.Api
import sn.nino.kcitunesalbums.api.ApiResponse
import sn.nino.kcitunesalbums.api.Results
import sn.nino.kcitunesalbums.db.AppDatabase
import sn.nino.kcitunesalbums.db.Session
import sn.nino.kcitunesalbums.utils.ResultsConverter
import sn.nino.kcitunesalbums.utils.UIDialogs
import java.text.SimpleDateFormat
import java.util.*

class AlbumDetailsPresenter(private val activity: Activity?): AlbumDetailsContract.Presenter {
    @SuppressLint("SimpleDateFormat")
    override fun saveSession(results: Results) {
        val db = AppDatabase.getInstance(activity!!)
        val date = SimpleDateFormat("MMM dd, yyyy hh:mm a").format(Date())
        val session = Session(0, date, activity.javaClass.name.toString(), ResultsConverter.toStr(results))
        db.sessionDao().updateSession(session)

    }
}