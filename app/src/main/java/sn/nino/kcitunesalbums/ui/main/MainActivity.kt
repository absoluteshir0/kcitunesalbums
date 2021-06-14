package sn.nino.kcitunesalbums.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// this is the dispatcher activity
// checks for the lastviewed activity
// then loads it
// if nothing is stored in Room DB
// load default activity --> StartActivity
class MainActivity : AppCompatActivity(){
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)

    }

    override fun onStart() {
        super.onStart()
        presenter.loadSession()
    }


}