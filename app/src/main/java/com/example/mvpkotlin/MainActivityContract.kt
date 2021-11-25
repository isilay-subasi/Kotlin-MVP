package com.example.mvpkotlin

interface MainActivityContract {

    interface View{
        fun bindViews()

    }

    interface Presenter{

        fun setView(view: View)
        fun created()

    }

}