package com.example.mvpkotlin

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

    }


    override fun onTryClick(etCharInput: AppCompatEditText) {

        val strLetter = etCharInput.text?.toString()?.trim()
        strLetter?.let {
            this.mView.initInputArea()
            this.mGameDataManagement.clearPositionList()
            this.mGameDataManagement.checkIsWordContainsLetter(it)

            if (mGameDataManagement.getPositionListArray().isNotEmpty()){
                this.mGameDataManagement.changeCurrentWord(it)
                this.mView.setCurrentWord(this.mGameDataManagement.getCurrentWord())
            }
        }


    }

    override fun onPlayAgainClick() {

    }

    override fun onExitClick() {

    }
}