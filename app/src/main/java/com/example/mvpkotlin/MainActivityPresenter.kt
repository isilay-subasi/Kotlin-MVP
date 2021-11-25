package com.example.mvpkotlin

class MainActivityPresenter : MainActivityContract.Presenter{

    private lateinit var mView : MainActivityContract.View

    override fun setView(view: MainActivityContract.View) {

        this.mView = view


    }

    override fun created() {
        this.mView.bindViews()

    }
}