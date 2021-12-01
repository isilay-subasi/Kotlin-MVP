package com.example.mvpkotlin

import android.text.TextUtils
import androidx.appcompat.widget.AppCompatEditText

class MainActivityPresenter(gameDataManagement: GameDataManagement) : MainActivityContract.Presenter{

    //View ile işlem göreceğim için, m global değişken olduğunu göstermek için
    private lateinit var mView : MainActivityContract.View

    private var mGameDataManagement =gameDataManagement

    override fun setView(view: MainActivityContract.View) {

        this.mView = view


    }

    override fun created() {
        this.mView.bindViews()
        this.mView.initOnClick()

        this.prepareViewForGame()
    }
    private fun prepareViewForGame(){
        this.mGameDataManagement.initGameData()
        this.mView.initGameView(this.mGameDataManagement.getCurrentWord(),
            this.mGameDataManagement.getRemainingLife())

        this.mView.initInputArea()
    }


    override fun onTryClick(etCharInput: AppCompatEditText) {

        val strLetter = etCharInput.text?.toString()?.trim()
        if(!strLetter.isNullOrEmpty() && this.mGameDataManagement.isInputLetter(strLetter)){
            this.mView.initInputArea()
            this.mGameDataManagement.clearPositionList()
            this.mGameDataManagement.checkIsWordContainsLetter(strLetter)

            if (mGameDataManagement.getPositionListArray().isNotEmpty()){
                this.mGameDataManagement.changeCurrentWord(strLetter)
                this.mView.setCurrentWord(this.mGameDataManagement.getCurrentWord())
                if (!this.mGameDataManagement.isThereAnyUnderScore()){
                    this.mView.initSuccesfulView()
                    this.mView.initResultButtonLayout()
                }
            }
            else{
                val remaininingLife = this.mGameDataManagement.getDecreasedRemainingLife()
                this.mView.setRemainingLife(remaininingLife)
                if (remaininingLife == 0){
                    this.mView.initFailView()
                    this.mView.initResultButtonLayout()
                }
            }
        }else{
            mView.showPleaseEnterALetterMessage()
        }


    }

    override fun onPlayAgainClick() {

        this.prepareViewForGame()
    }

    override fun onExitClick() {
        this.mView.finishActivity()
    }
}