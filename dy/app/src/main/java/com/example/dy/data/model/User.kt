package com.example.dy.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*"data": {
    "birthday": null,
    "country": null,
    "gender": 0,
    "level": 0,
    "ip": "127.0.0.1",
    "sign": null,
    "focusCount": null,
    "likeCount": 0,
    "fansCount": 0,
    "avatar": null,
    "backgroundImg": null,
    "tel": 0,
    "silence": 0,
    "email": "1802024110@qq.com",
    "username": "梦无念"
}*/
@Entity
data class User (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "create_time") val createTime: String,
    @ColumnInfo(name = "update_time") val updateTime: String,

    )