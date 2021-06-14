package sn.nino.kcitunesalbums.ui.albums

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import coil.api.load
import coil.transform.CircleCropTransformation
import sn.nino.kcitunesalbums.R
import sn.nino.kcitunesalbums.api.Results
import sn.nino.kcitunesalbums.databinding.ActivityAlbumDetailsBinding
import sn.nino.kcitunesalbums.db.Session
import sn.nino.kcitunesalbums.utils.AppPreferences
import sn.nino.kcitunesalbums.utils.Constants
import sn.nino.kcitunesalbums.utils.LoadActivity
import sn.nino.kcitunesalbums.utils.ResultsConverter
import java.text.SimpleDateFormat
import java.util.*

class AlbumDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAlbumDetailsBinding
    lateinit var results: Results
    lateinit var presenter: AlbumDetailsPresenter
    lateinit var session: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = AlbumDetailsPresenter(this)

        val intent = intent.extras
        if (!intent!!.isEmpty) {
            when(AppPreferences.fromSession){
                true -> {
                    session = intent.getParcelable<Session>(Constants.KEY_SESSION)!!
                    results = ResultsConverter.toObject(session.lastViewedAlbum!!)!!
                }
                else ->  results = intent.getParcelable(Constants.KEY_RESULTS)!!
            }

            binding.albumArt.load(results.artworkUrl100){
                crossfade(true)
                placeholder(R.drawable.ic_elements)
                transformations(CircleCropTransformation())
            }

            binding.albumTitle.text = if(results.trackName.isNullOrEmpty()) results.collectionName else results.trackName
            binding.albumArtist.text = results.artistName
            binding.albumGenre.text = results.primaryGenreName
            binding.albumPrice.text = if(results.trackName.isNullOrEmpty()) results.collectionName else results.trackName

            val desc: String? = when(results.wrapperType){
                "track"-> {
                    if (results.kind.equals("song")) "No description available" else results.longDescription
                }
                else -> results.description
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                binding.albumDesc.text = Html.fromHtml(desc, Html.FROM_HTML_MODE_COMPACT)
            }
        }

        binding.btBack.setOnClickListener { onBackPressed() }


    }

    @SuppressLint("SimpleDateFormat")
    override fun onBackPressed() {
        super.onBackPressed()
        AppPreferences.fromSession = false
        val date = SimpleDateFormat("MMM dd, yyyy hh:mm a").format(Date())
        val session = Session(0, date, null, null)
        LoadActivity.goTo(this, AlbumListActivity::class.java, session)
    }

    // leaving this activity saves the album data
    // to the session database
    override fun onStop() {
        super.onStop()
        presenter.saveSession(results)
    }



}