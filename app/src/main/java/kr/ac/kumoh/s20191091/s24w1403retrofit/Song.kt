package kr.ac.kumoh.s20191091.s24w1403retrofit

data class Song(
    val id: Int,
    val title: String,
    val singer: String,
    val rating: Int,
    val lyrics: String?
)