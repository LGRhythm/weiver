package com.rhythm.rwv.service

import com.rhythm.rwv.dal.entity.Article
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {

    @GET("article_detail.php")
    fun getArticleDetail(@Query("id") id: Int): Single<Article>
}