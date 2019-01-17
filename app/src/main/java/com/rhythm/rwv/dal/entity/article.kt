package com.rhythm.rwv.dal.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "articles")
class Article(var title: String?) {

    @PrimaryKey
    @ColumnInfo(name = "articleid")
    var id: Int = 0
    var content: String? = null
    var readme: String? = null
    @SerializedName("describe")
    var description: String? = null
    var click: Int = 0
    var channel: Int = 0
    var comments: Int = 0
    var stow: Int = 0
    var upvote: Int = 0
    var downvote: Int = 0
    var url: String? = null
    var pubDate: String? = null
    var thumbnail: String? = null

    override fun toString(): String {
        return "Article(title=$title, id=$id, content=$content, readme=$readme, description=$description, click=$click, channel=$channel, comments=$comments, stow=$stow, upvote=$upvote, downvote=$downvote, url=$url, pubDate=$pubDate, thumbnail=$thumbnail)"
    }


}