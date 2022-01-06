package uz.pdp.listunderthehood

import android.os.Parcel
import android.os.Parcelable

data class Laptop(

    val image: Int,
    val title: String?,
    val description: String?

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(title)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Laptop> {
        override fun createFromParcel(parcel: Parcel): Laptop {
            return Laptop(parcel)
        }

        override fun newArray(size: Int): Array<Laptop?> {
            return arrayOfNulls(size)
        }
    }
}
