package com.sachualex.ageinminutes

import android.accounts.AccountManager.get
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker= findViewById(R.id.btnDatePicker) as Button
        btnDatePicker.setOnClickListener {view->
            clickDatePicker(view)
        }
    }
    fun clickDatePicker(view : View){
        val myCalender = Calendar.getInstance()
        val year  = myCalender.get(Calendar.YEAR)
        val month  = myCalender.get(Calendar.MONTH)
        val day  = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->Toast.makeText(this,"Date is $selectedDayOfMonth-${selectedMonth+1}-$selectedYear",Toast.LENGTH_LONG).show()

        val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
            val tvSelectedDate= findViewById(R.id.tvSelectedDate) as TextView
            tvSelectedDate.setText(selectedDate)

            val sdf= SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate =sdf.parse(selectedDate)

            /*
            val currentYear  = Calendar.getInstance().get(Calendar.YEAR);

            val age  ="Your age is ${currentYear-selectedYear}"

            val idSelectedDateInMinutes= findViewById(R.id.idSelectedDateInMinutes) as TextView
            Toast.makeText(this,"Your age is $age",Toast.LENGTH_LONG).show()
            idSelectedDateInMinutes.setText(age)
           // idSelectedDateInMinutes.setText(age)*/

            val selectedDateToMinutes = theDate!!.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateToMinutes = currentDate!!.time / 60000

            val differenceInMinutes = currentDateToMinutes - selectedDateToMinutes

            val tvSelectedDateInMinutes = findViewById(R.id.tvSelectedDateInMinutes) as TextView
            tvSelectedDateInMinutes.setText(differenceInMinutes.toString())
        }, year, month, day).show()
    }
}