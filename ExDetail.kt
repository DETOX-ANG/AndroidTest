package com.example.arocha2.kotlin.feature

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.ex_detail_activity.*
import java.io.Serializable

class ExDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ex_detail_activity)

        var exex: Expense = intent.extras.getSerializable("EX") as Expense



        textView.text = exex.desc
        textView2.text = exex.value.toString()
    }
}
