package com.example.mvpkotlin

import android.text.TextUtils

class GameDataManagement {

    private val wordList= arrayListOf("aslan","kaplan","kedi","ahtapot")
    private var remainingLife = 0 // kalan can
    private var currentWordCharArray = ArrayList<String>()
    private var positionList=ArrayList<Int>()// kullanıcı hangi indexdeki harfi buldu
    private var chosedWord = ""//hangi kelimeyi biz ona göstericez

    //uygulama açılır açılmaz bu fonksiyon çalışacak
    /*
        1- bir kelimeyi seçicem, random bir kelimeyi alıyorum
        2-Kullanıcıya boş bir ekran göstereceğim için clear ile temziliyorum(tire tire gibi ekranı göstericem)
        3-5 can tanımlıyorum.
        4- 0dan başlayarak bir for döngüsü oluşturacağım.Seçilen kelimenin boyutuna kadar _
     */
    fun initGameData(){

        this.chosedWord=wordList.random()
        this.currentWordCharArray.clear()
        this.remainingLife=5

        for (index in 0 until chosedWord.length){
            this.currentWordCharArray.add("_")

        }

    }

    //Ekrana basmak için kullanıyorum
    fun getCurrentWord() : String{
        return TextUtils.join(" ",currentWordCharArray)

    }

    //Kullanıcının kalan canını görmek için
    fun getRemainingLife() : Int{
        return  remainingLife
    }

    //Kullanıcının hangi indexlerini bildiğini tuttuğum listeyi sıfırlamam gerekli
    fun clearPositionList(){
        this.positionList.clear()
    }

    //Benim kelimem kullanıcının girdiği harfi içeriyor mu içermiyor mu ?
    /*

     */
    fun checkIsWordContainsLetter(letter : String){

        for (index in 0 until chosedWord.length){
            val currentLetter = chosedWord[index]//sahip olduğum harf
            if (currentLetter.toString() == letter){
                positionList.add(index)//Eğer eşitse hangi indexteki harfi bildi ?
                //onu pozisyon listemize ekliyoruz.indeximizi ekliyoruz.
            }

        }

    }

    //positionlisti döndürüyoruz.
    fun getPositionListArray() : ArrayList<Int>{
        return this.positionList
    }

    //kullanıcı yanlış harf girerse kalan canı düşürmemiz gerekli
    //Hem düşürme işlemimi yapacağım hem de ekranda göstereceğim , presenters dönme işlemini yapacağım
    fun getDecreasedRemainingLife() : Int{
        remainingLife -= 1
        return this.getRemainingLife()
    }

    //underscore var mı yok mu ?
    fun isThereAnyUnderScore() : Boolean{
        return currentWordCharArray.contains("_")
    }


    fun changeCurrentWord(letter : String){
        for (index in positionList){
            currentWordCharArray[index] = letter
        }
    }

}