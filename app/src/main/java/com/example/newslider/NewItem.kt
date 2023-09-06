package com.example.newslider

import android.os.Parcel
import android.os.Parcelable

data class NewItem(val titleImage: Int, val title: String, val article: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(titleImage)
        parcel.writeString(title)
        parcel.writeString(article)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewItem> {
        override fun createFromParcel(parcel: Parcel): NewItem {
            return NewItem(parcel)
        }

        override fun newArray(size: Int): Array<NewItem?> {
            return arrayOfNulls(size)
        }
    }
}

