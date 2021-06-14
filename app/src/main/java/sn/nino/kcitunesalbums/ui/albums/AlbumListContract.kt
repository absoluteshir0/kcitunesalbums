package sn.nino.kcitunesalbums.ui.albums

import sn.nino.kcitunesalbums.api.Results

interface AlbumListContract {
    interface View {
        fun exitApp()
        fun loadAlbums(results: MutableList<Results>?)
        fun displayError(s: String?)
        fun displayDate()
    }

    interface Presenter {
        fun getAlbums()
        fun saveSession()
    }
}