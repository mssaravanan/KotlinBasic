package com.kotlin.saravanan

import android.util.Log

class CompanionObjClass {

    companion object {

        lateinit var objVal: String


        fun getObj(float: Float): Int {
            return float.toInt()
        }


        fun setVarVal(str: Any) {
            if (str is String) {
                objVal = str
            } else {
                objVal = str.toString()
            }


            Log.v("Obj Val", objVal)
        }
    }
}