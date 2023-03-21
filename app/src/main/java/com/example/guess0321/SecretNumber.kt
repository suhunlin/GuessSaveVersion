package com.example.guess0321

import android.content.res.Resources
import android.util.Log
import java.util.Random

class SecretNumber{
    val tag:String = SecretNumber::class.java.simpleName
    var secretRandom:Int
    var guessCount:Int = 0
    init{
        secretRandom = Random().nextInt(100) + 1
        Log.d(tag, "Secret number is $secretRandom")
    }

    fun verify(userInput:Int) = secretRandom - userInput

    fun verifyResult(r:Resources,userInput:Int):String{
        guessCount++
        if(verify(userInput)>0){
            return "Bigger!!!"
        }else if(verify(userInput)<0){
            return "Smaller!!!"
        }else{
            if(guessCount < 3){
                return "Excellent! The number is $secretRandom!!!"
            }else{
                return "You got it!!!"
            }
        }
    }

    fun resetAll(){
        guessCount = 0
        secretRandom = Random().nextInt(100) + 1
        Log.d(tag, "Reset secret number is $secretRandom")
    }
}