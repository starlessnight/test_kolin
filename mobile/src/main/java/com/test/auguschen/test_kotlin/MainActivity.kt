package com.test.auguschen.test_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var www:String="asdad"
    var ttt:Int = 777
    var xxx:Array<String> = arrayOf("C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test1.text=test1.text.toString()+"asdadad"

        val apt = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,xxx)
        var myList: MutableList<String> = mutableListOf("C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP")
        myList.add("1011")
        var testsetes : ArrayAdapter<String> = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList)

        autoCompleteTextView1.setAdapter(testsetes)
        //autoCompleteTextView1.threshold.

        initial()
        var tet = if(15<100) "987" else "666"
        Toast.makeText(this,tet,Toast.LENGTH_SHORT).show()
    }

    private fun initial(){
        test1.setOnClickListener{
            test1.text=test("55")
            test1.text = when_test(autoCompleteTextView1.text.toString())

        }

        btn_1.setOnClickListener{
            get_something()
        }
    }
    private fun test(str : String ):String{
        Toast.makeText(this,"test",Toast.LENGTH_SHORT).show()
        return str
    }
    private fun get_something() = when{
        autoCompleteTextView1.text.toString() == "987" ->  when_test2("123")
        else ->  when_test2(123)
    }


    private fun when_test(value : String):String{
        var vv = ""
        when(value){
            "123"-> vv = "first"
            "321"-> vv = "sencend"
            else -> vv = "1233333"
        }
        return vv
    }

    private fun when_test2(value : Any):String{
        var vv = ""
        when(value){
            is String-> test1.text = "String"
            is Int -> test1.text = "Int"
            else -> test1.text = "1233333"
        }
        return vv
    }

     override fun onPause() {
        super.onPause()

    }

    override fun onResume() {
        super.onResume()

    }
}
