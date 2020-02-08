package com.example.brojslovima

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    /* kod za čitanje teksta */
    lateinit var textToSpeech : TextToSpeech
    lateinit var btn : Button
    lateinit var editText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWrite.setOnClickListener{
            val mojbroj : String = edtEntry.text.toString()
            val brojmoj : Int = mojbroj.toInt()
            val milion = brojmoj / 1000000
            val milionrijec : String
            val hiljada : Int = (brojmoj - (milion * 1000000))/1000
            val hiljadarijec : String
            val stotina : Int = brojmoj - (milion * 1000000)-(hiljada * 1000)
            val stotinarijec : String
            if (milion>0){
                milionrijec = CitajBroj(milion)+ getString(R.string.no_1000000)
            } else{
                milionrijec =""
            }
            if (hiljada>0){
                hiljadarijec = CitajBrojke(hiljada)+ getString(R.string.no_1000)
            } else{
                hiljadarijec =""
            }
            if (brojmoj>0){
                stotinarijec = CitajBroj(stotina)
            } else{
                stotinarijec =""
            }

            txtEntry.text = milionrijec + hiljadarijec + stotinarijec
        }

        /* kod za čitanje teksta */
        btn= findViewById<Button>(R.id.btnRead)
        editText= findViewById<EditText>(R.id.txtEntry)
        textToSpeech= TextToSpeech(this, this)
        btn.setOnClickListener {
            textToSpeechFunction()
        }

    }

    override fun onInit(status:Int){
        if(status==TextToSpeech.SUCCESS){
            var res : Int = textToSpeech.setLanguage(Locale.US)
            if(res == TextToSpeech.LANG_MISSING_DATA || res ==TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(applicationContext,R.string.word_1,Toast.LENGTH_SHORT).show()
            }
            else{
                btn.isEnabled = true
                textToSpeechFunction()
            }
        }
        else{
            Toast.makeText(applicationContext,R.string.word_2,Toast.LENGTH_SHORT).show()
        }
    }

    private fun textToSpeechFunction(){
        val strText = editText.text.toString()
        textToSpeech.speak(strText, TextToSpeech.QUEUE_FLUSH,null)
        Toast.makeText(applicationContext,strText,Toast.LENGTH_LONG).show()
    }

    override fun onDestroy(){
        if(textToSpeech!=null){
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroy()
    }
}
