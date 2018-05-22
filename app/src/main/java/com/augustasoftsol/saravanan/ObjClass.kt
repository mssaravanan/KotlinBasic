package com.augustasoftsol.saravanan

import android.util.Log
import java.util.ArrayList

object ObjClass {

    private var value: Int = 20

    internal fun callObjValue(): Int {

        return value
    }

    operator fun get(int: Int):Int{
        return int+1
    }

    fun callforLoop(listValues: MutableList<String>) {

        var intVal=ObjClass[1]
        Log.v("intVal", intVal.toString())

        for (i in 0..listValues.size - 1) {

            Log.v("callforLoop", listValues.get(i))
            when (listValues.size) {
                in 1..5 -> {

                    Log.v("when", listValues.get(i))
                }
            }



        }
    }

}