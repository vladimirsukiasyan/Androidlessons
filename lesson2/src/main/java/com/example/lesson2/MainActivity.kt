package com.example.lesson2

import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.parcelize.Parcelize

@Parcelize
data class State(val static_code:Int) : Parcelable

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var state: State

    companion object {
        private val TEXT_VIEW = "TextView"
        private val STATE = "State"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TAG", "onCreate ${this.localClassName}")
//        Singleton.context = this
//
//        textView = findViewById(R.id.textView)
//        state = State(200)
//
//        findViewById<Button>(R.id.button).setOnClickListener {
//            textView.text = "Bye, World!"
//        }

        supportFragmentManager.beginTransaction()
            .add(BlankFragment)

    }

    override fun onDestroy() {
        Log.d("TAG", "onDestroy ${this.localClassName}")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(TEXT_VIEW, textView.text.toString())
        outState.putParcelable(STATE, state)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        textView.text = savedInstanceState?.getString(TEXT_VIEW, "opps..")
        val state = savedInstanceState?.getParcelable<State>(STATE)
        super.onRestoreInstanceState(savedInstanceState, persistentState)
    }
}

//object Singleton {
//    var context: Context? = null
//}