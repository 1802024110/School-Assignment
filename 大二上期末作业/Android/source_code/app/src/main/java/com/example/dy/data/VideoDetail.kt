package com.example.dy.data

object DummyData {
    val reels = listOf<Reel>(
        Reel(
            id = 1,
            video = "https://api.007666.xyz/bilibili/video/url?id=BV1xa411Y7zm",
            userImage = "https://generated.photos/vue-static/home/hero/4.png",
            userName = "Farhan Roy",
            isLiked = true,
            likesCount = 778,
            commentsCount = 156,
            comment = "Wkwkwk..."
        ),
        Reel(
            id = 1,
            video = "https://api.007666.xyz/bilibili/video/url?id=BV1bi4y117bR",
            userImage = "https://generated.photos/vue-static/home/hero/4.png",
            userName = "Farhan Roy",
            isLiked = true,
            likesCount = 778,
            commentsCount = 156,
            comment = "Wkwkwk..."
        ),
        Reel(
            id = 1,
            video = "https://api.007666.xyz/bilibili/video/url?id=BV1tr4y1x7Qk",
            userImage = "https://generated.photos/vue-static/home/hero/4.png",
            userName = "Farhan Roy",
            isLiked = true,
            likesCount = 778,
            commentsCount = 156,
            comment = "Wkwkwk..."
        ),
        Reel(
            id = 2,
            video = "https://api.007666.xyz/bilibili/video/url?id=BV1nz4y1Q7UJ",
            userImage = "https://generated.photos/vue-static/home/hero/7.png",
            userName = "Muhammad Ali",
            isLiked = true,
            likesCount = 5923,
            commentsCount = 11,
            comment = "Awas kamu ya klo pergi"
        ),
        Reel(
            id = 3,
            video = "https://api.007666.xyz/bilibili/video/url?id=BV1Hh411C75t",
            userImage = "https://generated.photos/vue-static/home/hero/3.png",
            userName = "Christian Juned",
            isLiked = true,
            likesCount = 2314,
            comment = "Es krim dingin sedapp",
            commentsCount = 200
        )
    )
}

data class Reel(
    val id: Int,
    private val video: String,
    val userImage: String,
    val userName: String,
    val isLiked: Boolean = false,
    val likesCount: Int,
    val comment: String,
    val commentsCount: Int
) {
    fun getVideoUrl(): String {
        return video
    }
}