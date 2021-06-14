package sn.nino.kcitunesalbums.utils

import android.text.TextUtils
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import sn.nino.kcitunesalbums.api.Results

class ResultsConverter {
    companion object {
        private val moshi: Moshi = Moshi.Builder().build()

        @TypeConverter
        fun toObject(string: String): Results? {
            if (TextUtils.isEmpty(string))
                return null

            val jsonAdapter = moshi.adapter(Results::class.java)
            return jsonAdapter.fromJson(string)
        }

        @TypeConverter
        fun toStr(user: Results): String {
            val jsonAdapter = moshi.adapter(Results::class.java)
            return jsonAdapter.toJson(user)
        }
    }


}