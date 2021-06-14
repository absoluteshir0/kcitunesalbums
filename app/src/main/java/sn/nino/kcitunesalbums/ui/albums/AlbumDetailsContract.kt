package sn.nino.kcitunesalbums.ui.albums

import sn.nino.kcitunesalbums.api.Results

interface AlbumDetailsContract {
    interface Presenter {
        fun saveSession(results: Results)
    }
}