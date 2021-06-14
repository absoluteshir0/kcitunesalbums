package sn.nino.kcitunesalbums.db

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import sn.nino.kcitunesalbums.api.Results
import java.text.SimpleDateFormat
import java.util.*

// the table and columns to be created
// in the SQlite database
// extends Parcelable for passing object data through activities
@Entity(tableName = "user_session")
data class Session(
    @PrimaryKey(autoGenerate = false) val id: Int,
    @ColumnInfo(name = "Date") val date: String?,
    @ColumnInfo(name = "LastViewedActivity") val lastViewedActivity: String?,
    @ColumnInfo(name = "LastViewedAlbum") val lastViewedAlbum: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(date)
        parcel.writeString(lastViewedActivity)
        parcel.writeString(lastViewedAlbum)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Session> {
        override fun createFromParcel(parcel: Parcel): Session {
            return Session(parcel)
        }

        override fun newArray(size: Int): Array<Session?> {
            return arrayOfNulls(size)
        }
    }
}
