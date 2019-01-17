package com.rhythm.rwv.viewmodel

import android.databinding.ObservableField
import com.rhythm.rwv.dal.entity.Article
import com.rhythm.rwv.repository.ArticleRepo
import com.rhythm.rwv.service.ArticleService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ArticleViewModel(private val repo: ArticleRepo) {

    var articleDetail = ObservableField<String>()

    fun loadArticle() {
        repo.getArticleDetail(8773)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { article: Article? -> articleDetail.set(article?.toString()) },
                { error: Throwable? -> articleDetail.set(error?.message ?: "error") })
    }
}