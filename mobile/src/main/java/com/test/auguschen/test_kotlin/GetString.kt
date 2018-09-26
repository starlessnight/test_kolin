package com.test.auguschen.test_kotlin

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

class GetString : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        test();
    }

    private fun test(){
        var test = getString(R.string.www)
    }
}
