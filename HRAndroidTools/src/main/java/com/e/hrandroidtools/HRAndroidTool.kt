package com.e.hrandroidtools

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class HRAndroidTool() {

      companion object{
          fun withEditText(context: Context,title:String,positiveButtonText:String) {
              val builder = AlertDialog.Builder(context)
              val inflater:LayoutInflater= LayoutInflater.from(context)
              builder.setTitle(title)
              val dialogLayout = inflater.inflate(R.layout.edit_item, null)
              val editText  = dialogLayout.findViewById<EditText>(R.id.editText)
              builder.setView(dialogLayout)
              builder.setPositiveButton(positiveButtonText) { dialogInterface, i -> Toast.makeText(context,editText.text.toString(), Toast.LENGTH_SHORT).show() }
              builder.show()
          }

            fun withItems(context: Context, array: Array<String>,title: String) {
                val items =array
                val builder = AlertDialog.Builder(context,R.style.CustomAlertDialog)
                with(builder)
                {
                    setTitle(title)
                    setItems(items) { dialog, which ->
                        Toast.makeText(context, items[which], Toast.LENGTH_SHORT).show()
                    }
                    show()
            }
        }
          fun seekBarList(context: Context,title1: Any,title2: Any,title3:Any,subTitle:Any){
              HRSeekBarDialog.withEditText(context,title1,title2,title3,subTitle)
          }



      }

}
