package com.example.lesson3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(DetailsActivity.TAG, "onCreate() ${this.localClassName}")

        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            findViewById<TextView>(R.id.counter).text = "We went to DetailsActivity! I'll be back."

            Thread {
                Thread.sleep(2000)
                val intent = Intent(this, DetailsActivity::class.java)
                startActivity(intent)
            }.start()
        }
        parent

    }

    override fun onStart() {
        Log.d(DetailsActivity.TAG, "onStart() ${this.localClassName}")
        super.onStart()
    }

    override fun onResume() {
        Log.d(DetailsActivity.TAG, "onResume() ${this.localClassName}")

        super.onResume()
    }

    override fun onPause() {
        Log.d(DetailsActivity.TAG, "onPause() ${this.localClassName}")

        super.onPause()
    }

    override fun onStop() {
        Log.d(DetailsActivity.TAG, "onStop() ${this.localClassName}")

        super.onStop()
    }

    override fun onDestroy() {
        Log.d(DetailsActivity.TAG, "onDestroy() ${this.localClassName}")

        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(DetailsActivity.TAG, "onSaveInstanceState() ${this.localClassName}")

    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(DetailsActivity.TAG, "onRestoreInstanceState() ${this.localClassName}")
    }
}