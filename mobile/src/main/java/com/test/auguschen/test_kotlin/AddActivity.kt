package com.test.auguschen.test_kotlin

import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_activity.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

class AddActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.add_activity)
        super.onCreate(savedInstanceState)

        initial()
        initial_timePicker(this)

    }

    private fun initial(){
        cancel_btn.setOnClickListener {
            if(!MainActivity.mainStatus.isFinishing){
                this.finish()
            }

        }
    }

    private fun initial_timePicker(context : Context){
        val cal_st = Calendar.getInstance()
        val cal_et = Calendar.getInstance()

        val timeSetListener_st = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            cal_st.set(Calendar.HOUR_OF_DAY,hourOfDay)
            cal_st.set(Calendar.MINUTE,minute)

            st_edit.setText(SimpleDateFormat("HH:mm").format(cal_st.time))
        }

        val timeSetListener_et = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            cal_et.set(Calendar.HOUR_OF_DAY,hourOfDay)
            cal_et.set(Calendar.MINUTE,minute)

            et_edit.setText(SimpleDateFormat("HH:mm").format(cal_et.time))
        }

        start_choose_btn.setOnClickListener {
            TimePickerDialog(context,timeSetListener_st,cal_st.get(Calendar.HOUR_OF_DAY),cal_st.get(Calendar.MINUTE),false).show()
        }

        end_choose_btn.setOnClickListener {
            TimePickerDialog(context,timeSetListener_et, cal_et.get(Calendar.HOUR_OF_DAY), cal_et.get(Calendar.MINUTE), false).show()
        }
    }
}