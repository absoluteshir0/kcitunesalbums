package sn.nino.kcitunesalbums.api

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import org.json.JSONObject
// parsed and stored in this object are [results]
// arraylist of album data from the api response
// extends Parcelable for passing object data through activities
data class Results(
    @field:Json(name = "wrapperType") val wrapperType: String?,
    @field:Json(name = "kind") val kind: String?,
    @field:Json(name = "collectionId") val collectionId: Int?,
    @field:Json(name = "trackId") val trackId: Int?,
    @field:Json(name = "artistName") val artistName: String?,
    @field:Json(name = "collectionName") val collectionName: String?,
    @field:Json(name = "trackName") val trackName: String?,
    @field:Json(name = "collectionCensoredName") val collectionCensoredName: String?,
    @field:Json(name = "trackCensoredName") val trackCensoredName: String?,
    @field:Json(name = "collectionArtistId") val collectionArtistId: Int?,
    @field:Json(name = "collectionArtistViewUrl") val collectionArtistViewUrl: String?,
    @field:Json(name = "collectionViewUrl") val collectionViewUrl: String?,
    @field:Json(name = "trackViewUrl") val trackViewUrl: String?,
    @field:Json(name = "previewUrl") val previewUrl: String?,
    @field:Json(name = "artworkUrl30") val artworkUrl30: String?,
    @field:Json(name = "artworkUrl60") val artworkUrl60: String?,
    @field:Json(name = "artworkUrl100") val artworkUrl100: String?,
    @field:Json(name = "collectionPrice") val collectionPrice: Float?,
    @field:Json(name = "trackPrice") val trackPrice: Float?,
    @field:Json(name = "trackRentalPrice") val trackRentalPrice: Float?,
    @field:Json(name = "collectionHdPrice") val collectionHdPrice: Float?,
    @field:Json(name = "trackHdPrice") val trackHdPrice: Float?,
    @field:Json(name = "trackHdRentalPrice") val trackHdRentalPrice: Float?,
    @field:Json(name = "releaseDate") val releaseDate: String?,
    @field:Json(name = "collectionExplicitness") val collectionExplicitness: String?,
    @field:Json(name = "trackExplicitness") val trackExplicitness: String?,
    @field:Json(name = "discCount") val discCount: Int?,
    @field:Json(name = "discNumber") val discNumber: Int?,
    @field:Json(name = "trackCount") val trackCount: Int?,
    @field:Json(name = "trackNumber") val trackNumber: Int?,
    @field:Json(name = "trackTimeMillis") val trackTimeMillis: Long?,
    @field:Json(name = "country") val country: String?,
    @field:Json(name = "currency") val currency: String?,
    @field:Json(name = "primaryGenreName") val primaryGenreName: String?,
    @field:Json(name = "contentAdvisoryRating") val contentAdvisoryRating: String?,
    @field:Json(name = "shortDescription") val shortDescription: String?,
    @field:Json(name = "longDescription") val longDescription: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "hasITunesExtras") val hasITunesExtras: Boolean?
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(wrapperType)
        parcel.writeString(kind)
        parcel.writeValue(collectionId)
        parcel.writeValue(trackId)
        parcel.writeString(artistName)
        parcel.writeString(collectionName)
        parcel.writeString(trackName)
        parcel.writeString(collectionCensoredName)
        parcel.writeString(trackCensoredName)
        parcel.writeValue(collectionArtistId)
        parcel.writeString(collectionArtistViewUrl)
        parcel.writeString(collectionViewUrl)
        parcel.writeString(trackViewUrl)
        parcel.writeString(previewUrl)
        parcel.writeString(artworkUrl30)
        parcel.writeString(artworkUrl60)
        parcel.writeString(artworkUrl100)
        parcel.writeValue(collectionPrice)
        parcel.writeValue(trackPrice)
        parcel.writeValue(trackRentalPrice)
        parcel.writeValue(collectionHdPrice)
        parcel.writeValue(trackHdPrice)
        parcel.writeValue(trackHdRentalPrice)
        parcel.writeString(releaseDate)
        parcel.writeString(collectionExplicitness)
        parcel.writeString(trackExplicitness)
        parcel.writeValue(discCount)
        parcel.writeValue(discNumber)
        parcel.writeValue(trackCount)
        parcel.writeValue(trackNumber)
        parcel.writeValue(trackTimeMillis)
        parcel.writeString(country)
        parcel.writeString(currency)
        parcel.writeString(primaryGenreName)
        parcel.writeString(contentAdvisoryRating)
        parcel.writeString(shortDescription)
        parcel.writeString(longDescription)
        parcel.writeString(description)
        parcel.writeValue(hasITunesExtras)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Results> {
        override fun createFromParcel(parcel: Parcel): Results {
            return Results(parcel)
        }

        override fun newArray(size: Int): Array<Results?> {
            return arrayOfNulls(size)
        }
    }
}
