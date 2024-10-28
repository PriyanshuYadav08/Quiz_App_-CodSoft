package com.example.quizapp.utils

object colorpicker {
    val color = arrayOf(
        "#EC2222",
        "#68EC22",
        "#22ACEC",
        "#9322EC",
        "#EC228A",
        "#ECE922",
        "#22DDEC"
    )
    var currentcolorindex = 0
    fun getcolor(): String {
        currentcolorindex = (currentcolorindex + 1) % color.size
        return color[currentcolorindex]
    }
}