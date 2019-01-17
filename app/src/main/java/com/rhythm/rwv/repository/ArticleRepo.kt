package com.rhythm.rwv.repository

import com.rhythm.rwv.dal.dao.ArticleDao
import com.rhythm.rwv.service.ArticleService

class ArticleRepo constructor(private val service: ArticleService, private val local: ArticleDao) {

    fun getArticleDetail(id: Int) = local.getArticleById(id)
        .onErrorResumeNext {
            service.getArticleDetail(id)
                .doOnSuccess {
                    local.insertArticle(it)
                }
        }
}