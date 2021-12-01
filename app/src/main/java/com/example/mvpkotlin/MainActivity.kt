package com.example.mvpkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        val gameDataManagement=GameDataManagement()
        this.mPresenter = MainActivityPresenter(gameDataManagement)//mainactivitypresenter objesini oluşturdun.
        this.mPresenter.setView(this)
        this.mPresenter.created()//presenter objesine ekranın açıldığına dair bilgilendirelim.

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

    override fun initOnClick() {
        this.btnTry.setOnClickListener {
            this.mPresenter.onTryClick(etCharInput)
        }
        this.btnPlayAgain.setOnClickListener {
            this.mPresenter.onPlayAgainClick()
        }
        this.btnExit.setOnClickListener {
            this.mPresenter.onExitClick()
        }
    }

    override fun initGameView(currentWord: String, remainingLife: Int) {
        setGameLayoutVisibility(View.VISIBLE)
        setRemainingLifeVisibility(View.VISIBLE)
        setResultButtonLayoutVisibility(View.GONE)
        setSuccessfulMessageVisibility(View.GONE)
        setFailMessageVisibility(View.GONE)
        setRemainingLife(remainingLife)
        setCurrentWord(currentWord)
    }

    override fun setGameLayoutVisibility(visible: Int) {
           this.gameLayout.visibility=visible

    }

    override fun setRemainingLifeVisibility(visible: Int) {
            this.tvLife.visibility=visible
    }

    override fun setResultButtonLayoutVisibility(visibility: Int) {
            this.resultButtonLayout.visibility=visibility
    }

    override fun setSuccessfulMessageVisibility(visibility: Int) {
            this.tvSuccessfulMessage.visibility=visibility
    }

    override fun setFailMessageVisibility(visibility: Int) {
        this.tvFailedMessage.visibility=visibility
    }

    override fun setRemainingLife(life: Int) {
        this.tvLife.text = getString(R.string.remaining_life,life)
    }

    override fun setCurrentWord(currentWord: String) {
        this.tvWord.text=currentWord
    }

    override fun initInputArea(){
        this.etCharInput.setText("")
    }
}