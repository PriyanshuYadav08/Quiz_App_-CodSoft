package com.example.quizapp.utils

import com.example.quizapp.R

object iconpicker {
    val icons = arrayOf(
        R.drawable.icon_1,
        R.drawable.icon_2,
        R.drawable.icon_3,
        R.drawable.icon_4,
        R.drawable.icon_5,
        R.drawable.icon_6
    )
    var currenticonindex = 0
    fun getcolor(): Int {
        currenticonindex = (currenticonindex + 1) % icons.size
        return icons[currenticonindex]
    }
}