package sn.nino.kcitunesalbums.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sn.nino.kcitunesalbums.databinding.ActivityStartBinding
import sn.nino.kcitunesalbums.ui.albums.AlbumListActivity
import sn.nino.kcitunesalbums.utils.AppPreferences
import sn.nino.kcitunesalbums.utils.Constants
import sn.nino.kcitunesalbums.utils.LoadActivity
// StarterActivity for app first time run

class StartActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartBinding
    lateinit var session: sn.nino.kcitunesalbums.db.Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.extras
        if (!intent!!.isEmpty) {
            session = intent.getParcelable<sn.nino.kcitunesalbums.db.Session>(Constants.KEY_SESSION)!!
        }

        binding.btStart.setOnClickListener {
            AppPreferences.firstRun = false
            finish()
            LoadActivity.goTo(this, AlbumListActivity::class.java, session)
        }

    }
}