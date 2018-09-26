package com.test.auguschen.test_kotlin

import android.app.TimePickerDialog
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var www:String="asdad"
    var ttt:Int = 777
    var xxx:Array<String> = arrayOf("C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP")
    private lateinit var db : SQLiteDatabase

    private val items: ArrayList<Item> = ArrayList()
    private val items2: ArrayList<Item> = ArrayList()
    //private lateinit var item_list : ListView
    private var itemAdapter: ItemArray? = null
    companion object {
        public var mainStatus = MainActivity()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainStatus = this;
        //initial()
        //insert db data
        //MyData.Insertdate(this.applicationContext, db, "test3",123456, 321654, "日,一,二", 1)

        // get db data
        /*var get_data = MyData.selectALLData(db)

        // get db data from id
        //MyData.selectDataFromId(db, 1)

        setListData(get_data)

        //set item
        itemAdapter =  ItemArray(this, R.layout.test, items)
        //initial data
        data_item.adapter = itemAdapter*/

    }

    private fun initial(){

        //item_list = findViewById(R.id.data_item) as ListView
        db = MyData.getDatabase(this.applicationContext)

        /*test1.setOnClickListener{
            test1.text=test("55")
            test1.text = when_test(autoCompleteTextView1.text.toString())

        }

        btn_1.setOnClickListener{
            get_something()
        }*/
        //val intent = Intent(this,GetString ::class.java)
    }

    /***
     * @param get_data Cursor data
     */
    private fun setListData(get_data: Cursor){
        //set listview data
        while(!get_data.isAfterLast){
            items?.add(Item(get_data.getString(get_data.getColumnIndex("id")).toInt(),
                    get_data.getString(get_data.getColumnIndex("name")),
                    get_data.getString(get_data.getColumnIndex("start_time")),
                    get_data.getString(get_data.getColumnIndex("end_time")),
                    get_data.getString(get_data.getColumnIndex("weeks")),
                    get_data.getString(get_data.getColumnIndex("model"))))
            get_data.moveToNext()
        }
        // items?.add(Item(1,"測試", "10:00 上午", "12:00 下午","四", "震動"))
    }

    private fun test(){
        /*test1.text=test1.text.toString()+"asdadad"
       val apt = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,xxx)
       var myList: MutableList<String> = mutableListOf("C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP")
       myList.add("1011")
       var testsetes : ArrayAdapter<String> = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList)

       autoCompleteTextView1.setAdapter(testsetes)*/
        //autoCompleteTextView1.threshold.
        var tet = if(15<100) "987" else "666"
        Toast.makeText(this,tet,Toast.LENGTH_SHORT).show()
    }


    private fun test(str : String ):String{
        Toast.makeText(this,"test",Toast.LENGTH_SHORT).show()
        return str
    }
    /*private fun get_something() = when{
       /* autoCompleteTextView1.text.toString() == "987" ->  when_test2("123")
        else ->  when_test2(123)*/
    }*/


    private fun when_test(value : String):String{
        var vv = ""
        when(value){
            "123"-> vv = "first"
            "321"-> vv = "sencend"
            else -> vv = getString(R.string.asda)
        }
        return vv
    }

    private fun when_test2(value : Any):String{
        var vv = ""
        /*when(value){
            is String-> test1.text = "String"
            is Int -> test1.text = "Int"
            else -> test1.text = "1233333"
        }*/
        return vv
    }

     override fun onPause() {
        super.onPause()

    }

    override fun onResume() {
        super.onResume()
        initial()
        // get db data
        var get_data = MyData.selectALLData(db)

        setListData(get_data)

        //set item
        itemAdapter =  ItemArray(this, R.layout.test, items)
        //initial data
        data_item.adapter = itemAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.add_set -> {
                val intent = Intent()
                intent.setClass(this,AddActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    

    
}
