package com.example.quizapp.models

data class questions(
    var description: String = "",
    var option1: String = "",
    var option2: String = "",
    var option3: String = "",
    var option4: String = "",
    var answer: String = "",
    var user_answer: String = ""
)