package com.e.activityLibrary

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.e.activityLibrary.databinding.ActivityMainBinding
import com.e.hrandroidtools.HRAndroidTool

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context
    private  var array=arrayOf("Red", "Orange", "Yellow", "Blue")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        context=this
        initView()
    }

    private fun initView() {
        binding.btnAlertWithEditText.setOnClickListener(this)
        binding.btnItem.setOnClickListener(this)
        binding.seekBar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
       when(p0?.id){
           R.id.btnAlertWithEditText->{
               HRAndroidTool.withEditText(context,"Enter Name","ok")
           }R.id.btnItem->{
               HRAndroidTool.withItems(context,array,"List of Item")
           }R.id.seek_bar->{
               HRAndroidTool.seekBarList(context,"Red","Green","Blue","%")
           }

       }
    }


}