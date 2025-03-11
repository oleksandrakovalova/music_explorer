package com.okproject.musicexplorer.ui.component

import android.os.Parcel
import android.os.Parcelable


data class ChipItem(
    val id: String,
    val label: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(label)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChipItem> {
        override fun createFromParcel(parcel: Parcel): ChipItem {
            return ChipItem(parcel)
        }

        override fun newArray(size: Int): Array<ChipItem?> {
            return arrayOfNulls(size)
        }
    }
}
