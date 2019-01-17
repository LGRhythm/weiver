package com.rhythm.rwv.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rhythm.rwv.R
import com.rhythm.rwv.dal.AppDatabase
import com.rhythm.rwv.databinding.ActivityArticleBinding
import com.rhythm.rwv.repository.ArticleRepo
import com.rhythm.rwv.service.ArticleService
import com.rhythm.rwv.viewmodel.ArticleViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ArticleActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityArticleBinding
    lateinit var mViewModel: ArticleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_article)

        val service = Retrofit.Builder()
            .baseUrl("http://api.jcodecraeer.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ArticleService::class.java)

        val local = AppDatabase.getInstance(applicationContext).articleDao()

        val repo = ArticleRepo(service, local)

        mViewModel = ArticleViewModel(repo)

        mBinding.vm = mViewModel
    }

}