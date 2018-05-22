package com.augustasoftsol.saravanan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View


// Class extends the AppCompatActivity using ":" Symbol . Class declared default visibility modifier : public
class MainActivity : AppCompatActivity() {


    //Declare Variable - using 'var' or 'val' keyword

    /**
     * Val(Immutable reference) - cannot be changed once the value is assigned, Like final variable in java
     *
     * Var (Mutable reference) - variable changed later like normal variable in java
     *
     * Variable with/without data type
     *
     * Kotlin understand what data is initialized - "type inference"
     */
    val stringVar = "Hello World"
    var intVar = 12
    var floatVar = 10f


    //Variable with data types
    var typeInt : Int =12
    var typeString: String ="Hai"
    var typeFloat : Float =12f
    val typeValFloat : Float =12f


    //Null and Not Variable
    //Int? - allows null
    var allByDefault: Int? =0  // error: explicit initializer required, default getter and setter implied
    var strNullVal :String ?=null


    /**
     * Variable with String allocation
     */
    var a = 1
    // simple name in template:
    val s1 = "a is $a"

    val len = "a is $a".length

    val getValue ="a is $a".get(3)



    //Call method on variable set value
    var s2 : String
        get() = this.toString()
        set(value) {
            varGetSetVariable(value)
        }


    //Directly call the function
    var callFunction =returnValue()


    //Declare Method - declare with "fun" keyword for declare method

    /* Override the onCreate from AppCompatActivity

       Bundle - variable savedInstanceState with null pointer exception check
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        typeFloat= 10f


        //Call method when set value of variable
        s2="HelloAndroid"
        //typeValFloat=15f  // Can't be reassigned because val


        //Call method
        addValue()

        //Call method with return
        Log.v("Return Value :",returnValue().toString())



        //Print null if allByDefault is null
        println(strNullVal?.length)

        //Check null and print
        println(strNullVal?.length ?:-1)

        //Print 3
        strNullVal="HAI"
        println(strNullVal?.length)


        //Print length after allocation
        allByDefault=10
        var len =allByDefault.toString()
        println(len?.length)


        //allByDefault!! - If value is null it through null pointer exception
        passByReturn(floatVar,allByDefault!!)


        //Get a value from variable (Char)
        Log.v("Getter value",getValue.toString())

        //Print values using $ symbols
        printValues(10,20f,"Hi",100f)
        printValues(10,20f,"Hi","String")

        //Default arguments
        defaultArgument(10)
        defaultArgument(10,"default",99f)


        //Static Or Singleton = Object

        var objClass = ObjClass

        //Call via instance of obj
        objClass.callObjValue()
        val mutableList : MutableList<String> = mutableListOf()
        mutableList.add("Mutable")
        mutableList.add("Kotlin")
        mutableList.add("Java")
        mutableList.add("XML")

        //Or else call via Directly with Object name like static class
        ObjClass.callforLoop(mutableList)


        //Companion Object - access type 1

        Log.v("Companion",CompanionObjClass.getObj(20f).toString())
        //Companion Object - access type 2

        CompanionObjClass.Companion.setVarVal(300)


    }

    //Define the function

    /*
    * Function with argument
    */
    fun varGetSetVariable(value: String?)
    {
        Log.v("GeteSetVariable :",value)
    }


    fun addValue(){
        //toString - type conversion
        Log.v("AddValue :", (intVar+typeInt).toString())
    }


    fun returnValue():Float{
        return floatVar+typeFloat
    }

    fun passByReturn(a:Float,b:Int){

        Log.v("AddValue :", (a.toInt()+ b).toString())
    }


    // as and is -keywords

    fun printValues(a:Int,b:Float,c:String ,d:Any){

        Log.v("Int","Int $a")
        Log.v("Float","Float $b")
        Log.v("String","String $c")

        val aInt: Int? = a as? Int
        Log.v("A is Int","Int $aInt")

        if(d is String) {
            Log.v("d is String ", "length ${d.length}")

        }else if (d !is Int){
            Log.v("d is Float ", "Float $d")
        }
    }

    //Default Arguments
    fun defaultArgument(a:Int,str:String="Hello",any:Any=str.length){

        Log.v("Default Arguments :","a:$a string $str Any $any")
    }

    //Function with in the function
    fun funWithInfun(className:String,intent: Intent){

        fun callActivity(intent:Intent?){

            intent!!.putExtra("from",className)
            startActivity(intent)
        }

        callActivity(intent)
    }




    //Button Click Listener

    fun flowView(view: View){
        val intent = Intent(this, FlowInterfacesSealed::class.java)
        funWithInfun(MainActivity::class.java.canonicalName,intent)
    }






}
