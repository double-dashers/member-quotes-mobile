package com.example.dasherquotes.quotes.model

data class Quotes(
    val id: Int,
    val author: String,
    val content: String,
    val date: String,
    val created_at: String,
    val updated_at: String
)