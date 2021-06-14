package sn.nino.kcitunesalbums.ui.albums

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import sn.nino.kcitunesalbums.api.Results
import sn.nino.kcitunesalbums.databinding.ActivityAlbumsListBinding
import sn.nino.kcitunesalbums.db.Session
import sn.nino.kcitunesalbums.ui.adapter.AlbumListAdapter
import sn.nino.kcitunesalbums.utils.Constants
import sn.nino.kcitunesalbums.utils.LoadActivity
import kotlin.system.exitProcess


class AlbumListActivity : AppCompatActivity(), AlbumListContract.View, AlbumListAdapter.IAdapter {

    lateinit var binding: ActivityAlbumsListBinding
    lateinit var presenter: AlbumListPresenter
    lateinit var session: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.extras
        if (!intent!!.isEmpty){
            session = intent.getParcelable<Session>(Constants.KEY_SESSION)!!
        }

        presenter = AlbumListPresenter(this, this)
        presenter.getAlbums()
    }



    override fun loadAlbums(results: MutableList<Results>?) {
        val mAdapter = AlbumListAdapter(this, results!!, this)

        binding.rvAlbums.apply {
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            adapter = mAdapter
        }

    }

    override fun displayError(s: String?) {
    }

    override fun displayDate() {
        binding.tvDate.text = session.date.toString()
    }


    override fun onClick(results: Results) {
       LoadActivity.goTo(this, AlbumDetailsActivity::class.java, results)
    }

    override fun exitApp() {
        presenter.saveSession()
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        startActivity(intent)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        exitApp()
    }

    override fun onStop() {
        super.onStop()
        presenter.saveSession()
    }


}