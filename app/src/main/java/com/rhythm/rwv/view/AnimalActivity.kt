package com.rhythm.rwv.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rhythm.rwv.R
import com.rhythm.rwv.databinding.ActivityAnimalBinding
import com.rhythm.rwv.model.Animal
import com.rhythm.rwv.viewmodel.AnimalViewModel

class AnimalActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityAnimalBinding
    lateinit var mViewModel: AnimalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_animal)
        val animal = Animal("狗", 0)
        mViewModel = AnimalViewModel(animal)
        mBinding.vm = mViewModel
    }
}