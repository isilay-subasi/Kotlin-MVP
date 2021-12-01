package com.example.mvpkotlin

import androidx.appcompat.widget.AppCompatEditText

//Anlaşma sınıfımı interface olarak açıyorum. Birbirleri üzerinden haberleşmeleri için interface yapıyorum.
interface MainActivityContract {
    //Anlaşmanın iki tarafını da interface olarak ekliyorum.

    interface View{
        fun bindViews()
        fun initOnClick()
        fun initGameView(currentWord: String, remainingLife: Int)
        fun setGameLayoutVisibility(visible: Int)
        fun setRemainingLifeVisibility(visible: Int)
        fun setResultButtonLayoutVisibility(visibility: Int)
        fun setSuccessfulMessageVisibility(visibility: Int)
        fun setFailMessageVisibility(visibility: Int)
        fun setRemainingLife(life: Int)
        fun setCurrentWord(currentWord: String)
        fun initInputArea()
        fun initSuccesfulView()
        fun initResultButtonLayout()
        fun initFailView()
        fun showPleaseEnterALetterMessage()
        fun showToastMessage()
        fun finishActivity()


    }

    interface Presenter{

        //Presenter tarafının view'ı tanıması için aşağıdaki fun oluşturuyorum.
        fun setView(view: View)//Bu şekilde ilişkilendirmiş oluyorum.


        fun created()
        abstract fun onTryClick(etCharInput: AppCompatEditText)
        fun onPlayAgainClick()
        fun onExitClick()

    }

}