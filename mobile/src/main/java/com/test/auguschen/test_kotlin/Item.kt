package com.test.auguschen.test_kotlin

import java.io.Serializable

class Item : Serializable {
    var Id : Int = 0
    var name : String = ""
    var start_time : String = ""
    var end_time : String = ""
    var weeks : String = ""
    var model : String = ""

    constructor(id : Int, name : String, start_time : String, end_time : String, weeks : String, model : String){
        this.Id = id
        this.name = name
        this.start_time = start_time
        this.end_time = end_time
        this.weeks = weeks
        this.model = model
    }
}