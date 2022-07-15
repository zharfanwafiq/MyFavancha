package com.zharfan.myfavancha.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Anime(
    var characterName: String = "",
    var characterPicture: String = "",
    var characterDescription: String = "",
    var characterAge: Int = 0
):Parcelable