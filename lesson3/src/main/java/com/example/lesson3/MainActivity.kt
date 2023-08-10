package com.example.lesson3

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {

    companion object {
        private const val CREATE_DOCUMENT = 1
        private const val CREATE_TELEGRAM_CHAT = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(DetailsActivity.TAG, "onCreate() ${this.localClassName}")

        setContentView(R.layout.activity_main)

//        findViewById<Button>(R.id.button).setOnClickListener {
//            findViewById<TextView>(R.id.counter).text = "We went to DetailsActivity! I'll be back."
//            Thread {
//                Thread.sleep(2000)
//
//                //explicit intent
//                val intent = Intent(this, DetailsActivity::class.java)
//                startActivity(intent)
//            }.start()
//        }

        //implicit intent
        // Create the text message with a string.
//        val textMessage = "hello"
//        val sendIntent = Intent().apply {
//            action = Intent.ACTION_SEND
//            putExtra(Intent.EXTRA_TEXT, textMessage)
//            type = "text/plain"
//        }
//
//        // Try to invoke the intent.
//        try {
//            startActivity(sendIntent)
//        } catch (e: ActivityNotFoundException) {
//            // Define what your app should do if no activity can handle the intent.
//        }

        val intent = Intent().apply {
            action = Intent.ACTION_CREATE_DOCUMENT
            type = "application/pdf"
            putExtra(Intent.EXTRA_TITLE, "New file for MyReaderApplication")
        }

//        startActivityForResult(intent, CREATE_DOCUMENT)

        val intent1 = Intent(this, DetailsActivity::class.java).apply {
            putExtra("FILE_NAME", "New file for MyReaderApplication")
            bundleOf("FILE_NAME" to "New file for MyReaderApplication")
        }
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            Toast.makeText(this, it.data?.getStringExtra("FILE_NAME"), Toast.LENGTH_LONG).show()
        }.launch(intent1)

//        startActivityForResult(intent, CREATE_DOCUMENT)


//        registerForActivityResult(
//            ActivityResultContracts.CreateDocument("application/pdf")
//        ) {
//            Toast.makeText(this, it?.toString(), Toast.LENGTH_LONG).show()
//        }.launch("New file for MyReaderApplication")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            CREATE_DOCUMENT ->{
                data?.let{
                    Toast.makeText(this,it.data.toString(),Toast.LENGTH_LONG).show()
                }
            }
        }

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