package com.e.hrandroidtools

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.GONE
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.*

class HRSeekBarDialog
     {
    companion object :TextToSpeech.OnInitListener {

        private lateinit var countText: TextView
        private lateinit var seekBar: SeekBar
        private lateinit var seekBar1: SeekBar
        private lateinit var seekBar2: SeekBar
        private lateinit var status:TextView
        private lateinit var status1:TextView
        private lateinit var status2:TextView
        private  var tts: TextToSpeech?=null

        fun withEditText(context: Context,title1: Any,title2: Any,title3: Any,subTitle: Any) {
            val builder = AlertDialog.Builder(context, R.style.CustomAlertDialog)
            val inflater: LayoutInflater = LayoutInflater.from(context)
            val dialogLayout = inflater.inflate(R.layout.seek_bar_list, null)
            countText=dialogLayout.findViewById<TextView>(R.id.seekbarStatus)
            tts= TextToSpeech(context,this)
            status=dialogLayout.findViewById(R.id.progress)
            status1=dialogLayout.findViewById(R.id.progress1)
            status2=dialogLayout.findViewById(R.id.progress2)
            seekBar = dialogLayout.findViewById<SeekBar>(R.id.seekbar)
            seekBar1 = dialogLayout.findViewById<SeekBar>(R.id.seekbar1)
            seekBar2 = dialogLayout.findViewById<SeekBar>(R.id.seekbar2)

            builder.setView(dialogLayout)
            builder.show()

                countProgressSeekbar1(title1,subTitle)
                countProgressSeekbar2(title2,subTitle)
                countProgressSeekbar3(title3,subTitle)
        }

         fun countProgressSeekbar2(title2: Any,subTitle:Any) {
            seekBar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    countText.text = progress.toString().plus(subTitle)
                    speakOut(progress.toString().plus(subTitle))
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    status1.text=title2.toString()
                    status.visibility= GONE
                    status1.visibility=View.VISIBLE
                    status2.visibility=View.GONE

                }
                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    status.visibility= GONE
                    status1.visibility=View.VISIBLE
                    status2.visibility=View.GONE
                }
            })
        }

        fun countProgressSeekbar1(title1: Any, subTitle: Any){
            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    countText.text = progress.toString().plus(subTitle)
                    speakOut(progress.toString().plus(subTitle))
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    status.text=title1.toString()
                    status.visibility=View.VISIBLE
                    status1.visibility=View.GONE
                    status2.visibility=View.GONE

                }
                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    status.text=title1.toString()
                    status.visibility=View.VISIBLE
                    status1.visibility=View.GONE
                    status2.visibility=View.GONE
                }
            })
        }

        fun countProgressSeekbar3(title3:Any,subTitle: Any){
            seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    countText.text = progress.toString().plus(subTitle)
                    speakOut(progress.toString().plus(subTitle))
                }
                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    status2.text=title3.toString()
                    status2.visibility=View.VISIBLE
                    status.visibility=View.GONE
                    status1.visibility=View.GONE
                }
                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    status2.text=title3.toString()
                    status.visibility=View.GONE
                    status1.visibility=View.GONE
                    status2.visibility=View.VISIBLE
                }
            })
        }
        override fun onInit(p0: Int) {
            if (p0 == TextToSpeech.SUCCESS) {
                val result = tts!!.setLanguage(Locale.US)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS","The Language specified is not supported!")
                } else {
                   // binding.buttonSpeak.isEnabled = true
                }
            } else {
                Log.e("TTS", "Initilization Failed!")
            }
        }

        fun speakOut(countDownTimer: Any) {
            val text = countDownTimer
            tts?.speak(text.toString(), TextToSpeech.QUEUE_FLUSH, null,"")
        }

    }


}