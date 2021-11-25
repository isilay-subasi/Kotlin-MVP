package com.example.mvpkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() , MainActivityContract.View{


    private lateinit var mPresenter : MainActivityPresenter

    private lateinit var tvLife : AppCompatTextView
    private lateinit var tvWord : AppCompatTextView
    private lateinit var etCharInput : AppCompatEditText
    private lateinit var btnTry : AppCompatButton
    private lateinit var gameLayout : LinearLayout
    private lateinit var tvSuccessfulMessage : AppCompatTextView
    private lateinit var tvFailedMessage : AppCompatTextView
    private lateinit var resultButtonLayout : RelativeLayout
    private lateinit var btnExit : AppCompatButton
    private lateinit var btnPlayAgain : AppCompatButton




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.mPresenter = MainActivityPresenter()
        this.mPresenter.setView(this)
        this.mPresenter.created()

    }

    override fun bindViews() {
        this.tvLife=findViewById(R.id.tv_life)
        this.tvWord=findViewById(R.id.tv_word)
        this.etCharInput=findViewById(R.id.et_char_input)
        this.btnTry=findViewById(R.id.btn_try)
        this.gameLayout=findViewById(R.id.ll_game)
        this.tvSuccessfulMessage=findViewById(R.id.tv_successful_message)
        this.tvFailedMessage=findViewById(R.id.tv_fail_message)
        this.resultButtonLayout=findViewById(R.id.rl_result_button)
        this.btnPlayAgain=findViewById(R.id.btn_play_again)
        this.btnExit=findViewById(R.id.btn_exit)

    }
}