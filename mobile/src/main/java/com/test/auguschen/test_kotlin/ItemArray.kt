package com.test.auguschen.test_kotlin

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ItemArray (context: Context,
                 private val resource: Int,
                 private val items: MutableList<Item>?): ArrayAdapter<Item>(context, resource, items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val item = getItem(position)
        var new_view : View? = null
        if(convertView == null){
            new_view = LayoutInflater.from(context).inflate(R.layout.test, null)
        }else{
            new_view = convertView
        }
        val item_id : TextView = new_view?.findViewById(R.id.item_id)!!
        val start_time_tx : TextView = new_view?.findViewById(R.id.start_time_tx)
        val end_time_tx : TextView = new_view?.findViewById(R.id.end_time_tx)
        val weeks_tx : TextView = new_view?.findViewById(R.id.weeks_tx)
        val model_tx : TextView = new_view?.findViewById(R.id.model_tx)

        item_id.text = item.name
        start_time_tx.text = item.start_time
        end_time_tx.text = item.end_time
        weeks_tx.text = item.weeks
        model_tx.text = item.model

        return new_view!!
    }
}