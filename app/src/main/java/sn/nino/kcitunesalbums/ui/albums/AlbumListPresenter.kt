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
import sn.nino.kcitunesalbums.utils.UIDialogs
import java.text.SimpleDateFormat
import java.util.*

class AlbumListPresenter(private val activity: Activity?, val view: AlbumListContract.View): AlbumListContract.Presenter {
    var pdl: Dialog = UIDialogs.progressDialog(activity!!)
    override fun getAlbums() {
        pdl.show()
        val api = Api.create().getAlbums("star", "au", "movie", "")

        api.enqueue( object : Callback<ApiResponse?> {
            override fun onResponse(call: Call<ApiResponse?>, response: Response<ApiResponse?>) {
                pdl.dismiss()
                if(response.body() != null) {
                    val apiResponse: ApiResponse = response.body()!!
                    view.loadAlbums(apiResponse.results)
                    view.displayDate()
                } else {
                    view.displayError("No data found!")
                }

            }

            override fun onFailure(call: Call<ApiResponse?>, t: Throwable) {
                pdl.dismiss()
                view.displayError(t.message)
            }
        })
    }

    @SuppressLint("SimpleDateFormat")
    override fun saveSession() {
        val db = AppDatabase.getInstance(activity!!)
        val date = SimpleDateFormat("MMM dd, yyyy hh:mm a").format(Date())
        val session = Session(0, date, activity.javaClass.name.toString(), null)
        db.sessionDao().updateSession(session)

    }
}