package com.augustasoftsol.saravanan

import android.util.Log

class CompanionObjClass {

    companion object {

        lateinit var objVal:String




        fun getObj(float: Float):Int{
            return float.toInt()
        }


        fun setVarVal(str:Any){

          objVal= str as String


            Log.v("Obj Val", objVal)
        }
    }
}