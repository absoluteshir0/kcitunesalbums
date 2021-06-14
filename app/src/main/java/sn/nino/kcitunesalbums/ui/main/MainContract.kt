package sn.nino.kcitunesalbums.ui.main

import sn.nino.kcitunesalbums.api.Results
import sn.nino.kcitunesalbums.db.Session

interface MainContract {
    interface Presenter {
        fun loadSession()
    }
}